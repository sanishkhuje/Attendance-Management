package com.example.attendanceapp.controller;

import com.example.attendanceapp.entity.Attendance;

import com.example.attendanceapp.repository
        .AttendanceRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")

@RestController

@RequestMapping("/attendance")

public class AttendanceController {

    @Autowired

    AttendanceRepository
            attendanceRepository;


    @PostMapping("/mark")
    public ResponseEntity<?> markAttendance(@RequestBody Attendance attendance) {

        LocalDate today = LocalDate.now(); // ✅ correct way

        boolean exists = attendanceRepository.existsByStudentIdAndDate(
                attendance.getStudentId(),
                today
        );

        if (exists) {
            return ResponseEntity
                    .badRequest()
                    .body("Attendance already marked for today");
        }

        attendance.setDate(today);

        return ResponseEntity.ok(attendanceRepository.save(attendance));
    }

    @GetMapping(
            "/student/{id}")

    public List<Attendance>

    getAttendance(

            @PathVariable
            Long id){

        return attendanceRepository

                .findByStudentId(
                        id);

    }


}