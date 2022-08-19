package gestion.burger.burger.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Setter;
import lombok.Getter;


@Entity
@Setter
@Getter
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String nom ;
    private int prix ;
    private String image ;

    @OneToMany(mappedBy = "menu")
    private List<BurgerMenu> burgerMenus = new ArrayList<>();

    @OneToMany(mappedBy = "menu")
    private List<FriteMenu> friteMenus = new ArrayList<>();

    @OneToMany(mappedBy = "menu")
    private List<MenuTaille> menuTailles = new ArrayList<>();

    @OneToMany(mappedBy = "menu")
    private List<MenuCommande> menuCommandes = new ArrayList<>();
}
