package fatec.sp.gov.br.sistemaescolarbackend.dtos;

public record TeamResponse (
    Long id,
    String course,
    String semester,
    String shift,
    String students
){
    
}
