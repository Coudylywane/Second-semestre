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
@Setter
@Getter
public class FriteMenu {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String quatite ;

    @ManyToOne
    @JoinColumn(name = "frite", referencedColumnName = "id")
    private Frite frite;

    @ManyToOne
    @JoinColumn(name = "menu" , referencedColumnName = "id")
    private Menu menu;

    
}
