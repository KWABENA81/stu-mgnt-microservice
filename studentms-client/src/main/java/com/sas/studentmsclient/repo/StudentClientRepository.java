package com.sas.studentmsclient.repo;

import com.sas.studentmsclient.model.StudentClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentClientRepository extends JpaRepository<StudentClient, Integer> {
}
