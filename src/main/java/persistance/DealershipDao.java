package persistance;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DealershipDao {
    private BasicDataSource ds;

    public DealershipDao(BasicDataSource ds) {
        this.ds = ds;
    }

    public void addVehicleToInventory(int dealershipID, String VIN) throws SQLException {
        try(Connection connection = ds.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO inventory (dealershipID, VIN) VALUES (?, ?);")

        ){
            preparedStatement.setInt(1, dealershipID);
            preparedStatement.setString(2, VIN);

            preparedStatement.executeUpdate();
        }
    }

}
