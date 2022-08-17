package gestion.burger.burger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestion.burger.burger.models.Frite;
import gestion.burger.burger.repositories.FriteRepository;
import lombok.extern.java.Log;

@Service
@Log
public class FriteService {
    @Autowired
    private FriteRepository friteRepository;

    public Frite addFrite(Frite frite){
        try {
            friteRepository.save(frite);
            return frite;
        } catch (Exception e) {
            log.severe(e.getLocalizedMessage());
            throw e ;       
         }
    }

    public List<Frite> getAllFrites(){
        return friteRepository.findAll();
    }
}
