package gentjanahani.u2w5d3;

import gentjanahani.u2w5d3.entities.Order;
import gentjanahani.u2w5d3.entities.Pizza;
import gentjanahani.u2w5d3.entities.Table;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

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


}
