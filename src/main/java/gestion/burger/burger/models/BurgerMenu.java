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
public class BurgerMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "burger",referencedColumnName= "id")
    private Burger burger ;

    @ManyToOne
    @JoinColumn(name = "menu",referencedColumnName= "id")
    private Menu menu ;


    private int quantite ;

}
