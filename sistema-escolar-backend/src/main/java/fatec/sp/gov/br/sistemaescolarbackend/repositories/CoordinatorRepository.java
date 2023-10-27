package fatec.sp.gov.br.sistemaescolarbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import fatec.sp.gov.br.sistemaescolarbackend.entities.Coordinator;

public interface CoordinatorRepository extends JpaRepository<Coordinator, Long> {
}

