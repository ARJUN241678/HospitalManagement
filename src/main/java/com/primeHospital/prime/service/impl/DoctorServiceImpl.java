package com.primeHospital.prime.service.impl;

import com.primeHospital.prime.Entity.Doctor;
import com.primeHospital.prime.Repository.DoctorRepository;
import com.primeHospital.prime.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DoctorServiceImpl  implements DoctorService {
    private final DoctorRepository doctorRepository;
@Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Doctor createDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + id));
    }
    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor updateDoctor(Long id, Doctor doctor) {
        Doctor existingDoctor = getDoctorById(id);
        existingDoctor.setFirstName(doctor.getFirstName());
        existingDoctor.setLastName(doctor.getLastName());
        existingDoctor.setSpecialization(doctor.getSpecialization());
        existingDoctor.setContactNumber(doctor.getContactNumber());
        existingDoctor.setEmail(doctor.getEmail());
        return doctorRepository.save(existingDoctor);
    }

    @Override
    public void deleteDoctor(Long id) {
        if (doctorRepository.existsById(id)) {
            doctorRepository.deleteById(id);
        } else {
            throw new RuntimeException("Doctor not found with id: " + id);
        }
    }
    @Override
    public void addSchedule(Long doctorId, List<String> schedule) {
        Doctor doctor = getDoctorById(doctorId);
        doctor.getSchedule().addAll(schedule);
        doctorRepository.save(doctor);
    }

    @Override
    public void removeSchedule(Long doctorId, String timeSlot) {
        Doctor doctor = getDoctorById(doctorId);
        doctor.getSchedule().remove(timeSlot);
        doctorRepository.save(doctor);
    }
}
