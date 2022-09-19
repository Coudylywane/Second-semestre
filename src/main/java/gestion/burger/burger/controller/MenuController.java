package gestion.burger.burger.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import gestion.burger.burger.controller.dto.MenuDTO;
import gestion.burger.burger.models.Burger;
import gestion.burger.burger.models.BurgerMenu;
import gestion.burger.burger.models.Frite;
import gestion.burger.burger.models.FriteMenu;
import gestion.burger.burger.models.Menu;
import gestion.burger.burger.models.MenuTaille;
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

/*     @GetMapping("/menu")
        public String getViewAddTaille(Model model){
            Menu menu = new Menu();
            MenuDTO menuDTO = new MenuDTO();
            menuDTO.setMenu(menu);

        
            List<Burger> burgers = burgerService.getAllBurger();
            List<Taille> tailles =  tailleService.getAllTaille();
            List<Frite> frites = friteService.getAllFrites();


            model.addAttribute("burgers", burgers);
            model.addAttribute("tailles", tailles);
            model.addAttribute("frites", frites);
            model.addAttribute("menu" , menuDTO);
            
            return "menu/menu-add" ;
        } */

        @GetMapping("/menu")
        public String getViewAddMenu(Model model) {
            Menu menu = new Menu();
            MenuDTO menuDTO = new MenuDTO();
            menuDTO.setMenu(menu);
             List<Burger> burgers = burgerService.getAllBurger();
            model.addAttribute("burgers", burgers);
            List<Frite> frites = friteService.getAllFrites();
            model.addAttribute("frites", frites);
            List<Taille> tailles = tailleService.getAllTaille();
            model.addAttribute("tailles", tailles); 
    
            model.addAttribute("menu", menuDTO);
            return "menu/menu-add";
        }


/*         public static String upload = System.getProperty("user.dir") + "/src/main/resources/static/images";
 */

        public static String uploadDirectory = System.getProperty("user.dir") +"/src/main/resources/static/images";

        @PostMapping("/menu")
        public String addMenu(@ModelAttribute("menu") MenuDTO menuDTO, Model model,@RequestParam("fileImage") MultipartFile fileImage) throws IOException {
           Menu menu = menuService.addMenu(menuDTO.getMenu());
    
            if (menu == null || menu.getNom() == null || menu.getNom().equals("")) {
                model.addAttribute("errorNom", "Champ obligatoire");
                return "menu/menu-add"; 
            }
            boolean valide = true;
            String image;
            if(valide) {
                if (!fileImage.isEmpty()) {
                    image = fileImage.getOriginalFilename();
                    Path fileNameAndPath = Paths.get(uploadDirectory, image);
                    Files.write(fileNameAndPath, fileImage.getBytes());
                    menu.setImage(image);
                    menuService.addMenu(menu);
                }
                menuService.addMenu(menu);
                
                List<BurgerMenu> menuBurgerList = new ArrayList<>();
                List<FriteMenu> menuFriteList = new ArrayList<>();
                List<MenuTaille> menuTailleList = new ArrayList<>();
    
                for(Burger burger : menuDTO.getBurgers()) {
                    BurgerMenu menuBurger = new BurgerMenu();
                    menuBurger.setBurger(burger);
                    menuBurger.setMenu(menu);
                    menuBurger.setQuantite(menuDTO.getQuantiteBurger());
    
                    menuBurgerList.add(menuBurger);
                }
    
                for(Frite frite : menuDTO.getFrites()){
                    FriteMenu menuFritte = new FriteMenu();
    
                    menuFritte.setFrite(frite);
                    menuFritte.setMenu(menu);
                    menuDTO.setQuantiteFrite(menuDTO.getQuantiteFrite());
    
                    menuFriteList.add(menuFritte);
                }
                for(Taille taille : menuDTO.getTailles()){
                    MenuTaille menuTaille = new MenuTaille();
    
                    menuTaille.setTaille(taille);
                    menuTaille.setMenu(menu);
                    menuDTO.setQuantiteTaille(menuDTO.getQuantiteTaille());
                }
                menuService.addFriteMenu(menuFriteList);
                menuService.addBurgerMenu(menuBurgerList);
                menuService.addMenuTaille(menuTailleList);
                 if (menu.getId() != null) {
                    return "redirect:/menu";
                } else {
                    model.addAttribute("error", "Echec de l'operation");
                    return "menu/menu-add";
                }
            }
            return "menu/menu-add";
        }

   

}
