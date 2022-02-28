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

import mpa.serverside.models.Contractor;
import mpa.serverside.services.ContractorService;

@CrossOrigin
@RestController
@RequestMapping("mpa")
public class ContractorController {

  @Autowired
  private ContractorService contractorService;

  @GetMapping("/contractors")
  public List<Contractor> listContractors(){
    List<Contractor> contractors = contractorService.listContractors();
    return contractors;
  }

  @GetMapping("/contractor")
  public Contractor findByContractorId(@RequestBody Contractor contractor){
    return contractorService.findByContractorId(contractor.getId_contractor());
  }

  @PostMapping("/contractor")
  public ResponseEntity<Contractor> createContractor(@RequestBody Contractor contractor){
    contractor = contractorService.createContractor(contractor);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(contractor.getId_contractor()).toUri();
    return ResponseEntity.created(uri).build();
  }

  @PutMapping("/contractor")
  public ResponseEntity<Contractor> editContractor(@RequestBody Contractor contractor){
    contractorService.editContractor(contractor);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/contractor")
  public ResponseEntity<Void> deleteContractor(@RequestBody Contractor contractor){
    contractorService.deleteContractor(contractor.getId_contractor());
    return ResponseEntity.noContent().build();
  }
  
}
