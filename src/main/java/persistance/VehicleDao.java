package persistance;

import models.Vehicle;
import org.apache.commons.dbcp2.BasicDataSource;

import java.util.ArrayList;
import java.util.List;

public class VehicleDao {
    private BasicDataSource ds;

    public VehicleDao(BasicDataSource ds) {
        this.ds = ds;
    }

    public List<Vehicle> getAllVehicles(){
        List<Vehicle> vehicles = new ArrayList<>();

        return vehicles;
    }


}
