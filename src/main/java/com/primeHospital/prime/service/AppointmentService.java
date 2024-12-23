package com.primeHospital.prime.service;

import com.primeHospital.prime.Entity.Appointment;

import java.util.List;

public interface AppointmentService {
    Appointment createAppointment(Appointment appointment);
    Appointment getAppointmentById(Long id);
    List<Appointment> getAllAppointments();
    Appointment updateAppointment(Long id, Appointment appointment);
    void deleteAppointment(Long id);
    List<Appointment> getAppointmentsByDoctor(Long doctorId);
    List<Appointment> getAppointmentsByPatient(Long patientId);
}