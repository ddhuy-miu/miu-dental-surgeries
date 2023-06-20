package miu.cs425.dental.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jdk.jfr.Enabled;
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
    @NotBlank(message = "Appointment Date is required!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate appointmentDate;

    @Column(nullable = false)
    @NotBlank(message = "Appointment Time is required!")
    @DateTimeFormat(pattern = "hh:mm:ss")
    private LocalTime appointmentTime;

    @Column(nullable = true)
    private String dentistName;

    @Column(nullable = true)
    private String surgeryLocation;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patientId", nullable = false)
    private Patient patient;

    public Boolean isVIP() {
        return patient.isElder();
    }

    public Boolean isUpcoming() {
        return !appointmentDate.isBefore(LocalDate.now());
    }
}
