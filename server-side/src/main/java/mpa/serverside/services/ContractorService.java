package mpa.serverside.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mpa.serverside.models.Contractor;
import mpa.serverside.repositories.ContractorRepository;

@Service
public class ContractorService {

  @Autowired
  private ContractorRepository contractorRepository;

  public List<Contractor> listContractors(){
    return contractorRepository.findAll();
  }

  public Contractor findByContractorId(Integer id_Contractor){
    Optional<Contractor> Contractor = contractorRepository.findById(id_Contractor);
    return Contractor.orElseThrow();
  }

  public Contractor createContractor(Contractor contractor){
    contractor.setId_contractor(null);
    return contractorRepository.save(contractor);
  }

  public Contractor editContractor(Contractor contractor){
    findByContractorId(contractor.getId_contractor());
    return contractorRepository.save(contractor);
  }

  public void deleteContractor(Integer id_Contractor){
    contractorRepository.deleteById(id_Contractor);
  }
  
}
