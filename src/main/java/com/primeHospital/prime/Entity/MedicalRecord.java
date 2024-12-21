package com.primeHospital.prime.Entity;

import jakarta.persistence.*;


import java.time.LocalDate;

@Entity
@Table(name="medicalrecords")


public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    private String diagnosis;
    private String prescription;
    private String testResults;
    private String notes;
    private LocalDate recordDate;

}
