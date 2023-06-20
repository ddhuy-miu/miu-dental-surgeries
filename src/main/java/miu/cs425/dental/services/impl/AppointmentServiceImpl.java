package miu.cs425.dental.services.impl;

import miu.cs425.dental.dto.AppointmentResponseDTO;
import miu.cs425.dental.dto.PatientResponseDTO;
import miu.cs425.dental.models.Appointment;
import miu.cs425.dental.repositories.AppointmentRepository;
import miu.cs425.dental.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    AppointmentRepository repository;

    @Override
    public List<AppointmentResponseDTO> getVIPAppointments() {
        return repository.findAll()
                .stream()
                .filter(Appointment::isVIP)
                .sorted(Comparator.comparing(Appointment::getAppointmentDate)
                        .thenComparing(Appointment::getAppointmentTime))
                .map(appointment -> new AppointmentResponseDTO(
                        appointment.getAppointmentId(),
                        appointment.getAppointmentDate(),
                        appointment.getAppointmentTime(),
                        appointment.getDentistName(),
                        appointment.getSurgeryLocation(),
                        new PatientResponseDTO(
                                appointment.getPatient().getPatientId(),
                                appointment.getPatient().getPatientNumber(),
                                appointment.getPatient().getFirstName(),
                                appointment.getPatient().getLastName(),
                                appointment.getPatient().getDateOfBirth()
                        )
                )).toList();
    }
}
