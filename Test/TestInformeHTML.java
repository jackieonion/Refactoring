package Test;


import org.junit.Test;
import static org.junit.Assert.*;
import static src.GestorLloguersLite.creaClient;

import src.Client;
import src.GestorLloguersLite;
import src.Lloguer;
import src.Vehicle;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestInformeHTML {

    @Test
    //Test per client creat automàticament amb la funció creaClient
    public static void testInformeHTML() throws ParseException {
        Client client = GestorLloguersLite.creaClient();

        assertEquals(client.informeHTML(), "<h1>Informe de lloguers</h1>\n" +
                "<p>Informe de lloguers del client <em>Sebastián Fornelli</em> (<strong>X4381040T</strong>)</p>\n" +
                "<table>\n" +
                "<tr><td><strong>Marca</strong></td><td><strong>Model</strong></td><td><strong>Import</strong></td></tr>     <tr><td>Tata</td><td>Vista</td><td>405.0€</td></tr>\n" +
                "    <tr><td>Volkswagen</td><td>Sirocco</td><td>1470.0€</td></tr>\n" +
                "    <tr><td>Kawasaki</td><td>Ninja</td><td>5400.0€</td></tr>\n" +
                "</table>\n" +
                "<p>Import a pagar: <em>7275.0€</em></p>\n" +
                "<p>Punts guanyats: <em>4</em></p>\n");
    }

    @Test
    public void testInformeHTMLSenseLloguer() {
        Client client = new Client("X4334878T", "Juan Carlos", "655644688");
        assertEquals(client.informeHTML(), "<h1>Informe de lloguers</h1>\n" +
                "<p>Informe de lloguers del client <em>Sebastián Fornelli</em> (<strong>X4381040T</strong>)</p>\n" +
                "<p>Import a pagar: <em>0.0€</em></p>\n" +
                "<p>Punts guanyats: <em>0</em></p>\n");
    }
}
