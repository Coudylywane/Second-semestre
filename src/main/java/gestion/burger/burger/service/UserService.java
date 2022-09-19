package gestion.burger.burger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestion.burger.burger.models.Gestionnaire;
import gestion.burger.burger.models.Role;
import gestion.burger.burger.models.User;
import gestion.burger.burger.repositories.GestionnaireRepository;
import gestion.burger.burger.repositories.RoleRepository;
import gestion.burger.burger.repositories.UserRepository;



@Service
public class UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    @Autowired
    private GestionnaireRepository adminRepository;

    public UserService() {
    }


    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }


    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    public Gestionnaire findAdminByEmail(String email) {
        return adminRepository.findByEmail(email);
    }

    public Role findRoleByLibelle(String libelle) {
        return roleRepository.findByLibelle(libelle);
    }

    public User saveUser(User user) {
        try {
            userRepository.save(user);
            return user;
        } catch(Exception e) {
            throw e;
        }
    }

    public Role saveRole(Role role) {
        try {
            roleRepository.save(role);
            return role;
        } catch(Exception e) {
            throw e;
        }
    }
}
