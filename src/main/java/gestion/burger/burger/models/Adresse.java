package gestion.burger.burger.models;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Embeddable
@Setter
@Getter
public class Adresse {
    
    private String ville ;

}
