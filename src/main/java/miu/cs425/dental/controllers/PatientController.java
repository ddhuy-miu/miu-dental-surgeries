package miu.cs425.dental.controllers;

import miu.cs425.dental.dto.PatientRequestDTO;
import miu.cs425.dental.dto.PatientResponseDTO;
import miu.cs425.dental.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ams/api/patients")
public class PatientController {
    @Autowired
    private PatientService service;

    @PostMapping(value = {"/register"})
    public ResponseEntity<PatientResponseDTO> registerNewPatient(@RequestBody PatientRequestDTO requestDTO) {
        return new ResponseEntity<>(service.registerNewPatient(requestDTO), HttpStatus.CREATED);
    }
}
