package fatec.sp.gov.br.sistemaescolarbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import fatec.sp.gov.br.sistemaescolarbackend.entities.Scheduling;

public interface SchedulingRepository extends JpaRepository<Scheduling, Long> {
}
