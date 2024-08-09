package edu.miu.cs.cs425.model;

import edu.miu.cs.cs425.Enum.InternationalStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;
    @NotBlank(message = "cannot be null or empty")
    private String studentNumber;
    @Column(name = "FirstName")
    @NotBlank(message = "cannot be null or empty")
    private String firstName;
    @Column(name = "MiddleName")
    private String middleName;
    @Column(name = "LastName")
    @NotBlank(message = "cannot be null or empty")
    private String lastName;
    private Double cgpa;
    @Column(nullable = false)
    private LocalDate enrollmentDate;
    @Column(nullable = false)
    private InternationalStatus isInternational;
}

