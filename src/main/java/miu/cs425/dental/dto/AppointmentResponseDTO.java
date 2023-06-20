package miu.cs425.dental.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public record AppointmentResponseDTO(
        Long appointmentId,
        LocalDate appointmentDate,
        LocalTime appointmentTime,
        String dentistName,
        String surgeryLocation,
        PatientResponseDTO patient
) {
}
