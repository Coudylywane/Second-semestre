package gestion.burger.burger.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import gestion.burger.burger.models.FriteMenu;

public interface FriteMenuRepository extends JpaRepository<FriteMenu , Long>{
    
}
