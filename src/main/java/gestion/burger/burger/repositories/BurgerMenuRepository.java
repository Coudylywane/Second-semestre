package gestion.burger.burger.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import gestion.burger.burger.models.BurgerMenu;

public interface BurgerMenuRepository extends JpaRepository<BurgerMenu , Long>{
    
}
