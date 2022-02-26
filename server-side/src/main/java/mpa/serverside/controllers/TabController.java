package mpa.serverside.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
  public Iterable<Tab> listTables(){
    Iterable<Tab> tabs = tabService.listTabs();
    return tabs;
  }

  // @GetMapping("/tabs")
  // public List<Tab> findByName(@RequestParam(value="name") String name){
  //   List<Tab> tabs = tabService.findByTabName(name);
  //   return tabs;
  // }

  @GetMapping("/tab/{id_tab}")
  public Tab findByTabId(@PathVariable Integer id_tab){
    Tab tab = tabService.findByTabId(id_tab);
    return tab;
  }

  @PostMapping("/tab")
  public ResponseEntity<Tab> createTab(@RequestBody Tab tab){
    tab = tabService.createTab(tab);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(tab.getId_tab()).toUri();
    return ResponseEntity.created(uri).build();
    
  }
  
}
