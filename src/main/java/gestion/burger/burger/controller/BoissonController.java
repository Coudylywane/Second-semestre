package gestion.burger.burger.controller;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import gestion.burger.burger.models.Boisson;
import gestion.burger.burger.models.Marque;
import gestion.burger.burger.models.Taille;
import gestion.burger.burger.service.BoissonService;
import gestion.burger.burger.service.MarqueService;
import gestion.burger.burger.service.TailleService;





@Controller
public class BoissonController {

    @Autowired
    private TailleService tailleService;

    @Autowired
    private MarqueService marqueService;

      @Autowired
    private BoissonService boissonService; 


    //////taille/////

        @GetMapping("/gestionnaire/taille")
        public String getViewAddTaille(Model model){
            Taille taille = new Taille();

            model.addAttribute("taille", taille);
            return "boisson/taille-add";
        }

        @PostMapping("/taille")
        public String addTaille(@ModelAttribute("taille") Taille taille , Model model){
            if (taille == null ) {
                model.addAttribute("errorNom", "Champ obligatoire");
                return "boisson/taille-add";
            }

            tailleService.addTaille(taille);
            return "redirect:/index";

        }


            //////Marque/////


        @GetMapping("/gestionnaire/marque")
        public String getViewAddMarque(Model model){
            Marque marque = new Marque();
            model.addAttribute("marque", marque);
            return "boisson/marque-add";
        }

        @PostMapping("/marque")
        public String addMarque(@ModelAttribute("marque") Marque marque , Model model){
            if (marque == null ) {
                    model.addAttribute("errorNom", "Champ obligatoire");
                    return "boisson/taille-add";
            }
    
            marqueService.addMarque(marque);
            return "redirect:/index";

        }


           /////////////////boisson///////////////

        @GetMapping("/gestionnaire//boisson")
        public String getViewAddBoisson(Model model){

            Boisson boisson = new Boisson();
            List<Taille> tailles = tailleService.getAllTaille();
            List<Marque> marques = marqueService.getAllMarque();

            model.addAttribute("marques", marques);
            model.addAttribute("tailles", tailles);
            model.addAttribute("boisson", boisson);
            return "boisson/boisson-add";
        }

        public static String upload = System.getProperty("user.dir") + "/src/main/resources/static/images";


        @PostMapping("/gestionnaire/boisson")
        public String addBoisson(@ModelAttribute("boisson") Boisson boisson , Model model ,
        @RequestParam("fileImage")MultipartFile fileImage) throws IOException{
            
            boolean valide = true;


        if (boisson.getQuantiteStock() == 0) {
            model.addAttribute("errorPrix", "prix obligatoire ");
            valide = false;
        }

        if (boisson.getMarque() == null || boisson.getMarque().getId() == null) {
            model.addAttribute("errorMarque", "marque obligatoire ");
            valide = false;
        }

        if (boisson.getTaille() == null || boisson.getTaille().getId() == null) {
            model.addAttribute("errorTaille", "taille obligatoire ");
            valide = false;
        }
        String image ;


        if (valide) {
            if (!fileImage.isEmpty()) {
               image= fileImage.getOriginalFilename();
               Path fileName = Paths.get(upload, image);
               Files.write(fileName, fileImage.getBytes());
               boisson.setImage(image);
               boissonService.addBoisson(boisson);
            }
            return "redirect:/index";
        }
        
           return "boisson/boisson-add" ;

        }

        @GetMapping("/gestionnaire/boisson-list")
        public String listBoisson(Model model){

            List<Boisson> boissons = boissonService.getAllBoissons();

            model.addAttribute("boissons", boissons);
            return "boisson/boisson-liste";
        }



 

        
}
