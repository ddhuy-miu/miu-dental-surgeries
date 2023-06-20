package miu.cs425.dental.services;

import miu.cs425.dental.dto.AppointmentResponseDTO;

import java.util.List;

public interface AppointmentService {
    List<AppointmentResponseDTO> getVIPAppointments();
}
