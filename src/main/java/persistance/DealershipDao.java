package persistance;

import org.apache.commons.dbcp2.BasicDataSource;

public class DealershipDao {
    private BasicDataSource ds;

    public DealershipDao(BasicDataSource ds) {
        this.ds = ds;
    }
}
