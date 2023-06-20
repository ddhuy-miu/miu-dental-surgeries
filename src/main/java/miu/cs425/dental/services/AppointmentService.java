package miu.cs425.dental.services;

import miu.cs425.dental.dto.AppointmentResponseDTO;
import miu.cs425.dental.dto.PatientRequestDTO;

import java.util.List;

public interface AppointmentService {
    List<AppointmentResponseDTO> getVIPAppointments();

    List<AppointmentResponseDTO> getUpcomingAppointments();

}
