package com.futureinnovation.hospitalManagement;


import com.futureinnovation.hospitalManagement.entity.Appointment;
import com.futureinnovation.hospitalManagement.repository.AppointmentRepository;
import com.futureinnovation.hospitalManagement.service.AppointmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class AppointmentTest {

    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void testCreateAddAppointment() {
        Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2025, 11, 1, 14, 0, 0))
                .reason("Cancer")
                .build();

        var newAppointment = appointmentService.createAppointment(appointment, 1L, 2L);

        System.out.println(newAppointment);
    }
}
