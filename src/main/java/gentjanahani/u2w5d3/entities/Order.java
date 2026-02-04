package gentjanahani.u2w5d3.entities;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@Setter
@ToString
public class Order {
    private int numOrdine;
    private List<ElementiMenu> elementiOrdinati;
    private StatoOrdine statoOrdine;
    private int numCoperti;
    private LocalTime oraDiArrivo = LocalTime.now();
    private Table table;


    public Order(Table table, int numCoperti) {
        Random rndm = new Random();
        if (table.getNumeroCopertiMax() <= numCoperti)
            throw new RuntimeException("Numero coperti maggiore di quello consentito!");

        this.table = table;
        this.numCoperti = numCoperti;
        this.numOrdine = rndm.nextInt(100, 100000);
        this.elementiOrdinati = new ArrayList<>();
        this.statoOrdine = StatoOrdine.IN_CORSO;


    }

    public void assegnaTavolo(Table table) {
        this.table = table;
        table.setStatoTavolo(StatoTavolo.OCCUPATO);
        System.out.println("Stato del tavolo " + table.getNumTavolo() + " aggiornato correttamente: " + table.getStatoTavolo());
    }

    public void chiudiOrdine() {
        this.statoOrdine = StatoOrdine.SERVITO;
        this.table.setStatoTavolo(StatoTavolo.LIBERO);
        System.out.println("Servizio terminato. I clienti hanno liberato il tavolo.");
    }

    public void addItems(ElementiMenu item) {
        this.elementiOrdinati.add(item);
    }

    public double calcolaTotale() {
        double tot = 0;

        for (int i = 0; i < elementiOrdinati.size(); i++) {
            ElementiMenu elemento = elementiOrdinati.get(i);
            tot += elemento.getPrice();
        }
        tot += numCoperti * table.getCopertoCosto();
        System.out.println("Costo Coperto a persona: € " + table.getCopertoCosto());


        return tot;


    }


    public void printOrder() {

        System.out.println("Tavolo: " + getNumOrdine());
        System.out.println("Coperti: " + getNumCoperti());
        System.out.println("Stato ordine: " + getStatoOrdine());
        System.out.println("Ora di arrivo: " + getOraDiArrivo());
        System.out.println("Elementi ordinati:");

        elementiOrdinati.forEach(e ->
                System.out.println(e.getName() + " --- € " + e.getPrice()));


    }
}
