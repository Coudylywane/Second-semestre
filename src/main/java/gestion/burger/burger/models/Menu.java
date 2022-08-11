package gestion.burger.burger.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Setter;
import lombok.Getter;


@Entity
@Setter
@Getter
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String nom ;
    private int prix ;
}
