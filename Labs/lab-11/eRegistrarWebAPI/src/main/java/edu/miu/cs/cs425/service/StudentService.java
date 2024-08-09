package edu.miu.cs.cs425.service;

import edu.miu.cs.cs425.dto.request.StudentRequest;
import edu.miu.cs.cs425.dto.response.StudentResponse;
import edu.miu.cs.cs425.exception.StudentNotFoundException;

import java.util.List;

public interface StudentService {

    List<StudentResponse> getAllStudents();
    StudentResponse addNewStudent(StudentRequest studentRequest);
    StudentResponse getStudentById(Integer studentId) throws StudentNotFoundException;
    void deleteStudentById(Integer studentId);
    StudentResponse updateStudentById(StudentRequest editedStudent, Integer studentId) throws StudentNotFoundException;
}
