package mpa.serverside.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import mpa.serverside.models.Tab;
import mpa.serverside.services.TabService;

@CrossOrigin
@RestController
@RequestMapping("mpa")
public class TabController {

  @Autowired
  private TabService tabService;

  @GetMapping("/tabs")
  public List<Tab> listTabs(){
    List<Tab> tabs = tabService.listTabs();
    return tabs;
  }

  @GetMapping("/tab")
  public Tab findByTabId(@RequestBody Tab tab){
    return tabService.findByTabId(tab.getId_tab());
  }

  @PostMapping("/tab")
  public ResponseEntity<Tab> createTab(@RequestBody Tab tab){
    Tab obj = tab;
    Integer id_room = obj.getRoom().getId_room();
    tab = tabService.createTab(id_room, tab);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(tab.getId_tab()).toUri();
    return ResponseEntity.created(uri).build();
  }

  @PutMapping("/tab")
  public ResponseEntity<Tab> editTab(@RequestBody Tab tab){
    tabService.editTab(tab);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/tab")
  public ResponseEntity<Void> deleteTab(@RequestBody Tab tab){
    tabService.deleteTab(tab.getId_tab());
    return ResponseEntity.noContent().build();
  }
  
}
