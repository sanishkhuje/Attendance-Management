package com.example.attendanceapp.repository;

import com.example.attendanceapp.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

import java.util.Date;
import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    boolean existsByStudentIdAndDate(Long studentId, LocalDate date);

    List<Attendance> findByStudentId(Long studentId);
}