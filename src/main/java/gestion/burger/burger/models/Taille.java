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
public class Taille {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ; 
    private int prix ;
    private TypeTaille type ;

    @OneToMany(mappedBy = "taille")
    private List<Boisson> boissons = new ArrayList<>();
}
