package gentjanahani.u2w5d3.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Pizza extends ElementiMenu {

    ArrayList<Toppings> toppings;
    private boolean isXl = false;

    public Pizza(String name, ArrayList<Toppings> toppings, double price, boolean isXl) {

        super(name, price);
        Toppings tomato = new Toppings("Tomato", 50, 0.00);
        Toppings cheese = new Toppings("Cheese", 92, 0.69);
        this.isXl = isXl;
        this.toppings = new ArrayList<>();
        this.toppings.add(tomato);
        this.toppings.add(cheese);

        this.toppings.addAll(toppings);


    }

    public String getToppingsList() {
        List<String> ingredienti = new ArrayList<>();
        toppings.forEach(t -> ingredienti.add(t.getName()));
        return String.join(", ", ingredienti);
    }

    public int setCalories(List<Toppings> toppingsList, boolean isXl) {

        int tot = 1012;
        if (toppingsList != null) {
            for (int i = 0; i < toppingsList.size(); i++) {
                tot += toppingsList.get(i).getCalories();
            }

        }

        if (isXl) return tot += (tot * 10) / 100;
        else return tot;
    }

    @Override
    public void printInfo() {
        System.out.println(getName() + " - " +
                " (" + getToppingsList() + ")  " +
                " - " + getCalories() + " kcal - € " +
                getPrice());


    }
}
