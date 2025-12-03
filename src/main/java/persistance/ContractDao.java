package persistance;

import org.apache.commons.dbcp2.BasicDataSource;

public class ContractDao {
    private BasicDataSource ds;

    public ContractDao(BasicDataSource ds) {
        this.ds = ds;
    }
}
