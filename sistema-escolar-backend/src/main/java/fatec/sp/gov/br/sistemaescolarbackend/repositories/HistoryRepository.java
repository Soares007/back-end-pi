package fatec.sp.gov.br.sistemaescolarbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import fatec.sp.gov.br.sistemaescolarbackend.entities.History;

public interface HistoryRepository extends JpaRepository<History, Long> {
}
