package mpa.serverside.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mpa.serverside.models.Tab;
import mpa.serverside.repositories.TabRepository;

@Service
public class TabService {

  @Autowired
  private TabRepository tabRepository;

  public List<Tab> listTabs(){
    return tabRepository.findAll();
  }

  // public Tab findByUserId(User user){
  //   return tabRepository.findByUser(user);
  // }

  // public List<Tab> findByTabName(String name){
  //   return tabRepository.findByName(name);
  // }

  public Tab findByTabId(Integer id_tab){
    Optional<Tab> tab = tabRepository.findById(id_tab);
    return tab.orElseThrow();
  }

  public Tab createTab(Tab tab){
    tab.setId_tab(null);
    return tabRepository.save(tab);
  }
  
}
