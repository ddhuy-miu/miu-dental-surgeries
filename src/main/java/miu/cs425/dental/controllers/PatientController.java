package miu.cs425.dental.controllers;

import miu.cs425.dental.dto.PatientRequestDTO;
import miu.cs425.dental.dto.PatientResponseDTO;
import miu.cs425.dental.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/patients")
public class PatientController {
    @Autowired
    private PatientService service;

    @GetMapping
    public ResponseEntity<List<PatientResponseDTO>> getAllPatients() {
        return ResponseEntity.ok(service.getAllPatients());
    }

    @PostMapping(value = {"/register"})
    public ResponseEntity<PatientResponseDTO> registerNewPatient(@RequestBody PatientRequestDTO requestDTO) {
        return new ResponseEntity<>(service.registerNewPatient(requestDTO), HttpStatus.CREATED);
    }
}
