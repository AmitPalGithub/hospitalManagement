package com.futureinnovation.hospitalManagement.service;


import com.futureinnovation.hospitalManagement.entity.Insurance;
import com.futureinnovation.hospitalManagement.entity.Patient;
import com.futureinnovation.hospitalManagement.repository.InsuranceRepository;
import com.futureinnovation.hospitalManagement.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final PatientRepository  patientRepository;

    @Transactional
    public Patient assignInsuranceToPatient(Insurance insurance, Long patientId) {

        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with id: "+patientId));

        patient.setInsurance(insurance);

        insurance.setPatient(patient); // bidirectional consistency maintainence

        return patient;
    }
}
