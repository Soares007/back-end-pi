package fatec.sp.gov.br.sistemaescolarbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fatec.sp.gov.br.sistemaescolarbackend.dtos.TeacherRequest;
import fatec.sp.gov.br.sistemaescolarbackend.dtos.TeacherResponse;
import fatec.sp.gov.br.sistemaescolarbackend.entities.Teacher;
import fatec.sp.gov.br.sistemaescolarbackend.mappers.TeacherMapper;
import fatec.sp.gov.br.sistemaescolarbackend.repositories.TeacherRepository;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    public List<TeacherResponse> getAllTeachers() {
        List<Teacher> teachers = teacherRepository.findAll();
        return teachers.stream()
                .map(TeacherMapper::toDTO)
                .collect(Collectors.toList());
    }

    public TeacherResponse getTeacherById(Long id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Teacher not found with id: " + id));
        return TeacherMapper.toDTO(teacher);
    }

    public TeacherResponse createTeacher(TeacherRequest teacherRequest) {
        Teacher teacher = TeacherMapper.toEntity(teacherRequest);
        Teacher savedTeacher = teacherRepository.save(teacher);
        return TeacherMapper.toDTO(savedTeacher);
    }

    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }

    public void update(Long id, TeacherRequest teacherRequest) {
        try {
            Teacher existingTeacher = teacherRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Teacher not found with id: " + id));

            existingTeacher.setCpf(teacherRequest.cpf());
            existingTeacher.setName(teacherRequest.name());
            existingTeacher.setClassSubjects(teacherRequest.classSubjects());

            teacherRepository.save(existingTeacher);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Teacher not found");
        }
    }
}
