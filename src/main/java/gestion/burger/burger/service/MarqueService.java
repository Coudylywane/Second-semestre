package gestion.burger.burger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestion.burger.burger.models.Marque;
import gestion.burger.burger.repositories.MarqueRepository;
import lombok.extern.java.Log;

@Service
@Log
public class MarqueService {

    @Autowired
    private MarqueRepository marqueRepository ;



    public Marque addMarque(Marque marque){
        try {
            marqueRepository.save(marque);
            return marque;
        } catch (Exception e) {
            log.severe(e.getLocalizedMessage());
            throw e ;        
        }
    }

    public List<Marque> getAllMarque(){
        return marqueRepository.findAll();
    }
    

}
