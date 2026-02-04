package gentjanahani.u2w5d2.runners;

import gentjanahani.u2w5d2.U2w5d2Application;
import gentjanahani.u2w5d2.entities.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {


    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(U2w5d2Application.class);
        System.out.println("****************************");
        System.out.println("----Ciao dal mio runner----");
        try{
            Menu menu=ctx.getBean(Menu.class);
            menu.printMenu();

            Table t1=(Table) ctx.getBean("tavolo1");

            Order order1=new Order(t1, 3);
            order1.addItems(ctx.getBean("margherita", Pizza.class));
            order1.addItems(ctx.getBean("hawaiian", Pizza.class));
            order1.addItems(ctx.getBean("margherita", Pizza.class));
            order1.addItems(ctx.getBean("water", Drinks.class));
            order1.addItems(ctx.getBean("wine", Drinks.class));
            order1.addItems(ctx.getBean("wine", Drinks.class));


            System.out.println("*******ORDINI*********");
            System.out.println("DETTAGLI TAVOLO 1");
            order1.printOrder();
            System.out.println("Totale: € " + order1.calcolaTotale());
            System.out.println("************GRAZIE E ARRIVEDERCI******");

        }catch (Exception ex) {
            System.err.println(ex.getMessage());
        } finally {
            ctx.close();
        }
    }
}
