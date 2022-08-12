package gestion.burger.burger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestion.burger.burger.models.Burger;
import gestion.burger.burger.repositories.BurgerRepository;
import lombok.extern.java.Log;

@Service
@Log
public class BurgerService {
    
    @Autowired
    private BurgerRepository burgerRepository ;

    public Burger addBurger(Burger burger){
        try {
            burgerRepository.save(burger);
            return burger;
        } catch (Exception e) {
          log.severe(e.getLocalizedMessage());
          throw e ;
        }
    }

    public List<Burger> getAllBurger(){
        return burgerRepository.findAll();
    }

    public Burger findBurgerById(Long id){
        return burgerRepository.findById(id).orElse(null);
    }
}
