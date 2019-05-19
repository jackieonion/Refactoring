package src;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class GestorLloguersLite {

    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static Client creaClient() throws ParseException {
        Client sebas = new Client("X4381040T", "Sebastián Fornelli", "634679443");

        sebas.afegeix(new Lloguer(dateFormat.parse("02/08/2013"),
                 10,
                      new Vehicle("Vista", "Tata", Vehicle.BASIC)));

        sebas.afegeix(new Lloguer(dateFormat.parse("18/09/2013"),
                20,
                new Vehicle("Sirocco", "Volkswagen", Vehicle.GENERAL)));

        sebas.afegeix(new Lloguer(dateFormat.parse("12/11/2013"),
                30,
                new Vehicle("Ninja", "Kawasaki", Vehicle.LUXE)));

        return sebas;
    }

    public static String toString(Client client) {
        String string = "Client: " + client.getNom() + "\n\t\t"
                        + client.getNif() + "\n\t\t"
                        + client.getTelefon() + "\n"
                        + "Lloguers: " + client.contaLloguers() + "\n\t\t";

        for (int x = 0; x < client.contaLloguers(); x++){
            string += x + 1 + ".\tvehicle: " + client.lloguers.get(x).getVehicle().getMarca()
                    + " " + client.lloguers.get(x).getVehicle().getModel() + "\n\t\t\t" +
                    "data d'inici: " + dateFormat.format(client.lloguers.get(x).getData()) + "\n\t\t\t" +
                    "dies llogats: " + client.lloguers.get(x).getDies() + "\n\t\t";
        }

        return string;
    }
}
