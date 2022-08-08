package gestion.burger.burger.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Boisson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private String code ;

    @ManyToOne
    @JoinColumn(name = "taille" , referencedColumnName = "id")
    private Taille taille ;

    @ManyToOne
    @JoinColumn(name = "marque" , referencedColumnName = "id")
    private Marque marque ;

    @OneToMany(mappedBy = "boisson")
    private List<BoissonMenu> boissonMenus = new ArrayList<>();


}
