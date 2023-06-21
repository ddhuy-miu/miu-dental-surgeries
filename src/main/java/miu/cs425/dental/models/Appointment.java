package miu.cs425.dental.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate appointmentDate;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "hh:mm:ss")
    private LocalTime appointmentTime;

    @Column(nullable = true)
    private String dentistName;

    @Column(nullable = true)
    private String surgeryLocation;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patientId", nullable = false)
    private Patient patient;

    public Appointment(LocalDate appointmentDate, LocalTime appointmentTime, String dentistName, String surgeryLocation, Patient patient) {
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.dentistName = dentistName;
        this.surgeryLocation = surgeryLocation;
        this.patient = patient;
    }

    public Boolean isVIP() {
        return patient.isElder();
    }

    public Boolean isUpcoming() {
        return !appointmentDate.isBefore(LocalDate.now());
    }
}
