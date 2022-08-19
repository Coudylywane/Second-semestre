package gestion.burger.burger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestion.burger.burger.models.Menu;
import gestion.burger.burger.repositories.MenuRepository;
import lombok.extern.java.Log;

@Service
@Log
public class MenuService {
    
    @Autowired
    private MenuRepository menuRepository ;

    public Menu addMenu(Menu menu){
        try {
            menuRepository.save(menu);
            return menu ;
        } catch (Exception e) {
            log.severe(e.getLocalizedMessage());
            throw e ;  
        }
    } 

}
