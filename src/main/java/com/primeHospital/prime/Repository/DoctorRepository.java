package com.primeHospital.prime.Repository;

import com.primeHospital.prime.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
}
