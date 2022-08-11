package gestion.burger.burger.fixture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gestion.burger.burger.models.Burger;
import gestion.burger.burger.service.BurgerService;





@Component
public class BurgerFixture {

    @Autowired
    private BurgerService burgerService;
    
    public void loadBurgers() {

        Burger burger = new Burger();
        burger.setNom("Cheese burger");
        burger.setPrix(1500);
        burger.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
       
        
        Burger burger1 = new Burger();
        burger1.setNom("Burger Royal");
        burger1.setPrix(2000);
        burger1.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");


        Burger burger2 = new Burger();
        burger2.setNom("Burger Maison");
        burger2.setPrix(2500);
        burger2.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");


        burgerService.addBurger(burger);
        burgerService.addBurger(burger1);
        burgerService.addBurger(burger2);


    }
}
