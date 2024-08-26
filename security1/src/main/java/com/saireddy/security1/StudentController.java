package com.saireddy.security1;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    private List students = new ArrayList<>(List.of(
            new Student ( 1, "naveen",120),
            new Student(2,"sai",110),
            new Student(3,"laxmi",100)
    ));

    @GetMapping("/students")
    public List<Student> getStudents (){
            return  students;
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student){
         students.add(student);
         return student;
    }
}
