package edu.miu.cs.cs425.mystudentmgmtapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long studentId;
    @NotBlank(message = "cannot be null or empty")
    private String studentNumber;
    @NotBlank(message = "cannot be null or empty")
    private String fistName;
    private String middleName;
    @NotBlank(message = "cannot be null or empty")
    private String lastName;
    private double cgpa;
    private LocalDate dateOfEnrollment;

    @OneToOne
    @JoinColumn(name = "transcript_id")
    private Transcript transcript;

    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;

    @ManyToMany
    @JoinTable(
                name = "student_courses",
                joinColumns = @JoinColumn(name = "student_id"),
                inverseJoinColumns = @JoinColumn(name = "course_id")  )
    private List<Course> courses;
}
