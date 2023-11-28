package fatec.sp.gov.br.sistemaescolarbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fatec.sp.gov.br.sistemaescolarbackend.entities.ClassSubject;

public interface ClassSubjectRepository extends JpaRepository<ClassSubject, Long> {
    ClassSubject findByName(String name);
}
