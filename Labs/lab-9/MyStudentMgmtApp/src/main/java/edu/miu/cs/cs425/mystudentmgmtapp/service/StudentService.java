package edu.miu.cs.cs425.mystudentmgmtapp.service;

import edu.miu.cs.cs425.mystudentmgmtapp.model.Student;

import java.util.List;

public interface StudentService {

    Student saveStudent(Student student);
    void updateStudentName(Long studentId, String newName);
    List<Student> getAllStudents();
}
