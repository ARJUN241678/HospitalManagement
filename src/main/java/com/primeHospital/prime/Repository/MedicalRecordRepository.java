package com.primeHospital.prime.Repository;

import com.primeHospital.prime.Entity.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalRecordRepository  extends JpaRepository<MedicalRecord,Long> {
}
