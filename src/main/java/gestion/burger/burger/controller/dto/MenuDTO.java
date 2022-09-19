package gestion.burger.burger.controller.dto;

import java.util.ArrayList;
import java.util.List;

import gestion.burger.burger.models.Burger;
import gestion.burger.burger.models.BurgerMenu;
import gestion.burger.burger.models.Frite;
import gestion.burger.burger.models.FriteMenu;
import gestion.burger.burger.models.Menu;
import gestion.burger.burger.models.MenuTaille;
import gestion.burger.burger.models.Taille;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class MenuDTO {
    private Menu menu;
    private int quantiteFrite ;
    private int quantiteBurger ;
    private int quantiteTaille ;
   
    
    private List<Frite> frites = new ArrayList<>();
    private List<Burger> burgers = new ArrayList<>();
    private List<Taille> tailles = new ArrayList<>();
}
