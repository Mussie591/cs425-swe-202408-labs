package edu.miu.cs.cs425.mystudentmgmtapp.repository;

import edu.miu.cs.cs425.mystudentmgmtapp.model.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository  extends JpaRepository<Student, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Student s SET s.fistName = :newName WHERE s.studentId = :studentId")
    void updateStudentName(Long studentId, String newName);
}
