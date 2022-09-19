package gestion.burger.burger.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Boisson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private int quantiteStock ;
    private String image ;
    

    @ManyToOne
    @JoinColumn(name = "taille", referencedColumnName = "id")
    private Taille taille;
    

    @ManyToOne
    @JoinColumn(name = "marque" , referencedColumnName = "id")
    private Marque marque;
    

}
 