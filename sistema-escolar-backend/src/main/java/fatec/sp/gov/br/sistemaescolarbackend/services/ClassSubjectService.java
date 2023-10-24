package fatec.sp.gov.br.sistemaescolarbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fatec.sp.gov.br.sistemaescolarbackend.dtos.ClassSubjectRequest;
import fatec.sp.gov.br.sistemaescolarbackend.entities.ClassSubject;
import fatec.sp.gov.br.sistemaescolarbackend.repositories.ClassSubjectRepository;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

@Service
public class ClassSubjectService {
    @Autowired
    private ClassSubjectRepository classSubjectRepository;

    public List<ClassSubject> getAllClassSubjects() {
        return classSubjectRepository.findAll();
    }

    public ClassSubject createClassSubject(ClassSubject class_subject) {
        return classSubjectRepository.save(class_subject);
    }

    public ClassSubject getClassSubjectById(Long id) {
        return classSubjectRepository.findById(id).orElse(null);
    }

    public void deleteClassSubject(Long id) {
        classSubjectRepository.deleteById(id);
    }

    public void update(long id, ClassSubjectRequest class_subject) {
        try {
            var updateClassSubject = this.classSubjectRepository.getReferenceById(id);
            updateClassSubject.setName(class_subject.name());
            updateClassSubject.setDescription(class_subject.description());
            updateClassSubject.setTeacher(class_subject.teacher());
            updateClassSubject.setTime(class_subject.time());
            this.classSubjectRepository.save(updateClassSubject);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Class subject not found");
        }
    }
}
