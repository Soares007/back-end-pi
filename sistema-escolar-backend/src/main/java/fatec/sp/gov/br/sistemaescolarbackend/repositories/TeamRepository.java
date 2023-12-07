package fatec.sp.gov.br.sistemaescolarbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fatec.sp.gov.br.sistemaescolarbackend.entities.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {
}