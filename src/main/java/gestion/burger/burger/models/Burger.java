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
public class Burger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private String nom ;
    private int prix ;
    private String description ;
    private String image ;

    @OneToMany(mappedBy = "burger")
    private List<BurgerMenu> burgerMenus = new ArrayList<>();
    
}