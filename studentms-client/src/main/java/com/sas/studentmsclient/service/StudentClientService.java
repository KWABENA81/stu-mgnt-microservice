package com.sas.studentmsclient.service;

import com.sas.studentmsclient.model.StudentClient;
import com.sas.studentmsclient.repo.StudentClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StudentClientService implements IStudentClientService {
    @Autowired
    private StudentClientRepository studentClientRepository;

    public StudentClient handleStudent(StudentClient studentClient) {
        studentClient.setTransactionId(UUID.randomUUID().toString().replace("-", ""));
        return studentClientRepository.save(studentClient);
    }
}
