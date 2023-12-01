package fatec.sp.gov.br.sistemaescolarbackend.resources.JUnit;

import java.util.Objects;

public class CoordinatorServiceTest {
    public boolean isValid(Coordinator coordinator) {
        Objects.requireNonNull(coordinator, "Coordinator cannot be null");
        return coordinator.getUser_name().equals("");
    }
}