package miu.cs425.dental.services.impl;

import miu.cs425.dental.dto.AppointmentRequestDTO;
import miu.cs425.dental.dto.AppointmentResponseDTO;
import miu.cs425.dental.dto.PatientResponseDTO;
import miu.cs425.dental.models.Appointment;
import miu.cs425.dental.models.Patient;
import miu.cs425.dental.repositories.AppointmentRepository;
import miu.cs425.dental.repositories.PatientRepository;
import miu.cs425.dental.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    AppointmentRepository appointmentRepository;

    @Override
    public List<AppointmentResponseDTO> getAppointments() {
        return appointmentRepository.findAll()
                .stream()
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

    @Override
    public List<AppointmentResponseDTO> getVIPAppointments() {
        return appointmentRepository.findAll()
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

    @Override
    public List<AppointmentResponseDTO> getUpcomingAppointments() {
        return appointmentRepository.findAll()
                .stream()
                .filter(Appointment::isUpcoming)
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

    @Override
    public AppointmentResponseDTO bookAppointment(AppointmentRequestDTO requestDTO, Patient patient) {
        Appointment appointment = new Appointment(
                requestDTO.appointmentDate(),
                requestDTO.appointmentTime(),
                requestDTO.dentistName(),
                requestDTO.surgeryLocation(),
                patient
        );
        appointmentRepository.save(appointment);
        return new AppointmentResponseDTO(
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
        );
    }
}
