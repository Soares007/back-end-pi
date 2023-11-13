package fatec.sp.gov.br.sistemaescolarbackend.dtos;

import jakarta.validation.constraints.NotBlank;

public record TeacherRequest(
    @NotBlank(message = "CPF não pode ser em branco")
    String cpf,
    
    @NotBlank(message = "Nome não pode ser em branco")
    String name,

    String school_subject
) {
}

