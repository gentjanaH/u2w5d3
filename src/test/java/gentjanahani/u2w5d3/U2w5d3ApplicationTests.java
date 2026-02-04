package gentjanahani.u2w5d3;

import gentjanahani.u2w5d3.entities.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class U2w5d3ApplicationTests {


    @Autowired
    private AnnotationConfigApplicationContext ctx;

    @Test
    void testCalcolaTotale() {
        Table tavolo = (Table) ctx.getBean("tavolo1");
        Order ordineTest = new Order(tavolo, 2);
        ordineTest.addItems((Pizza) ctx.getBean("margherita"));
        ordineTest.addItems((Pizza) ctx.getBean("margherita"));

        double tot = ordineTest.calcolaTotale();
        assertEquals(12.98, tot);


    }


    @Test
    void testAssegnaTavolo() {
        Table tavolo = (Table) ctx.getBean("tavolo1");
        Order ordineTest = new Order(tavolo, 2);
        ordineTest.assegnaTavolo(tavolo);

        assertEquals(StatoTavolo.OCCUPATO, tavolo.getStatoTavolo());
    }

    @Test
    void testLiberaTavolo() {
        Table tavolo = (Table) ctx.getBean("tavolo1");
        Order ordineTest = new Order(tavolo, 2);

        ordineTest.chiudiOrdine();
        assertEquals(StatoTavolo.LIBERO, tavolo.getStatoTavolo());
    }

    @Test
    void testExeption() {
        Table tavolo = (Table) ctx.getBean("tavolo1");

        assertThrows(RuntimeException.class, () -> new Order(tavolo, 5));
    }

    @ParameterizedTest
    @CsvSource({"1.00, 2", "2.00, 2", "3.00, 2"})
    void testCostoCopertoVariabile(double costoCoperto, int coperti) {
        Table tavolo = new Table(1, 4, StatoTavolo.LIBERO, costoCoperto);
        Order ordine = new Order(tavolo, coperti);

        ordine.addItems(new Drinks("water", 0, 1.00));
        double risultatoAtteso = 1.00 + (coperti * costoCoperto);
        assertEquals(risultatoAtteso, ordine.calcolaTotale());
    }
}
