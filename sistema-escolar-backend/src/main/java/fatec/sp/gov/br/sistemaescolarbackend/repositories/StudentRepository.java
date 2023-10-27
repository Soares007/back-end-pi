package fatec.sp.gov.br.sistemaescolarbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import fatec.sp.gov.br.sistemaescolarbackend.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}

