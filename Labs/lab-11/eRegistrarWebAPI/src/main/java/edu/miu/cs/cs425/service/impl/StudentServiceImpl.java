package edu.miu.cs.cs425.service.impl;

import edu.miu.cs.cs425.dto.request.StudentRequest;
import edu.miu.cs.cs425.dto.response.StudentResponse;
import edu.miu.cs.cs425.exception.StudentNotFoundException;
import edu.miu.cs.cs425.model.Student;
import edu.miu.cs.cs425.respository.StudentRepository;
import edu.miu.cs.cs425.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final ModelMapper modelMapper;
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<StudentResponse> getAllStudents() {
        return studentRepository.findAll().
                stream().
                map(student -> modelMapper.map(student, StudentResponse.class)).
                toList();
    }

    @Override
    public StudentResponse addNewStudent(StudentRequest studentRequest) {
        var student = modelMapper.map(studentRequest, Student.class);
        studentRepository.save(student);
        return modelMapper.map(student, StudentResponse.class);
    }

    @Override
    public StudentResponse getStudentById(Integer studentId) throws StudentNotFoundException {
        var student = studentRepository.findById(studentId).
                orElseThrow(() -> new StudentNotFoundException(String.format("Student with id number %d not found",studentId)));
        return modelMapper.map(student, StudentResponse.class);
    }

    @Override
    public void deleteStudentById(Integer studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public StudentResponse updateStudentById(StudentRequest editedStudent, Integer studentId) throws StudentNotFoundException{
        var student = studentRepository.findById(studentId).
                orElseThrow(() ->
                        new StudentNotFoundException(String.format("Student with id number %d not found",studentId)));

        student.setStudentNumber(editedStudent.getStudentNumber());
        student.setFirstName(editedStudent.getFirstName());
        student.setMiddleName(editedStudent.getMiddleName());
        student.setLastName(editedStudent.getLastName());
        student.setCgpa(editedStudent.getCgpa());
        student.setEnrollmentDate(editedStudent.getEnrollmentDate());
        student.setIsInternational(editedStudent.getIsInternational());
        studentRepository.save(student);

        return modelMapper.map(student, StudentResponse.class);
    }
}
