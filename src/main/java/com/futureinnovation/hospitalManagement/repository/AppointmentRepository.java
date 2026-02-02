package com.futureinnovation.hospitalManagement.repository;

import com.futureinnovation.hospitalManagement.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
}