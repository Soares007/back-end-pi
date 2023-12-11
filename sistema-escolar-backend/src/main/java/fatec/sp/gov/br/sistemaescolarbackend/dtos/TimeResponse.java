package fatec.sp.gov.br.sistemaescolarbackend.dtos;

import java.util.List;

public record TimeResponse(
    Long id,
    String classSubjectId,
    String daysofweek,
    List<String> startTimes,
    List<String> endTimes) {

}