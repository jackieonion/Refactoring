package src;

import java.util.Date;

public class Lloguer {
    private static final double PLUS_LLOGUER_LLARG_BASIC = 1.5;
    private static final double PLUS_LLOGUER_LLARG_GENERAL = 2.5;
    private static final int DIES_INICIALS_BASIC = 3;
    private static final int DIES_INICIALS_GENERAL = 2;
    private final int COST_VEHICLE_BASIC = 3;
    private final int COST_VEHICLE_GENERAL = 4;
    private final int COST_VEHICLE_LUXE = 6;

    private Date data;
    private int dies;
    private Vehicle vehicle;

    public Lloguer(Date data, int dies, Vehicle vehicle) {
        this.data = data;
        this.dies = dies;
        this.vehicle= vehicle;
    }

    public Date getData() { return data; }

    public int getDies() { return dies; }

    public Vehicle getVehicle() { return vehicle; }

    public void setData(Date data) { this.data = data; }

    public void setDies(int dies) { this.dies = dies; }

    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }

    public double unitatsDeCost() {
        double UnitatsDeCost = 0;

        switch (this.getVehicle().getCategoria()) {
            case Vehicle.BASIC:
                UnitatsDeCost += COST_VEHICLE_BASIC;
                if (this.getDies() > DIES_INICIALS_BASIC) {
                    UnitatsDeCost += (this.getDies() - DIES_INICIALS_BASIC) * PLUS_LLOGUER_LLARG_BASIC;
                }
                break;
            case Vehicle.GENERAL:
                UnitatsDeCost += COST_VEHICLE_GENERAL;
                if (this.getDies() > DIES_INICIALS_GENERAL) {
                    UnitatsDeCost += (this.getDies() - DIES_INICIALS_GENERAL) * PLUS_LLOGUER_LLARG_GENERAL;
                }
                break;
            case Vehicle.LUXE:
                UnitatsDeCost += this.getDies() * COST_VEHICLE_LUXE;
                break;
        }

        return UnitatsDeCost;
    }

    public int bonificacions() {
        int bonificacions = 0;
        // afegeix lloguers freqüents
        bonificacions ++;

        // afegeix bonificació per dos dies de lloguer de Luxe
        if (this.getVehicle().getCategoria() == Vehicle.LUXE &&
                this.getDies()>1 ) {
            bonificacions ++;
        }

        return bonificacions;
    }
}
