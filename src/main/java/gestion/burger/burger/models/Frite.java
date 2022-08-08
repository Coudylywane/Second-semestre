package gestion.burger.burger.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import lombok.Getter;
import lombok.Setter;


@Entity
@Setter
@Getter
public class Frite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String code ;
    private int prix ;
    private TypePortion type ;

    @OneToMany(mappedBy = "frite")
    private List<FriteMenu> friteMenus = new ArrayList<>();
    
}
