package fatec.sp.gov.br.sistemaescolarbackend.mappers;

import fatec.sp.gov.br.sistemaescolarbackend.dtos.CoordinatorRequest;
import fatec.sp.gov.br.sistemaescolarbackend.dtos.CoordinatorResponse;
import fatec.sp.gov.br.sistemaescolarbackend.entities.Coordinator;

public class CoordinatorMapper {

    public static Coordinator toEntity(CoordinatorRequest request) {
        Coordinator coordinator = new Coordinator();
        coordinator.setUser_name(request.user_name());
        coordinator.setPassword(request.password());
        return coordinator;
    }

    public static CoordinatorResponse toDTO(Coordinator coordinator) {
        return new CoordinatorResponse(
                coordinator.getId(),
                coordinator.getUser_name()
        );
    }
}
