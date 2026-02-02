package com.futureinnovation.hospitalManagement.service;


import com.futureinnovation.hospitalManagement.entity.Appointment;
import com.futureinnovation.hospitalManagement.entity.Doctor;
import com.futureinnovation.hospitalManagement.entity.Patient;
import com.futureinnovation.hospitalManagement.repository.AppointmentRepository;
import com.futureinnovation.hospitalManagement.repository.DoctorRepository;
import com.futureinnovation.hospitalManagement.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;


    @Transactional
    public Appointment createAppointment(Appointment appointment, Long patientId, Long doctorId) {

        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        patient.getAppointments().add(appointment);   // to maintain bidirectional consistency

        return appointmentRepository.save(appointment);
    }
}
