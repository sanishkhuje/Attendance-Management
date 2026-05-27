package com.example.attendanceapp.controller;

import com.example.attendanceapp.dto.StudentRequest;
import com.example.attendanceapp.entity.Role;
import com.example.attendanceapp.entity.User;

import com.example.attendanceapp.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/teacher")

public class TeacherController {

    @Autowired

    UserRepository userRepository;

    @PostMapping("/student")

    public User addStudent(

            @RequestBody
            StudentRequest request){

        User student =
                new User();

        student.setName(
                request.getName());

        student.setEmail(
                request.getEmail());

        student.setPassword(
                request.getPassword());

        student.setRole(
                Role.Student);

        return userRepository
                .save(student);
    }


    @GetMapping("/students")

    public List<User>
    getStudents(){

        return userRepository
                .findAll()

                .stream()

                .filter(
                        x ->
                                x.getRole()
                                        == Role.Student)

                .toList();
    }


    @PutMapping(
            "/student/{id}")

    public User updateStudent(

            @PathVariable
            Long id,

            @RequestBody
            StudentRequest request){

        User student = userRepository.findById(id).orElseThrow();

        student.setName(request.getName());

        student.setEmail(request.getEmail());

        student.setPassword(request.getPassword());

        if(userRepository.findByEmail(request.getEmail()).isPresent()){

            throw new RuntimeException(
                    "Email already exists");
        }

        return userRepository
                .save(student);

    }


    @DeleteMapping(
            "/student/{id}")

    public String deleteStudent(

            @PathVariable
            Long id){

        userRepository
                .deleteById(id);

        return "Deleted";
    }

}