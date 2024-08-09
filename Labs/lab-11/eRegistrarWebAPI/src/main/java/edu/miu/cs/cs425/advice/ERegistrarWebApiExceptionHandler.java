package edu.miu.cs.cs425.advice;

import edu.miu.cs.cs425.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ERegistrarWebApiExceptionHandler {

    @ExceptionHandler({StudentNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleStudentNotFoundException(StudentNotFoundException ex){
        Map<String, String> map = new HashMap<>();
        map.put("Error Message", ex.getMessage());
        return map;
    }
}
