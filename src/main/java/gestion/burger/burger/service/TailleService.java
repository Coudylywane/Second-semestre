package gestion.burger.burger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestion.burger.burger.models.Taille;
import gestion.burger.burger.repositories.TailleRepository;
import lombok.extern.java.Log;

@Service
@Log
public class TailleService {

    @Autowired
    private TailleRepository tailleRepository;

    public Taille addTaille(Taille taille){
        try {
            tailleRepository.save(taille);
            return taille;
        } catch (Exception e) {
            log.severe(e.getLocalizedMessage());
            throw e ;       
         }
    }

    public List<Taille> getAllTaille(){
        return tailleRepository.findAll();
    }
    
    

}
