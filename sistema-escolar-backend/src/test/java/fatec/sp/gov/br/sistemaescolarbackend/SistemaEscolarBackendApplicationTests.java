package fatec.sp.gov.br.sistemaescolarbackend;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import fatec.sp.gov.br.sistemaescolarbackend.resources.jUnit.Coordinator;
import fatec.sp.gov.br.sistemaescolarbackend.resources.jUnit.CoordinatorServiceTest;


@SpringBootTest
class SistemaEscolarBackendApplicationTests {
    private Coordinator coordinator;
    private CoordinatorServiceTest coordinatorService;

    @BeforeEach
    public void setUp() {
        coordinator = new Coordinator("JohnDoe");
        coordinatorService = new CoordinatorServiceTest();
    }

    @Test
    @DisplayName("A coordinator should not be valid when the username is not empty.")
    void isValid_ReturnFalse_WhenUsernameIsNotEmpty() {
        Assertions.assertFalse(coordinatorService.isValid(coordinator));
    }

    @Test
    @DisplayName("A coordinator should be valid when the username is empty.")
    void isValid_ReturnTrue_WhenUsernameIsEmpty() {
        coordinator.setUser_name("");
        Assertions.assertTrue(coordinatorService.isValid(coordinator));
    }
}
