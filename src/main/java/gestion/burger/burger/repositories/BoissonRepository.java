package gestion.burger.burger.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gestion.burger.burger.models.Boisson;


@Repository
public interface BoissonRepository extends JpaRepository<Boisson , Long>{
    
}
