package fatec.sp.gov.br.sistemaescolarbackend.mappers;

import fatec.sp.gov.br.sistemaescolarbackend.dtos.ClassSubjectRequest;
import fatec.sp.gov.br.sistemaescolarbackend.dtos.ClassSubjectResponse;
import fatec.sp.gov.br.sistemaescolarbackend.entities.ClassSubject;

public class ClassSubjectMapper {

    public static ClassSubject toEntity(ClassSubjectRequest request) {
        ClassSubject classSubject = new ClassSubject();
        classSubject.setName(request.name());
        classSubject.setDescription(request.description());
        return classSubject;
    }

    public static ClassSubjectResponse toDTO(ClassSubject classSubject) {
        return new ClassSubjectResponse(
                classSubject.getId(),
                classSubject.getName(),
                classSubject.getDescription()
        );
    }
}
