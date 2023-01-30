package com.sas.studentmsclient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Data
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "STUDENT_CLIENT_TB")
public class StudentClient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;
    private String studentId;

    private Double tuition;

    public void setTransactionId(String replace) {
        log.info("INSIDE StudentClient.setTransactionId");
    }
}
