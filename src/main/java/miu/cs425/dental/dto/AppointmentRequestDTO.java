package miu.cs425.dental.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public record AppointmentRequestDTO(
        LocalDate appointmentDate,
        LocalTime appointmentTime,
        String dentistName,
        String surgeryLocation,
        String patientNumber
) {
}
