package edu.miu.cs.cs425.dto.response;
import edu.miu.cs.cs425.Enum.InternationalStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentResponse {
    Integer studentId;
    String studentNumber;
    String firstName;
    String middleName;
    String lastName;
    Double cgpa;
    LocalDate enrollmentDate;
    InternationalStatus isInternational;
}

