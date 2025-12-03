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
            while(results.next()){
                int vin = results.getInt(0);
                int year = results.getInt(1);
                String make = results.getString(2);
                String model = results.getString(3);
                String vehicleTYpe = results.getString(4);
                String color = results.getString(5);
                int Odometer = results.getInt(6);
            }
        }

        return vehicles;
    }


}
