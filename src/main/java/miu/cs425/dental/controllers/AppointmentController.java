package miu.cs425.dental.controllers;

import miu.cs425.dental.dto.AppointmentResponseDTO;
import miu.cs425.dental.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/ams/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    @GetMapping(value = {"/vip/list"})
    public ResponseEntity<List<AppointmentResponseDTO>> listVIPAppointments() {
        return ResponseEntity.ok(service.getVIPAppointments());
    }
}
