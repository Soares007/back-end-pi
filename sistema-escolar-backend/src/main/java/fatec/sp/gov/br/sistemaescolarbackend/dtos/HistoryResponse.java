package fatec.sp.gov.br.sistemaescolarbackend.dtos;

public record HistoryResponse (
    long id,
    String teacher,
    String class_subject,
    String time,
    String class_day,
    String room
) {
}
