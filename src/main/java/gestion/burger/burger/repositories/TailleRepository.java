package gestion.burger.burger.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gestion.burger.burger.models.Taille;


@Repository
public interface TailleRepository extends JpaRepository<Taille , Long>{
    
}
