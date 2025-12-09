package persistance;

import models.Vehicle;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDao {
    private BasicDataSource ds;

    public VehicleDao(BasicDataSource ds) {
        this.ds = ds;
    }

    public List<Vehicle> getAllVehicles() throws SQLException {
        List<Vehicle> vehicles = new ArrayList<>();
        String query = "SELECT * FROM vehicles";

        try(
                Connection connection = ds.getConnection();
                PreparedStatement statement = connection.prepareStatement(query);
                ResultSet results = statement.executeQuery()
        ){
           vehicles = getVehiclesFromResultSet(results);
        }
        return vehicles;
    }

    private List<Vehicle> getVehiclesFromResultSet(ResultSet results) throws SQLException {

        List<Vehicle> vehicles = new ArrayList<>();

        while(results.next()){
            String vin = results.getString("Vin");
            int year = results.getInt("Year");
            String make = results.getString("Make");
            String model = results.getString("Model");
            String vehicleTYpe = results.getString("VehicleType");
            String color = results.getString("Color");
            int odometer = results.getInt("Odometer");
            double price = results.getDouble("price");
            boolean isSold = results.getBoolean("Sold");

            Vehicle v = new Vehicle(vin, year, make, model, vehicleTYpe, color, odometer, price, isSold);
            vehicles.add(v);
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByPrice(double min, double max) throws SQLException {
        List<Vehicle> vehicles = new ArrayList<>();

        try(Connection connection = ds.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM vehicles WHERE Price BETWEEN ? AND ?")
        ){
            preparedStatement.setDouble(1, min);
            preparedStatement.setDouble(2, max);

            try(ResultSet results = preparedStatement.executeQuery()){
                vehicles = getVehiclesFromResultSet(results);
            }
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByMileage(double min, double max) throws SQLException {
        List<Vehicle> vehicles = new ArrayList<>();

        try(Connection connection = ds.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM vehicles WHERE Odometer BETWEEN ? AND ?")
        ){
            preparedStatement.setDouble(1, min);
            preparedStatement.setDouble(2, max);

            try(ResultSet results = preparedStatement.executeQuery()){

                while(results.next()){
                    String vin = results.getString("Vin");
                    int year = results.getInt("Year");
                    String make = results.getString("Make");
                    String model = results.getString("Model");
                    String vehicleTYpe = results.getString("VehicleType");
                    String color = results.getString("Color");
                    int odometer = results.getInt("Odometer");
                    double price = results.getDouble("price");
                    boolean isSold = results.getBoolean("Sold");

                    Vehicle v = new Vehicle(vin, year, make, model, vehicleTYpe, color, odometer, price, isSold);
                    vehicles.add(v);
                }
            }
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByMakeModel(String makeSearch, String modelSearch) throws SQLException {
        List<Vehicle> vehicles = new ArrayList<>();

        try(Connection connection = ds.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM vehicles WHERE Make = ? AND Model = ?")
        ){
            preparedStatement.setString(1, makeSearch);
            preparedStatement.setString(2, modelSearch);

            try(ResultSet results = preparedStatement.executeQuery()){

                while(results.next()){
                    String vin = results.getString("Vin");
                    int year = results.getInt("Year");
                    String make = results.getString("Make");
                    String model = results.getString("Model");
                    String vehicleTYpe = results.getString("VehicleType");
                    String color = results.getString("Color");
                    int odometer = results.getInt("Odometer");
                    double price = results.getDouble("price");
                    boolean isSold = results.getBoolean("Sold");

                    Vehicle v = new Vehicle(vin, year, make, model, vehicleTYpe, color, odometer, price, isSold);
                    vehicles.add(v);
                }
            }
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByYear(int min, int max) throws SQLException {
        List<Vehicle> vehicles = new ArrayList<>();

        try(Connection connection = ds.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM vehicles WHERE Year BETWEEN ? AND ?")
        ){
            preparedStatement.setInt(1, min);
            preparedStatement.setInt(2, max);

            try(ResultSet results = preparedStatement.executeQuery()){

                while(results.next()){
                    String vin = results.getString("Vin");
                    int year = results.getInt("Year");
                    String make = results.getString("Make");
                    String model = results.getString("Model");
                    String vehicleTYpe = results.getString("VehicleType");
                    String color = results.getString("Color");
                    int odometer = results.getInt("Odometer");
                    double price = results.getDouble("price");
                    boolean isSold = results.getBoolean("Sold");

                    Vehicle v = new Vehicle(vin, year, make, model, vehicleTYpe, color, odometer, price, isSold);
                    vehicles.add(v);
                }
            }
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByColor(String colorSearch) throws SQLException {
        List<Vehicle> vehicles = new ArrayList<>();

        try (Connection connection = ds.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM vehicles WHERE Color = ?")
        ) {
            preparedStatement.setString(1, colorSearch);

            try (ResultSet results = preparedStatement.executeQuery()) {

                while (results.next()) {
                    String vin = results.getString("Vin");
                    int year = results.getInt("Year");
                    String make = results.getString("Make");
                    String model = results.getString("Model");
                    String vehicleType = results.getString("VehicleType");
                    String color = results.getString("Color");
                    int odometer = results.getInt("Odometer");
                    double price = results.getDouble("price");
                    boolean isSold = results.getBoolean("Sold");

                    Vehicle v = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price, isSold);
                    vehicles.add(v);
                }
            }
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByVehicleType(String vehicleTypeSearch) throws SQLException {
        List<Vehicle> vehicles = new ArrayList<>();

        try (Connection connection = ds.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM vehicles WHERE VehicleType = ?")
        ) {
            preparedStatement.setString(1, vehicleTypeSearch);

            try (ResultSet results = preparedStatement.executeQuery()) {

                while (results.next()) {
                    String vin = results.getString("Vin");
                    int year = results.getInt("Year");
                    String make = results.getString("Make");
                    String model = results.getString("Model");
                    String vehicleTYpe = results.getString("VehicleType");
                    String color = results.getString("Color");
                    int odometer = results.getInt("Odometer");
                    double price = results.getDouble("price");
                    boolean isSold = results.getBoolean("Sold");

                    Vehicle v = new Vehicle(vin, year, make, model, vehicleTYpe, color, odometer, price, isSold);
                    vehicles.add(v);
                }
            }
        }
        return vehicles;
    }

    public Vehicle addVehicle(String vin, int year, String make, String model, String vehicleType, String color, int odometer, double price, boolean isSold) throws SQLException {
        try(Connection connection = ds.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO vehicles (VIN, Year, Make, Model, VehicleType, Color, Odometer, price, Sold) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
        ){

            preparedStatement.setString(1, vin);
            preparedStatement.setInt(2, year);
            preparedStatement.setString(3,make);
            preparedStatement.setString(4, model);
            preparedStatement.setString(5, vehicleType);
            preparedStatement.setString(6, color);
            preparedStatement.setInt(7, odometer);
            preparedStatement.setDouble(8, price);
            preparedStatement.setBoolean(9, isSold);

            preparedStatement.executeUpdate();
        }
            return new Vehicle(vin, year, make, model, vehicleType, color, odometer, price, isSold);
    }
}
