package database;

import dataObjects.Account;
import database.generic.GenericAccountSQLService;
import generated.Tables;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GenericSQLServiceTest {

    private GenericAccountSQLService GenericSQLService;
    private ConnectionService connectionService;
    private String url = "jdbc:mysql://localhost:3306/protectme";
    private String user = "root";
    private String pass = "root";
    private List<Account> accountList;

    @Before
    public void setUp() throws Exception {
        connectionService = new ConnectionService(url, user, pass);
        GenericSQLService = new GenericAccountSQLService(Account.class, connectionService);
    }

    @Test
    public void retrievesAccounts() throws SQLException, InstantiationException, IllegalAccessException {
        Timestamp createdAt = new Timestamp(new DateTime().withYear(2014).withMonthOfYear(11).withDayOfMonth(13).withTime(22,23,27,0).getMillis());
        Account testAccount = new Account(1, "Mathew Turner", "regency", null, true, createdAt, 0);

        accountList = GenericSQLService.getTable(Tables.ACCOUNTS);

        assertEquals(accountList.get(0), testAccount);
        assertEquals(accountList.size(), 3);
    }
}