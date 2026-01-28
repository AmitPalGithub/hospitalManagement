package com.futureinnovation.hospitalManagement;


import com.futureinnovation.hospitalManagement.dto.BloodGroupCountResponseEntity;
import com.futureinnovation.hospitalManagement.entity.Patient;
import com.futureinnovation.hospitalManagement.entity.type.BloodGroupType;
import com.futureinnovation.hospitalManagement.repository.PatientRepository;
import com.futureinnovation.hospitalManagement.service.PatientService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

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

//        System.out.println(patient);

//        List<Patient> patientList= patientRepository.findByBirthDateOrEmail(LocalDate.parse("1996-08-22"),"arav.sharma@gmail.com");
//        for(Patient p:patientList){
//            System.out.println(p);
//        }

//        List<Patient> patientList2 = patientRepository.findByBirthDateBetween(LocalDate.of(1988,03,10), LocalDate.parse("1996-08-22"));
//        for(Patient patient:patientList2){
//            System.out.println(patient);
//        }

//        List<Patient> patientList3 = patientRepository.findByBloodGroup(BloodGroupType.A_POSITIVE);
//        for (Patient patient:patientList3){
//            System.out.println(patient);
//        }

//        List<Patient> patientList = patientRepository.findByBornAfterDate(LocalDate.of(1988, 06, 10));
//        for (Patient patient : patientList){
//            System.out.println(patient);
//        }

//        List<Object[]> bloodGroupList = patientRepository.countEachBloodGroupType();
//        for (Object[] objects : bloodGroupList) {
//            System.out.println(objects[0] +" "+objects[1]);
//        }

//        List<BloodGroupCountResponseEntity> bloodGroupCount = patientRepository.countEachBloodGroupType();
//        for(BloodGroupCountResponseEntity bloodGroup : bloodGroupCount) {
//            System.out.println(bloodGroup);
//        }

//        List<Patient> patientList= patientRepository.findAllPatients();
//        for (Patient p:patientList){
//            System.out.println(p);
//        }

//        int updatedrow = patientRepository.updatedNameWithId("Arav Bhusan Sharma", 1L);
//        System.out.println(updatedrow);

        Page<Patient> patientList = patientRepository.findAllPatientsUsingPagination(PageRequest.of(1, 2, Sort.by("name")));
        for (Patient patient : patientList.getContent()) {
            System.out.println(patient);
        }
    }
}

















