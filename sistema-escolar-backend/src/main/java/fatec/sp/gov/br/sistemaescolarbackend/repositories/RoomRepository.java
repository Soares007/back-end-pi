package fatec.sp.gov.br.sistemaescolarbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fatec.sp.gov.br.sistemaescolarbackend.entities.Room;

public interface RoomRepository extends JpaRepository<Room, Long>{
    
}
