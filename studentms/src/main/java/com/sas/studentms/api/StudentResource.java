package com.sas.studentms.api;

import com.sas.studentms.model.Student;
import com.sas.studentms.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/student")
public class StudentResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentResource.class);

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<Student> students() {
        return studentService.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/{id}")   //  ("/students/{id}")
    public ResponseEntity<Student> findStudentById(@PathVariable Integer id) {
        Student studentOpt = studentService.findById(id);
        if (studentOpt != null) {
            LOGGER.info("Student found with id {}", id);
            return ResponseEntity.ok(studentOpt);
        }
        LOGGER.error("Student not found with id {}", id);
        return ResponseEntity.notFound().build();
    }


    //    @DeleteMapping("/students/{id}")
//    public ResponseEntity<Integer> deleteStudentById(@PathVariable Integer id) {
//        boolean isRemoved = studentService.delete(id);
//        if (!isRemoved) {
//            LOGGER.info("Student not found with id {}", id);
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        LOGGER.info("Student with #id {} has been deleted", id);
//        return new ResponseEntity<>(id, HttpStatus.OK);
//    }
    @PostMapping("/register")
    public Student register(@RequestBody Student student) {
        log.info("register student {}",student);
        return studentService.saveRegistration(student);
    }

//    @GetMapping("/students/{studentid}")
//    public ResponseEntity<Student> findByStudentId(@PathVariable String studentId) {
//        Student student = studentService.findByStudentId(studentId);
//        if (student != null) {
//            LOGGER.info("Student found with student id {}", studentId);
//            return ResponseEntity.ok(student);
//        }
//        LOGGER.error("Student not found with student id {}", studentId);
//        return ResponseEntity.notFound().build();
//    }

    @PostMapping("/student")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) throws URISyntaxException {
        Student studentSaved = studentService.save(student);
        return ResponseEntity.created(new URI(studentSaved.getId().toString())).body(studentSaved);
    }

    @PutMapping("/{id}")   //("/students/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable Integer id) {
        Student student_db = studentService.findById(id);
        if (student_db != null) {

            student_db.setFirstName(student.getFirstName());
            student_db.setLastName(student.getLastName());
            student_db.setStudentId(student.getStudentId());

            return studentService.save(student_db);
        } else {
            student.setId(id);
            return studentService.save(student);
        }
    }
}
