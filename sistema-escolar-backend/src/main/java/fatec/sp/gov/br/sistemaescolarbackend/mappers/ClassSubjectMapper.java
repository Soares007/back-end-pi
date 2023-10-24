package fatec.sp.gov.br.sistemaescolarbackend.mappers;

import fatec.sp.gov.br.sistemaescolarbackend.dtos.ClassSubjectRequest;
import fatec.sp.gov.br.sistemaescolarbackend.dtos.ClassSubjectResponse;
import fatec.sp.gov.br.sistemaescolarbackend.entities.ClassSubject;

public class ClassSubjectMapper {

    public static ClassSubject toEntity(ClassSubjectRequest request) {
        ClassSubject class_subject = new ClassSubject();
        class_subject.setName(request.name());
        class_subject.setDescription(request.description());
        class_subject.setTeacher(request.teacher());
        class_subject.setTime(request.time());
        return class_subject;
    }

    public static ClassSubjectResponse toDTO(ClassSubject class_subject) {
        return new ClassSubjectResponse(
                class_subject.getId(),
                class_subject.getName(),
                class_subject.getDescription(),
                class_subject.getTeacher(),
                class_subject.getTime()
        );
    }
}
