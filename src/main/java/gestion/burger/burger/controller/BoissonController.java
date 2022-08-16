package gestion.burger.burger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import gestion.burger.burger.models.Taille;
import gestion.burger.burger.service.TailleService;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class BoissonController {

    @Autowired
    private TailleService tailleService;



        @GetMapping("/taille")
        public String getViewAddTaille(Model model){
            Taille taille = new Taille();

            model.addAttribute("taille", taille);
            return "taille/taille-add";
        }

        @PostMapping("/taille")
        public String addTaille(@ModelAttribute("taille") Taille taille , Model model){
            if (taille == null ) {
                model.addAttribute("errorNom", "Champ obligatoire");
                return "taille/taille-add";
            }

            tailleService.addTaille(taille);
            return "redirect:/index";

        }
        
}
