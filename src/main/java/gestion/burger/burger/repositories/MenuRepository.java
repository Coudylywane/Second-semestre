package gestion.burger.burger.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gestion.burger.burger.models.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu , Long>{
    
}
