package gentjanahani.u2w5d2.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Table {
    private int numTavolo;
    private int numeroCopertiMax;
    private StatoTavolo statoTavolo;
    private double copertoCosto;
}
