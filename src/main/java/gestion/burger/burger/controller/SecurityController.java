package gestion.burger.burger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import gestion.burger.burger.models.User;
import gestion.burger.burger.models.Adresse;
import gestion.burger.burger.models.Client;
import gestion.burger.burger.models.Role;
import gestion.burger.burger.service.UserService;

@Controller
public class SecurityController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder encode;



    @GetMapping("/login")
    public String getLoginView() {
        return "security/login";
    }

    @GetMapping("/gestionnaire/home")
    public String home(Model model){
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        model.addAttribute("msg", "Bonjour " + user.getNom() + " " + user.getPrenom());
        return "gestionnaire/home";
    }

    @GetMapping("/inscription")
    public String inscription(Model model){

        Client user = new Client();
        model.addAttribute("user",user);
        return "security/inscription" ;
    }



    @RequestMapping(value = "/inscription", method = RequestMethod.POST)
    public ModelAndView createNewUser( Client user, BindingResult bindingResult ,  @ModelAttribute("adresse") Adresse adresse) {
        ModelAndView modelAndView = new ModelAndView();
        Client userExists = (Client) userService.findUserByEmail(user.getEmail());
        System.out.println(userExists);
        if (userExists != null) {
            bindingResult.rejectValue("nom", "error.user",
                            "There is already a user registered with the user name provided");
            modelAndView.setViewName("security/inscription");
        }
        else {
            Role role = userService.findRoleByLibelle("CLIENT");
            if (role == null) {
                role = new Role();
                role.setLibelle("CLIENT");
                role = userService.saveRole(role);
            } 
            Adresse adres = new Adresse();
            adres.setVille(adresse.getVille());
            user.setAdresse(adres);
            user.setRole(role);  
            user.setPassword(encode.encode(user.getPassword()));         
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new Client());
            modelAndView.setViewName("security/login");

        }
        return modelAndView;
    }
    
}
