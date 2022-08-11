package gestion.burger.burger.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import gestion.burger.burger.models.Burger;

public interface BurgerRepository extends JpaRepository<Burger , Long> {
    
}
