package mpa.serverside.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import mpa.serverside.models.Contractor;

public interface ContractorRepository extends JpaRepository<Contractor, Integer> {
  
}
