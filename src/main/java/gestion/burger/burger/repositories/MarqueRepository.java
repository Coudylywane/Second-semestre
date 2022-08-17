package gestion.burger.burger.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import gestion.burger.burger.models.Marque;

public interface MarqueRepository extends JpaRepository<Marque , Long>{
    
}
