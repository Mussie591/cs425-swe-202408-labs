package edu.miu.cs.cs425.controller;

import edu.miu.cs.cs425.dto.request.StudentRequest;
import edu.miu.cs.cs425.dto.response.StudentResponse;
import edu.miu.cs.cs425.exception.StudentNotFoundException;
import edu.miu.cs.cs425.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("registrar/api/v1/students")
public class StudentController {


    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<StudentResponse>> getAllStudents(){
        return ResponseEntity.ok(studentService.getAllStudents());
    }


    @PostMapping
    public ResponseEntity<StudentResponse> addNewStudent(@Valid  @RequestBody StudentRequest studentRequest){
        var studentResponse = studentService.addNewStudent(studentRequest);
        return new ResponseEntity<>(studentResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentResponse> getStudentById(@Valid @PathVariable Integer studentId) throws StudentNotFoundException {
        var studentResponse = studentService.getStudentById(studentId);
        return new ResponseEntity<>(studentResponse, HttpStatus.OK);
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<StudentResponse> updateStudentById(@Valid @RequestBody StudentRequest editedStudent, @PathVariable Integer studentId) throws StudentNotFoundException{
        var studentResponse = studentService.updateStudentById(editedStudent, studentId);
        return new ResponseEntity<>(studentResponse, HttpStatus.OK);
    }


    @DeleteMapping("/{studentId}")
    public void deleteStudentById(@PathVariable Integer studentId){
        studentService.deleteStudentById(studentId);
    }

}
