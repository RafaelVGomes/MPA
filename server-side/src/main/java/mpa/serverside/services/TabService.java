package mpa.serverside.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mpa.serverside.models.Room;
import mpa.serverside.models.Tab;
import mpa.serverside.repositories.TabRepository;

@Service
public class TabService {

  @Autowired
  private TabRepository tabRepository;

  @Autowired
  private RoomService roomService;

  public List<Tab> listTabs(){
    return tabRepository.findAll();
  }

  public Tab findByTabId(Integer id_tab){
    Optional<Tab> tab = tabRepository.findById(id_tab);
    return tab.orElseThrow();
  }

  public Tab createTab(Integer id_room, Tab tab){
    tab.setId_tab(null);
    Room room = roomService.findByRoomId(id_room);
    tab.setRoom(room);
    return tabRepository.save(tab);
  }

  public Tab editTab(Tab tab){
    findByTabId(tab.getId_tab());
    return tabRepository.save(tab);
  }

  public void deleteTab(Integer id_tab){
    tabRepository.deleteById(id_tab);
  }
  
}
