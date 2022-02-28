package mpa.serverside.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import mpa.serverside.models.Room;

public interface RoomRepository extends JpaRepository<Room, Integer> {
  
}
