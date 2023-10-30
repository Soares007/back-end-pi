package fatec.sp.gov.br.sistemaescolarbackend.dtos;

import jakarta.validation.constraints.NotBlank;

public record CoordinatorRequest (
    
    @NotBlank(message = "Usuário não pode estar em branco")
    String user_name,
    
    @NotBlank(message = "Senha não pode estar em branco")
    String password
) {
}
