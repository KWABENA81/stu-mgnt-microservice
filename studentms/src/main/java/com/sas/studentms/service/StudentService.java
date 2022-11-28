package com.sas.studentms.service;

import com.sas.studentms.model.Student;
import com.sas.studentms.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StudentService implements IStudentService {

    @Autowired
    StudentRepository studentRepository;


//    @Override
//    public boolean delete(Integer id) {
//        return studentRepository.delete(id);
//    }

//    @Override
//    public Set<Student> all() {
//        return findAll().stream().collect(Collectors.toSet());
//    }

    @Override
    public Collection<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Integer id) {
        Optional<Student> studentOption = studentRepository.findById(id);
        return (studentOption.isPresent())
                ? studentOption.get() : studentOption.orElseThrow();
    }

    public Student findByStudentId(String studentId) {
        Optional<Student> studentOptional = studentRepository.findByStudentId(studentId);
        return (studentOptional.isPresent()) ? studentOptional.get() : studentOptional.orElseThrow();
    }

//    @Override
//    public Student create(Student student) {
//        return (student.getId() == null) ? studentRepository.save(student) : null;
//    }

//    @Override
//    public Student update(Student student) {
//        Optional<Student> studentOptional = studentRepository.findById(student.getId());
//        if (studentOptional.isPresent()) {
//            Student student_db = studentOptional.get();
//
//            student_db.setStudentId(student.getStudentId());
//            student_db.setLastName(student.getLastName());
//            student_db.setFirstName(student.getFirstName());
//            return studentRepository.save(student_db);
//        } else
//            return studentOptional.orElseThrow();
//    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }
}
