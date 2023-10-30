package fatec.sp.gov.br.sistemaescolarbackend.mappers;

import fatec.sp.gov.br.sistemaescolarbackend.dtos.StudentRequest;
import fatec.sp.gov.br.sistemaescolarbackend.dtos.StudentResponse;
import fatec.sp.gov.br.sistemaescolarbackend.entities.Student;

public class StudentMapper {

    public static Student toEntity(StudentRequest request) {
        Student student = new Student();
        student.setEmail(request.email());
        student.setUser_name(request.user_name());
        student.setFull_name(request.full_name());
        student.setPassword(request.password());
        return student;
    }

    public static StudentResponse toDTO(Student student) {
        return new StudentResponse(
            student.getId(),
            student.getEmail(),
            student.getUser_name(),
            student.getFull_name(),
            student.getPassword()
        );
    }
}
