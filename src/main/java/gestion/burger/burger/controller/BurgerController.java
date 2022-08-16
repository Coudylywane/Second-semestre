package gestion.burger.burger.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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

    public static String upload = System.getProperty("user.dir") + "/src/main/resources/static/images";


    @PostMapping("/burger")
    public String addBurger(@ModelAttribute("burger") Burger burger,Model model,
    @RequestParam("fileImage")MultipartFile fileImage) throws IOException {
        /* if(burger == null || burger.getNom() == null || burger.getNom().equals("")) {
            model.addAttribute("errorNom", "Champ obligatoire");
            return "burger/burger-add";
        }
 */
        String image ;

        if (!fileImage.isEmpty()) {
            image = fileImage.getOriginalFilename();
            Path fileName = Paths.get(upload , image);
            Files.write(fileName, fileImage.getBytes());
            burger.setImage(image);
            burgerService.addBurger(burger);
        }
        
        return "redirect:/index";
        
    }
}
