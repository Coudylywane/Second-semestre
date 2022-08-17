package gestion.burger.burger.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gestion.burger.burger.models.Frite;

@Repository
public interface FriteRepository extends JpaRepository<Frite , Long>{
    
}
