package gestion.burger.burger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import gestion.burger.burger.models.Burger;
import gestion.burger.burger.service.BurgerService;

@Controller
public class BurgerController {
    @Autowired
    private BurgerService burgerService;

    @GetMapping("/burger")
    public String getViewAddCategorie(Model model) {
        Burger burger = new Burger();

        model.addAttribute("burger", burger);
        return "burger/burger-add";
    }

    @GetMapping("/detail")
    public String details(Model model) {
        return "burger/burger-details";
    }


    @PostMapping("/burger")
    public String addCategorie(@ModelAttribute("burger") Burger burger,Model model) {
        if(burger == null || burger.getNom() == null || burger.getNom().equals("")) {
            model.addAttribute("errorNom", "Champ obligatoire");
            return "burger/burger-add";
        }
        burgerService.addBurger(burger);
        return "redirect:/index";
       /*  if (burger.getId() != null) {
            return "redirect:/index";
        } else {
            model.addAttribute("error", "Echec de l'operation");
            return "burger/burger-add";
        }  */
        
    }
}
