package fatec.sp.gov.br.sistemaescolarbackend.mappers;

import fatec.sp.gov.br.sistemaescolarbackend.dtos.RoomRequest;
import fatec.sp.gov.br.sistemaescolarbackend.dtos.RoomResponse;
import fatec.sp.gov.br.sistemaescolarbackend.entities.Room;

public class RoomMapper {
    
    public static Room toEntity(RoomRequest request) {
        Room room = new Room();
        room.setName(request.name());
        
        return room;
    }

    public static RoomResponse toDTO(Room room) {
        return new RoomResponse(
            room.getId(),
            room.getName()
        );
    }
}
