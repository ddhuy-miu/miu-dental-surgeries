package miu.cs425.dental.services.impl;

import miu.cs425.dental.dto.PatientRequestDTO;
import miu.cs425.dental.dto.PatientResponseDTO;
import miu.cs425.dental.models.Patient;
import miu.cs425.dental.repositories.PatientRepository;
import miu.cs425.dental.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepository repository;

    @Override
    public PatientResponseDTO registerNewPatient(PatientRequestDTO requestDTO) {
        Patient patient = new Patient(
                requestDTO.patientNumber(),
                requestDTO.firstName(),
                requestDTO.lastName(),
                requestDTO.dateOfBirth()
        );
        repository.save(patient);
        return new PatientResponseDTO(
                patient.getPatientId(),
                patient.getPatientNumber(),
                patient.getFirstName(),
                patient.getLastName(),
                patient.getDateOfBirth()
        );
    }
}
