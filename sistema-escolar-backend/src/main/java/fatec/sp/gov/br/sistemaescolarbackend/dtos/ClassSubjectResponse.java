package fatec.sp.gov.br.sistemaescolarbackend.dtos;

public record ClassSubjectResponse (
    long id,
    String name,
    String description,
    String teacher
) {

}
