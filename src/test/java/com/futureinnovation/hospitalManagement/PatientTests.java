package com.futureinnovation.hospitalManagement;


import com.futureinnovation.hospitalManagement.entity.Patient;
import com.futureinnovation.hospitalManagement.repository.PatientRepository;
import com.futureinnovation.hospitalManagement.service.PatientService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PatientTests {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatientRepository(){
        List<Patient> patientList= patientRepository.findAll();
        System.out.println(patientList);

        Patient p1 = new Patient();
        patientRepository.save(p1);
    }

    @Test
    public void testTransactionMethods(){
//        Patient patient = patientService.getPatientById(4L);

//        Patient patient = patientRepository.findById(10L).orElseThrow(() ->
//                                        new EntityNotFoundException("Patient not found"));

//        Patient patient = patientRepository.findByName("Neha Kumari");

        List<Patient> patientList= patientRepository.findByBirthDateOrEmail(LocalDate.parse("1996-08-22"),"arav.sharma@gmail.com");
        for(Patient p:patientList){
            System.out.println(p);
        }


//        System.out.println(patient);
    }

}

















