package gestion.burger.burger.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gestion.burger.burger.models.Marque;

@Repository
public interface MarqueRepository extends JpaRepository<Marque , Long>{
    
}
