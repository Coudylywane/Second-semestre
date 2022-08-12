package gestion.burger.burger.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
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
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private int numeroCom;
    private String date ;
    private String etat ;
    private int numeroLiv;

    @Embedded
    private Adresse adresse ;

    @OneToMany(mappedBy = "commande")
    private List<MenuCommande> menuCommandes = new ArrayList<>();

}
