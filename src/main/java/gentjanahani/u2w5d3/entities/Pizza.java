package gentjanahani.u2w5d2.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Pizza extends ElementiMenu {

    ArrayList<Toppings> toppings;

    public Pizza(String name,ArrayList<Toppings> toppings, int calories, double price){

        super(name, calories, price);
        Toppings tomato=new Toppings("Tomato", 50, 0.00);
        Toppings cheese=new Toppings("Cheese", 92, 0.69);
        this.toppings= new ArrayList<>();
        this.toppings.add(tomato);
        this.toppings.add(cheese);

        this.toppings.addAll(toppings);



    }

    public String getToppingsList(){
        List<String> ingredienti=new ArrayList<>();
       toppings.forEach(t-> ingredienti.add(t.getName()));
       return String.join(", ", ingredienti);
    }

    @Override
    public void printInfo() {
        System.out.println(getName() + " - " +
                        " (" + getToppingsList()+ ")  "+
                " - " +  getCalories() +" kcal - € " +
                getPrice());


    }
}
