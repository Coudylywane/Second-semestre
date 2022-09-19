package gestion.burger.burger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestion.burger.burger.models.BurgerMenu;
import gestion.burger.burger.models.FriteMenu;
import gestion.burger.burger.models.Menu;
import gestion.burger.burger.models.MenuTaille;
import gestion.burger.burger.repositories.BurgerMenuRepository;
import gestion.burger.burger.repositories.FriteMenuRepository;
import gestion.burger.burger.repositories.MenuRepository;
import gestion.burger.burger.repositories.MenuTailleRepository;
import lombok.extern.java.Log;

@Service
@Log
public class MenuService {
    
    @Autowired
    private MenuRepository menuRepository ;

    @Autowired
    private FriteMenuRepository friteMenuRepository ;

    @Autowired
    private BurgerMenuRepository burgerMenuRepository ;

    @Autowired
    private MenuTailleRepository menuTailleRepository ;



    public Menu addMenu(Menu menu){
        try {
            menuRepository.save(menu);
            return menu ;
        } catch (Exception e) {
            log.severe(e.getLocalizedMessage());
            throw e ;  
        }
    } 

    public List<FriteMenu> addFriteMenu(List<FriteMenu> friteMenu){
        try {
            friteMenuRepository.saveAll(friteMenu);
            return friteMenu ;
        } catch (Exception e) {
            log.severe(e.getLocalizedMessage());
            throw e ;  
        }
    }



    public List<MenuTaille> addMenuTaille(List<MenuTaille> menuTaille){
        try {
            menuTailleRepository.saveAll(menuTaille);
            return menuTaille ;
        } catch (Exception e) {
            log.severe(e.getLocalizedMessage());
            throw e ;  
        }
    }


    public List<BurgerMenu> addBurgerMenu(List<BurgerMenu> burgerMenu){
        try {
            burgerMenuRepository.saveAll(burgerMenu);
            return burgerMenu ;
        } catch (Exception e) {
            log.severe(e.getLocalizedMessage());
            throw e ;  
        }
    }

    
    public List<Menu> getAlMenus(){
        return menuRepository.findAll();
    }

}
