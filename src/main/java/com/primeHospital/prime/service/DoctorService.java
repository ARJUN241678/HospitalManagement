package com.primeHospital.prime.service;

import com.primeHospital.prime.Entity.Doctor;

import java.util.List;

public interface DoctorService {
    Doctor createDoctor(Doctor doctor);
    Doctor getDoctorById(Long id);
    List<Doctor> getAllDoctors();
    Doctor updateDoctor(Long id, Doctor doctor);
    void deleteDoctor(Long id);

    // New methods
    void addSchedule(Long doctorId, List<String> schedule);
    void removeSchedule(Long doctorId, String timeSlot);

}
