package com.example.attendanceapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Setter
@Getter
@Entity

public class Attendance {

    @Id
    @GeneratedValue(
            strategy =
                    GenerationType.IDENTITY)

    private Long id;

    private Long studentId;

    private LocalDate date;

    private String status;

    public Attendance() {
    }

}