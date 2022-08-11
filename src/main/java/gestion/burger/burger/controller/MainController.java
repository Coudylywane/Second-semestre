package gestion.burger.burger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import gestion.burger.burger.models.Burger;
import gestion.burger.burger.service.BurgerService;

@Controller
public class MainController {

    @Autowired
    private BurgerService burgerService;
    @GetMapping({"/", "/index"})
    public String index(Model model) {
        List<Burger> burgers = burgerService.getAllBurger();
        model.addAttribute("burgers", burgers);
        return "index";
    }


   

}
