package org.example.dao;

import org.example.entity.Vehicle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import static org.example.DBConnector.createDBConnetion;


public class VehicleDAO {
    private static final String TABLE_NAME = "vehicles";
    public VehicleDAO(){
        Connection connection = createDBConnetion();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
                    "id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                    "color VARCHAR(255)," +
                    "brand VARCHAR(255)," +
                    "model VARCHAR(255)," +
                    "productionDate DATE," +
                    "fuel VARCHAR(255));";
            statement.executeUpdate(sql);
            statement.close();
            connection.close();
            System.out.println("Vehicle table ready!");
        }catch(SQLException e){
            System.out.println("Błąd podczas tworzenia statement " + e.getMessage());
        }
    }
    public void saveVehicle(Vehicle vehicle){
        Connection connection = createDBConnetion();
        try{
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO " + TABLE_NAME + "(color, brand, model, productionDate,fuel) VALUES ('" +
                    vehicle.getColor() +
                    "','" +
                    vehicle.getBrand() +
                    "','" +
                    vehicle.getModel() +
                    "','" +
                    vehicle.getProductionDate()+
                    "','" +
                    vehicle.getFuel()+
                    "');";
            statement.executeUpdate(sql);
            statement.close();
            connection.close();
            System.out.println("Vehicle saved!");
        } catch(SQLException e){
            System.out.println("Błąd podczas tworzenia statement" + e.getMessage());
        }

    }
    public Vehicle getById(long id){
        Connection connection = createDBConnetion();
        Vehicle vehicle = new Vehicle();
        try{
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM vehicles WHERE id = " + id + ";";
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){

                vehicle.setId(resultSet.getLong("id"));
                vehicle.setColor(resultSet.getString("color"));
                vehicle.setBrand(resultSet.getString("brand"));
                vehicle.setModel(resultSet.getString("model"));
                vehicle.setProductionDate(resultSet.getString("productionDate"));
                vehicle.setFuel(resultSet.getString("fuel"));
                break;
            }
            statement.close();
            connection.close();

        } catch(SQLException e){
            System.out.println("Błąd podczas tworzenia statement" + e.getMessage());
        }
        return vehicle;
    }
    public List<Vehicle> getAll(){
        List<Vehicle> vehicleList = new LinkedList<>();
        Connection connection = createDBConnetion();
        Vehicle vehicle = new Vehicle();
        try{
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM vehicles;";
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                Vehicle tempVehicle = new Vehicle();
                tempVehicle.setId(resultSet.getLong("id"));
                tempVehicle.setColor(resultSet.getString("color"));
                tempVehicle.setBrand(resultSet.getString("brand"));
                tempVehicle.setModel(resultSet.getString("model"));
                tempVehicle.setProductionDate(resultSet.getString("productionDate"));
                tempVehicle.setFuel(resultSet.getString("fuel"));
                vehicleList.add(tempVehicle);

            }
            statement.close();
            connection.close();

        } catch(SQLException e){
            System.out.println("Błąd podczas tworzenia statement" + e.getMessage());
        }
        return vehicleList;
    }
    public void deleteById(long id){
        Connection connection = createDBConnetion();
        try{
            Statement statement = connection.createStatement();
            String sql = "DELETE FROM vehicles WHERE id = " + id + ";";
            statement.executeUpdate(sql);
            statement.close();
            connection.close();
            System.out.println("Vehicle deleted!");
        } catch(SQLException e){
            System.out.println("Błąd podczas tworzenia statement" + e.getMessage());
        }
    }

    public void update(Vehicle vehicle){
        Connection connection = createDBConnetion();
        try{
            Statement statement = connection.createStatement();
            String sql = "UPDATE " + TABLE_NAME +
                    " SET color = '" + vehicle.getColor() + "', " +
                    "brand = '" + vehicle.getBrand() + "'," +
                    "model = '" + vehicle.getModel() + "'," +
                    "productionDate = '" + vehicle.getProductionDate() + "'," +
                    "fuel = '" + vehicle.getFuel() + "'" +
                    " WHERE id = " + vehicle.getId() + ";";
            statement.executeUpdate(sql);
            statement.close();
            connection.close();
            System.out.println("Vehicle updated!");
        } catch(SQLException e){
            System.out.println("Błąd podczas tworzenia statement" + e.getMessage());
        }
    }
}
