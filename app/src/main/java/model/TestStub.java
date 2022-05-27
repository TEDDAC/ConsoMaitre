package model;

import android.util.Log;

public class TestStub {
    public static void devConfigManager(){
        Manager manager = Manager.getInstance();

        Vehicule camion = new Vehicule("Camion");
        camion.getPleins().add(new Plein(52000,(float)66.50,(float)33.1));
        camion.getPleins().add(new Plein(38343,(float)57.64,(float)43.5));
        manager.getVehicules().add(camion);

        Vehicule opel = new Vehicule("Opel");
        opel.getPleins().add(new Plein(12072,(float)66.50,(float)33.1));
        opel.getPleins().add(new Plein(80375,(float)57.64,(float)43.5));
        manager.getVehicules().add(opel);

        Log.d("TestStub",manager.toString());
    }
}
