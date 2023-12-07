package fatec.sp.gov.br.sistemaescolarbackend.dtos;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;

public record CourseResponse (
    Long id,
    String name,
    String courseYear,
    String semester,
    String shift,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    List<Integer> classSubjects
) {

}
