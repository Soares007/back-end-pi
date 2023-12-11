package fatec.sp.gov.br.sistemaescolarbackend.dtos;

import java.util.List;


public record TeacherResponse(
    Long id,
    String cpf,
    String name,
    List<Integer> classSubjects
   
) {
}

