package fatec.sp.gov.br.sistemaescolarbackend.dtos;

import jakarta.validation.constraints.NotBlank;

public record StudentRequest (
    @NotBlank(message = "Usuário não pode estar em branco")
    String user,

    @NotBlank(message = "Senha não pode estar em branco")
    String password,

    @NotBlank(message = "Nome completo não pode estar em branco")
    String full_name,

    @NotBlank(message = "E-mail não pode estar em branco")
    String email
) {
}

