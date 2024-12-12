package com.primeHospital.prime.service.impl;

import com.primeHospital.prime.Entity.Patient;
import com.primeHospital.prime.Repository.PatientRepository;
import com.primeHospital.prime.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
    @Override
    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient updatePatient(Long id, Patient patient) {
     Patient existingPatient = getPatientById(id);
        existingPatient.setFirstName(patient.getFirstName());
        existingPatient.setLastName(patient.getLastName());
        existingPatient.setGender(patient.getGender());
        existingPatient.setContactNumber(patient.getContactNumber());
        existingPatient.setEmail(patient.getEmail());
        existingPatient.setEmergencyContact(patient.getEmergencyContact());
        existingPatient.setDateOfBirth(patient.getDateOfBirth());
        return patientRepository.save(existingPatient);
    }

    @Override
    public void deletePatient(Long id) {
        if (patientRepository.existsById(id)) {
            patientRepository.deleteById(id);
        } else {
            throw new RuntimeException("Patient not found with id: " + id);
        }
    }

}
