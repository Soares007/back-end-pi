package fatec.sp.gov.br.sistemaescolarbackend.dtos;

import jakarta.validation.constraints.NotBlank;

public record TeacherRequest(
    @NotBlank(message = "CPF não pode ser em branco")
    String cpf,
    
    @NotBlank(message = "Nome não pode ser em branco")
    String name,

    @NotBlank(message = "Usuário não pode ser vazio")
    String user,

    String school_subject
) {
}

