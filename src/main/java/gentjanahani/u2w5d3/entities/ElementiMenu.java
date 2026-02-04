package gentjanahani.u2w5d2.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public abstract class ElementiMenu {
    private String name;
    private int calories;
    private double price;

    public abstract void printInfo();
    }

