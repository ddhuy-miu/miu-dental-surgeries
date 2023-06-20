package miu.cs425.dental.services;


import miu.cs425.dental.dto.PatientRequestDTO;
import miu.cs425.dental.dto.PatientResponseDTO;

public interface PatientService {
    PatientResponseDTO registerNewPatient(PatientRequestDTO patientRequestDTO);

}
