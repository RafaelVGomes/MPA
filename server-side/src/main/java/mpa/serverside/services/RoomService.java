package mpa.serverside.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mpa.serverside.models.Contractor;
import mpa.serverside.models.Room;
import mpa.serverside.repositories.RoomRepository;

@Service
public class RoomService {

  @Autowired
  RoomRepository roomRepository;

  @Autowired
  ContractorService contractorService;

  public List<Room> listRooms(){
    return roomRepository.findAll();
  }

  public Room findByRoomId(Integer id_room){
    return roomRepository.getById(id_room);
  }

  public Room createRoom(Integer id_contractor, Room room){
    room.setId_room(null);
    Contractor contractor = contractorService.findByContractorId(id_contractor);
    room.setContractor(contractor);
    return roomRepository.save(room);
  }

  public Room editRoom(Room room){
    findByRoomId(room.getId_room());
    return roomRepository.save(room);
  }

  public void deleteRoom(Integer id_room){
    roomRepository.deleteById(id_room);
  }
  
}
