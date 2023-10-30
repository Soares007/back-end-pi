package fatec.sp.gov.br.sistemaescolarbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fatec.sp.gov.br.sistemaescolarbackend.dtos.StudentRequest;
import fatec.sp.gov.br.sistemaescolarbackend.entities.Student;
import fatec.sp.gov.br.sistemaescolarbackend.repositories.StudentRepository;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public void update(long id, StudentRequest student) {
        try {
            var updateStudent = this.studentRepository.getReferenceById(id);
            updateStudent.setUser_name(student.user_name());
            updateStudent.setPassword(student.password());
            updateStudent.setFull_name(student.full_name());
            updateStudent.setEmail(student.email());
            this.studentRepository.save(updateStudent);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Student not found");
        }
    }
}

