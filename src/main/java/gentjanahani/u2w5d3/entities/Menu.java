package gentjanahani.u2w5d2.entities;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Component
public class Menu {
    private List<ElementiMenu> pizzas;
    private List<Toppings> toppings;
    private List<Drinks> drinks;

    public void printMenu(){
        System.out.println("----MENU' PIZZERIA-----");

        System.out.println("---PIZZE----");
        pizzas.forEach(p -> p.printInfo());

        System.out.println("---TOPPINGS----");
        toppings.forEach(t->t.printInfo());

        System.out.println("---DRINKS----");
        drinks.forEach(d->d.printInfo());
    }


}
