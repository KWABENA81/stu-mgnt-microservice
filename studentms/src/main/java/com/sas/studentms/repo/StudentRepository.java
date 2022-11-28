package com.sas.studentms.repo;

import com.sas.studentms.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query("SELECT s FROM Student s WHERE s.firstName=(:firstName)")
    List<Student> findByFirstName(@Param("firstName") String firstName);

    @Query("SELECT s FROM Student s WHERE s.lastName=(:lastName)")
    List<Student> findByLastName(@Param("lastName") String lastName);

    @Query("SELECT s FROM Student s WHERE s.studentId=(:studentId)")
    Optional<Student> findByStudentId(@Param("studentId") String studentId);

//    boolean delete(Integer id);
}
