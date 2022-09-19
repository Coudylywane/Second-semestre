package gestion.burger.burger.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import gestion.burger.burger.models.MenuTaille;

public interface MenuTailleRepository extends JpaRepository<MenuTaille , Long>{
    
}
