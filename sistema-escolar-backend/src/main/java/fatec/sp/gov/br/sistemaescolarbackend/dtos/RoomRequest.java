package fatec.sp.gov.br.sistemaescolarbackend.dtos;

import jakarta.validation.constraints.NotBlank;

public record RoomRequest(
    @NotBlank(message = "Nome não pode ser em branco")
    String name,
    @NotBlank(message = "Identificação não pode ser em branco")
    String identity
) {
    
}