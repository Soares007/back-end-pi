package fatec.sp.gov.br.sistemaescolarbackend.dtos;

public record StudentResponse(
    Long id,
    String email,
    String full_name,
    String password,
    String user
) {
}

