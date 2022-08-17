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

import gestion.burger.burger.models.Frite;
import gestion.burger.burger.service.FriteService;

@Controller
public class FriteController {
    @Autowired
    private FriteService friteService;

    @GetMapping("/frite")
    public String getViewAddTaille(Model model){
        Frite frite = new Frite();

        model.addAttribute("frite", frite);
        return "frite/frite-add";
    }

    public static String upload = System.getProperty("user.dir") + "/src/main/resources/static/images";


    @PostMapping("/frite")
    public String addBurger(@ModelAttribute("frite") Frite frite,Model model,
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
            frite.setImage(image);
            friteService.addFrite(frite);
        }
        
        return "redirect:/index";
        
    }



}
