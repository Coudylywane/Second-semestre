package gestion.burger.burger.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("GESTION")
@Getter
@Setter
public class Gestionnaire extends User{
    
}
