package miu.cs425.dental.services;

import miu.cs425.dental.dto.AppointmentRequestDTO;
import miu.cs425.dental.dto.AppointmentResponseDTO;
import miu.cs425.dental.models.Patient;

import java.util.List;

public interface AppointmentService {
    List<AppointmentResponseDTO> getAppointments();

    List<AppointmentResponseDTO> getVIPAppointments();

    List<AppointmentResponseDTO> getUpcomingAppointments();

    AppointmentResponseDTO bookAppointment(AppointmentRequestDTO requestDTO, Patient patient);
}
