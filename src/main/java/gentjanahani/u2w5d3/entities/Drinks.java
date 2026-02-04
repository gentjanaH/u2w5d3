package gentjanahani.u2w5d3.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class Drinks extends ElementiMenu{


    public Drinks(String name, int calories, double price) {
        super(name, calories, price);
    }

    public  void printInfo(){
        System.out.println(getName() + " - " +
                getCalories() +" kcal - € " +
                getPrice());
    };
}
