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

import gestion.burger.burger.models.Burger;
import gestion.burger.burger.models.Frite;
import gestion.burger.burger.models.Menu;
import gestion.burger.burger.models.Taille;
import gestion.burger.burger.service.BurgerService;
import gestion.burger.burger.service.FriteService;
import gestion.burger.burger.service.MenuService;
import gestion.burger.burger.service.TailleService;



@Controller
public class MenuController {
    
    @Autowired
    private MenuService menuService; 

    @Autowired
    private BurgerService burgerService ;

    @Autowired
    private TailleService tailleService ;

    @Autowired
    private FriteService friteService ;

    @GetMapping("/menu")
        public String getViewAddTaille(Model model){
            Menu menu = new Menu();
            List<Burger> burgers = burgerService.getAllBurger();
            List<Taille> tailles =  tailleService.getAllTaille();
            List<Frite> frites = friteService.getAllFrites();

            model.addAttribute("burgers", burgers);
            model.addAttribute("tailles", tailles);
            model.addAttribute("frites", frites);
            model.addAttribute("menu" , menu);
            return "menu/menu-add" ;
        }

        public static String upload = System.getProperty("user.dir") + "/src/main/resources/static/images";


        @PostMapping("/menu")
        public String addMenu(@ModelAttribute("boisson") Menu menu , Model model ,
        @RequestParam("fileImage")MultipartFile fileImage) throws IOException{
            

            String image ;

            if (!fileImage.isEmpty()) {
               image= fileImage.getOriginalFilename();
               Path fileName = Paths.get(upload, image);
               Files.write(fileName, fileImage.getBytes());
               menu.setImage(image);
               menuService.addMenu(menu);
            }
            return "redirect:/index";

        }

   

}
