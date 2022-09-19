package gestion.burger.burger.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gestion.burger.burger.models.Gestionnaire;

@Repository
public interface GestionnaireRepository extends JpaRepository<Gestionnaire, Long> {
    Gestionnaire findByEmail(String email);
    
}
