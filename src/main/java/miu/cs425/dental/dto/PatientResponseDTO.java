package miu.cs425.dental.dto;

import java.time.LocalDate;

public record PatientResponseDTO(
        Integer patientId,
        String patientNumber,
        String firstName,
        String lastName,
        LocalDate dateOfBirth
) {
}
