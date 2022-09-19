package gestion.burger.burger.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import gestion.burger.burger.models.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByLibelle(String libelle);
}
