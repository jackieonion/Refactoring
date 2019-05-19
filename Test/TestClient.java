package Test;


import org.junit.Test;
import static org.junit.Assert.*;
import src.Client;
import src.GestorLloguersLite;
import src.Lloguer;
import src.Vehicle;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestClient {

    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");


    @Test
    //Test del mètode informe amb client creat automàticament per la funció creaClient()
    public void testInforme() throws ParseException {
        Client client = GestorLloguersLite.creaClient();

        assertEquals(client.informe(), "Informe de lloguers del client Sebastián Fornelli (X4381040T)\n" +
                "\tVista Tata: 405.0€\n" +
                "\tVolkswagen Sirocco: 1470.0€\n" +
                "\tKawasaki Ninja: 5400.0€\n" +
                "Import a pagar: 7275.0€\n" +
                "Punts guanyats: 4\n");
    }

    @Test
    public void testInformeSenseLloguer() {
        //
        Client client = new Client("X4334878T", "Juan Carlos", "655644688");
        assertEquals(client.informe(), "Informe de lloguers del client Juan Carlos (X4334878T)\n" +
                "Import a pagar: 0.0€\n" +
                "Punts guanyats: 0\n");
    }

    @Test
    public void testInformeLloguerBasicMoltsDies() throws ParseException {
        Client client = new Client("X4334878T", "Juan Carlos", "655644688");

        client.afegeix(new Lloguer(dateFormat.parse("02/08/2013"),
                100,
                new Vehicle("Tata", "Vista", Vehicle.BASIC)));

        assertEquals(client.informe(), "Informe de lloguers del client Juan Carlos (X4334878T)\n" +
                "\tVista Tata: 4455.0€\n" +
                "Import a pagar: 4455.0€\n" +
                "Punts guanyats: 1\n");
    }

    @Test
    public void TestInformeLloguerBasicUnDia() throws ParseException {
        Client client = new Client("X4334878T", "Juan Carlos", "655644688");

        client.afegeix(new Lloguer(dateFormat.parse("02/08/2013"),
                1,
                new Vehicle("Tata", "Vista", Vehicle.BASIC)));

        assertEquals(client.informe(), "Informe de lloguers del client Juan Carlos (X4334878T)\n" +
                "\tVista Tata: 90.0€\n" +
                "Import a pagar: 90.0€\n" +
                "Punts guanyats: 1\n");

    }

    @Test
    public void testInformeLloguerGeneralMoltsDies() throws ParseException {
        Client client = new Client("X4334878T", "Juan Carlos", "655644688");

        client.afegeix(new Lloguer(dateFormat.parse("02/08/2013"),
                100,
                new Vehicle("Tata", "Vista", Vehicle.GENERAL)));

        assertEquals(client.informe(), "Informe de lloguers del client Juan Carlos (X4334878T)\n" +
                "\tVista Tata: 7470.0€\n" +
                "Import a pagar: 7470.0€\n" +
                "Punts guanyats: 1\n");
    }

    @Test
    public void testInformeLloguerGeneralUnDia() throws ParseException {
        Client client = new Client("X4334878T", "Juan Carlos", "655644688");

        client.afegeix(new Lloguer(dateFormat.parse("02/08/2013"),
                1,
                new Vehicle("Tata", "Vista", Vehicle.GENERAL)));

        assertEquals(client.informe(), "Informe de lloguers del client Juan Carlos (X4334878T)\n" +
                "\tVista Tata: 120.0€\n" +
                "Import a pagar: 120.0€\n" +
                "Punts guanyats: 1\n");
    }

    @Test
    public void testInformeLloguerLuxeMoltsDies() throws ParseException {
        Client client = new Client("X4334878T", "Juan Carlos", "655644688");

        client.afegeix(new Lloguer(dateFormat.parse("02/08/2013"),
                100,
                new Vehicle("Tata", "Vista", Vehicle.LUXE)));

        assertEquals(client.informe(), "Informe de lloguers del client Juan Carlos (X4334878T)\n" +
                "\tVista Tata: 18000.0€\n" +
                "Import a pagar: 18000.0€\n" +
                "Punts guanyats: 2\n");
    }

    @Test
    public void testInformeLloguerLuxeUnDia() throws ParseException {
        Client client = new Client("X4334878T", "Juan Carlos", "655644688");

        client.afegeix(new Lloguer(dateFormat.parse("02/08/2013"),
                1,
                new Vehicle("Tata", "Vista", Vehicle.LUXE)));

        assertEquals(client.informe(), "Informe de lloguers del client Juan Carlos (X4334878T)\n" +
                "\tVista Tata: 180.0€\n" +
                "Import a pagar: 180.0€\n" +
                "Punts guanyats: 1\n");
    }



}
