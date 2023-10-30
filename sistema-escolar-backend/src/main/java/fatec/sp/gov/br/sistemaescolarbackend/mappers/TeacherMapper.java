package fatec.sp.gov.br.sistemaescolarbackend.mappers;

import fatec.sp.gov.br.sistemaescolarbackend.dtos.TeacherRequest;
import fatec.sp.gov.br.sistemaescolarbackend.dtos.TeacherResponse;
import fatec.sp.gov.br.sistemaescolarbackend.entities.Teacher;

public class TeacherMapper {

    public static Teacher toEntity(TeacherRequest request) {
        Teacher teacher = new Teacher();
        teacher.setCpf(request.cpf());
        teacher.setName(request.name());
        teacher.setSchool_subject(request.school_subject());
        teacher.setUser_name(request.user_name());
        return teacher;
    }

    public static TeacherResponse toDTO(Teacher teacher) {
        return new TeacherResponse(
            teacher.getId(),
            teacher.getCpf(),
            teacher.getName(),
            teacher.getSchool_subject(),
            teacher.getUser_name()
        );
    }
}

