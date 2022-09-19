package gestion.burger.burger.models;

import javax.persistence.Entity;
import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="user_type")
@DiscriminatorValue("USER")
public abstract class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id ;

    protected String nom ;
    protected String prenom ;
    protected String email;
    protected String password ;
    
    @ManyToOne
    @JoinColumn(name = "role" , referencedColumnName = "id")
    protected Role role ;
}