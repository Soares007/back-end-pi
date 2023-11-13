package fatec.sp.gov.br.sistemaescolarbackend.dtos;

public record TeacherResponse(
    Long id,
    String cpf,
    String name,
    String school_subject
   
) {
}

