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
public class Taille {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String marque ;
    private String nom ;
    private int prix ;

    @OneToMany(mappedBy = "taille")
    private List<MenuTaille> menuTailles = new ArrayList<>();
}
