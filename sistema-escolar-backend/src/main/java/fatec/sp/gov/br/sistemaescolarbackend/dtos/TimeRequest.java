package fatec.sp.gov.br.sistemaescolarbackend.dtos;

import java.util.List;

public record TimeRequest(
    String classSubjectId,
    String daysofweek,
    List<String> startTimes,
    List<String> endTimes
) {
    
}
