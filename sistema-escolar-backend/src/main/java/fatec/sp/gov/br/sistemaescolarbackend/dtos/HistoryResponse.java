package fatec.sp.gov.br.sistemaescolarbackend.dtos;

public record HistoryResponse (
    long id,
    String teacher,
    String class_subject,
    String starttime,
    String endtime,
    String dayofweek,
    String room,
    String laboratory
) {
}
