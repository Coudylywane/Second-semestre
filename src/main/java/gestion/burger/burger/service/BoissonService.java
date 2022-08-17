package gestion.burger.burger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestion.burger.burger.models.Boisson;
import gestion.burger.burger.repositories.BoissonRepository;
import lombok.extern.java.Log;

@Service
@Log
public class BoissonService {
    @Autowired
    private BoissonRepository boissonRepository ;

    public Boisson addBoisson(Boisson boisson){
        try {
            boissonRepository.save(boisson);
            return boisson ;
        } catch (Exception e) {
            log.severe(e.getLocalizedMessage());
            throw e ;  
        }
    }
}
