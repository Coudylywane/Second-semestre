package gestion.burger.burger.fixture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import gestion.burger.burger.models.Gestionnaire;
import gestion.burger.burger.models.Role;
import gestion.burger.burger.models.User;
import gestion.burger.burger.service.UserService;

@Component
public class UserFixture {
    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public void loadDefaultAdmin() {
        User user = new Gestionnaire();
        user.setEmail("admin@mail.com");
        user.setNom("admin");
        user.setPrenom("admin");
        user.setPassword(encoder.encode("passer"));
       Role role = userService.findRoleByLibelle("ADMIN");
       user.setRole(role);
        userService.saveUser(user);
    }
}
