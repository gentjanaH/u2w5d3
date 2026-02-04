package gentjanahani.u2w5d2.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class Toppings extends ElementiMenu  {


    public Toppings(String name, int calories, double price) {
        super(name, calories, price);
    }

    public void printInfo(){
        System.out.println(getName() + " - " +
                getCalories() +" kcal - € " +
                getPrice());
    };
};



