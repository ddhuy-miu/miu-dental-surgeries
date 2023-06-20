package miu.cs425.dental.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.Period;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patientId;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Patient Number is required!")
    private String patientNumber;

    @Column(nullable = false)
    @NotBlank(message = "Patient First Name is required!")
    private String firstName;

    @Column(nullable = false)
    @NotBlank(message = "Patient Last Name is required!")
    private String lastName;

    @Column(nullable = false)
    @NotBlank(message = "Patient DoB is required!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    public Boolean isElder() {
        var age = Period.between(dateOfBirth, LocalDate.now()).getYears();
        return age >= 65;
    }
}
