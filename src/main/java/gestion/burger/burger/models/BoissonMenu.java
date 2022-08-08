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
public class BoissonMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    @ManyToOne
    @JoinColumn(name = "boisson" , referencedColumnName = "id")
    private Boisson boisson ;

    @ManyToOne
    @JoinColumn(name = "menu" , referencedColumnName = "id")
    private Boisson menu ;
}
