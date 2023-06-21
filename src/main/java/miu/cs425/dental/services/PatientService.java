package miu.cs425.dental.services;


import miu.cs425.dental.dto.PatientRequestDTO;
import miu.cs425.dental.dto.PatientResponseDTO;
import miu.cs425.dental.models.Patient;

import java.util.List;

public interface PatientService {
    Patient findByPatientNumber(String patientNumber);

    List<PatientResponseDTO> getAllPatients();

    PatientResponseDTO registerNewPatient(PatientRequestDTO patientRequestDTO);

}
