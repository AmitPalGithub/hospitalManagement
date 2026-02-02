package com.futureinnovation.hospitalManagement;


import com.futureinnovation.hospitalManagement.entity.Insurance;
import com.futureinnovation.hospitalManagement.entity.Patient;
import com.futureinnovation.hospitalManagement.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class InsuranceTest {

    @Autowired
    private InsuranceService insuranceService;

    @Test
    public void testInsurance(){
        Insurance insurance = Insurance.builder()
                .policyNumber("HDFC_1234")
                .provider("HDFC")
                .validUntil(LocalDate.of(2030,12,12))
                .build();

        Patient patient= insuranceService.assignInsuranceToPatient(insurance, 1L);
        System.out.println(patient);
    }
}
