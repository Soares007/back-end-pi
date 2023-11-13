package fatec.sp.gov.br.sistemaescolarbackend.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fatec.sp.gov.br.sistemaescolarbackend.dtos.TeacherRequest;
import fatec.sp.gov.br.sistemaescolarbackend.entities.Teacher;
import fatec.sp.gov.br.sistemaescolarbackend.repositories.TeacherRepository;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id).orElse(null);
    }

    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }

    public void update(long id, TeacherRequest teacher) {
        try {
            var updateTeacher = this.teacherRepository.getReferenceById(id);
            updateTeacher.setCpf(teacher.cpf());
            updateTeacher.setName(teacher.name());
            updateTeacher.setSchool_subject(teacher.school_subject());
            this.teacherRepository.save(updateTeacher);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Teacher not found");
        }
    }
}
