package org.example;

import org.example.dao.VehicleDAO;
import org.example.entity.Vehicle;

public class App
{
    public static void main( String[] args ) {
        VehicleDAO vehicleDAO = new VehicleDAO();
        //vehicleDAO.saveVehicle(new Vehicle("czarny", "ford", "fiesta","2004-8-23","PB95" ));
        //System.out.println(vehicleDAO.getById(2));

        Vehicle vehicle = vehicleDAO.getById(1);
        vehicle.setFuel("ON");
        vehicleDAO.update(vehicle);
    }

}
