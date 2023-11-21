package fatec.sp.gov.br.sistemaescolarbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import fatec.sp.gov.br.sistemaescolarbackend.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
