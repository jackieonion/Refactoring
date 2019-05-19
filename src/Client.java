package src;

import java.util.Vector;

public class Client {
    private static final double EUROS_PER_UNITAT_DE_COST = 30;

    private String nif;
    private String nom;
    private String telefon;
    public Vector<Lloguer> lloguers;

    public Client(String nif, String nom, String telefon) {
        this.nif = nif;
        this.nom = nom;
        this.telefon = telefon;
        this.lloguers = new Vector<Lloguer>();
    }

    public String getNif()     { return nif;     }
    public String getNom()     { return nom;     }
    public String getTelefon() { return telefon; }

    public void setNif(String nif) { this.nif = nif; }
    public void setNom(String nom) { this.nom = nom; }
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    public void afegeix(Lloguer lloguer) {
        if (! lloguers.contains(lloguer) ) {
            lloguers.add(lloguer);
        }
    }
    public void elimina(Lloguer lloguer) {
        if (lloguers.contains(lloguer) ) {
            lloguers.remove(lloguer);
        }
    }
    public boolean conte(Lloguer lloguer) {
        return lloguers.contains(lloguer);
    }

    public String informe() {
        return composaCapsalera() +
                composaDetall() +
                composaPeu();
    }

    private String composaPeu() {
        return "Import a pagar: " + importTotal() + "€\n" +
                "Punts guanyats: " + bonificacionsTotals() + "\n";
    }

    private String composaDetall() {
        String resultat = "";

        for (Lloguer lloguer: lloguers) {
            // composa els resultats d'aquest lloguer
            resultat += "\t" +
                    lloguer.getVehicle().getMarca() +
                    " " +
                    lloguer.getVehicle().getModel() + ": " +
                    (lloguer.unitatsDeCost() * EUROS_PER_UNITAT_DE_COST) + "€" + "\n";
        }
        return resultat;
    }

    private String composaCapsalera() {
        return "Informe de lloguers del client " +
                getNom() +
                " (" + getNif() + ")\n";
    }

    private int bonificacionsTotals() {
        int bonificacions = 0;

        for (Lloguer lloguer: lloguers) {
            bonificacions += lloguer.bonificacions();
        }

        return bonificacions;
    }

    private double importTotal() {

        double total = 0;

        for(Lloguer lloguer: lloguers) {
            total += lloguer.unitatsDeCost() * EUROS_PER_UNITAT_DE_COST;
        }

        return total;
    }


    public int contaLloguers() {
        return lloguers.size();
    }

    public String informeHTML() {
        return composaCapsaleraHTML() +
                composaDetallHTML() +
                composaPeuHTML();
    }

    private String composaPeuHTML() {
        return "</table>\n" +
                "<p>Import a pagar: <em>" + importTotal() + "€</em></p>\n" +
                "<p>Punts guanyats: <em>" + bonificacionsTotals() + "</em></p>";
    }

    private String composaDetallHTML() {
        String resultat = "";
        for (Lloguer lloguer : lloguers) {  // <tr><td>Wolswagen</td><td>Passat</td><td>270.0€</td></tr>
            resultat += "<tr><td>" + lloguer.getVehicle().getMarca() + "</td><td>" +
                    lloguer.getVehicle().getModel() + "</td><td>" +
                    lloguer.unitatsDeCost() * EUROS_PER_UNITAT_DE_COST + "€</td></tr>\n";
        }
        return resultat;
    }

    private String composaCapsaleraHTML() {
        return "<h1>Informe de lloguers</h1>\n" +
                "<p>Informe de lloguers del client <em>" + getNom() + "</em> (<strong>" + getNif() + "</strong>)</p>\n" +
                "<table>\n<tr><td><strong>Marca</strong></td><td><strong>Model</strong></td><td><strong>Import</strong></td></tr>     ";
    }
}