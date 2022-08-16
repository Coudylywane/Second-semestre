package gestion.burger.burger.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import gestion.burger.burger.models.Taille;

public interface TailleRepository extends JpaRepository<Taille , Long>{
    
}
