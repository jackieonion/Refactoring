package Test;


import org.junit.Test;
import static org.junit.Assert.*;
import src.Client;
import src.GestorLloguersLite;

import java.text.ParseException;

public class TestClient {

    @Test
    public void testInforme() throws ParseException {
        Client client = GestorLloguersLite.creaClient();

        assertEquals(client.informe(), "Informe de lloguers del client Sebastián Fornelli (X4381040T)\n" +
                "\tVista Tata: 405.0€\n" +
                "\tVolkswagen Sirocco: 1470.0€\n" +
                "\tKawasaki Ninja: 5400.0€\n" +
                "Import a pagar: 7275.0€\n" +
                "Punts guanyats: 4\n");
    }

}
