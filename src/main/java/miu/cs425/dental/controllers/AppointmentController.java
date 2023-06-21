package miu.cs425.dental.controllers;

import miu.cs425.dental.dto.AppointmentRequestDTO;
import miu.cs425.dental.dto.AppointmentResponseDTO;
import miu.cs425.dental.models.Patient;
import miu.cs425.dental.services.AppointmentService;
import miu.cs425.dental.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/appointments")
public class AppointmentController {
    @Autowired
    private AppointmentService service;

    @Autowired
    private PatientService patientService;

    @GetMapping(value = {""})
    public ResponseEntity<List<AppointmentResponseDTO>> listAppointments() {
        return ResponseEntity.ok(service.getVIPAppointments());
    }

    @GetMapping(value = {"/vip"})
    public ResponseEntity<List<AppointmentResponseDTO>> listVIPAppointments() {
        return ResponseEntity.ok(service.getVIPAppointments());
    }

    @GetMapping(value = {"/upcoming"})
    public ResponseEntity<List<AppointmentResponseDTO>> listUpcomingAppointments() {
        return ResponseEntity.ok(service.getUpcomingAppointments());
    }

    @PostMapping(value = {""})
    public ResponseEntity<AppointmentResponseDTO> bookAppointment(@RequestBody AppointmentRequestDTO requestDTO) {
        String patientNumber = requestDTO.patientNumber();
        Patient patient = patientService.findByPatientNumber(patientNumber);
        System.out.println(patientNumber);
        System.out.println(patient);
        if (patient == null)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        AppointmentResponseDTO appointmentResponseDTO = service.bookAppointment(requestDTO, patient);
        return new ResponseEntity<>(appointmentResponseDTO, HttpStatus.CREATED);
    }
}
