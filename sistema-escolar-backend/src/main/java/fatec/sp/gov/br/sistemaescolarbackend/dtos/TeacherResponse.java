package fatec.sp.gov.br.sistemaescolarbackend.dtos;

public record TeacherResponse(
    Long id,
    String cpf,
    String name_name,
    String school_subject,
    String user
) {
}

