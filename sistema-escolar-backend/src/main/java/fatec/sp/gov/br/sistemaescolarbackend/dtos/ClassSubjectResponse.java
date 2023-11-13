package fatec.sp.gov.br.sistemaescolarbackend.dtos;

public record ClassSubjectResponse (
    long id,
    String name,
    String description,
    String teacher,
    String starttime,
    String endtime,
    String dayofweek
) {

}
