package gestion.burger.burger.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ; 

    @OneToMany(mappedBy = "menu")
    private List<BoissonMenu> boissonMenus= new ArrayList<>();

    @OneToMany(mappedBy = "menu")
    private List<FriteMenu> friteMenus= new ArrayList<>();

    @OneToMany(mappedBy = "menu")
    private List<BurgerMenu> burgerMenus= new ArrayList<>();
}