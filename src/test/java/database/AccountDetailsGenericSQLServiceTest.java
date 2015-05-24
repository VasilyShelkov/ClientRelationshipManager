package database;

import dataObjects.Account;
import dataObjects.Name;
import database.account.AccountDetailsSQLService;
import database.names.AccountClientsSQLService;
import database.names.AccountProtectedNamesSQLService;
import database.names.AccountUnprotectedNamesSQLService;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AccountDetailsGenericSQLServiceTest {

    private AccountDetailsSQLService accountDetailsJOOQSQLService;
    private AccountUnprotectedNamesSQLService accountAccountUnprotectedNamesSQLService;
    private AccountProtectedNamesSQLService accountProtectedNamesSQLService;
    private AccountClientsSQLService accountAccountClientsSQLService;
    private String url = "jdbc:mysql://localhost:3306/protectme";
    private String user = "root";
    private String pass = "root";

    @Before
    public void setUp() throws Exception {
        ConnectionService connectionService = new ConnectionService(url, user, pass);
        accountDetailsJOOQSQLService = new AccountDetailsSQLService(connectionService);
        accountAccountUnprotectedNamesSQLService = new AccountUnprotectedNamesSQLService(connectionService);
        accountProtectedNamesSQLService = new AccountProtectedNamesSQLService(connectionService);
        accountAccountClientsSQLService = new AccountClientsSQLService(connectionService);
    }

    @Test
    public void testGetAccountDetail() throws Exception {
        Timestamp createdAt = new Timestamp(new DateTime().withYear(2014).withMonthOfYear(11).withDayOfMonth(18).withTime(21,48,34,0).getMillis());
        Account testAccount = new Account(2, "testName", "testUsername", null, false, createdAt, 0);

        Account actualAccount = accountDetailsJOOQSQLService.getAccountDetail("testUsername");

        assertEquals(actualAccount.getName(), testAccount.getName());
        assertEquals(actualAccount.getUserName(), testAccount.getUserName());
        assertEquals(actualAccount.getAdmin(), testAccount.getAdmin());
        assertEquals(actualAccount.getCreatedAt(), testAccount.getCreatedAt());
        assertEquals(actualAccount.getPictureID(), testAccount.getPictureID());
    }

    @Test
    public void testGetAccountUnprotectedNames() throws Exception {
        Name testName = new Name(1, "Graham", "Hall", "97293609", "", "Alshaya", 0);

        List<Name> actualUnprotectedNames = accountAccountUnprotectedNamesSQLService.getUnprotectedNames(1);

        assertEquals(actualUnprotectedNames.get(0).getFirstName(), testName.getFirstName());
        assertEquals(actualUnprotectedNames.get(0).getOtherNames(), testName.getOtherNames());
        assertEquals(actualUnprotectedNames.get(0).getMobileNumber(), testName.getMobileNumber());
        assertEquals(actualUnprotectedNames.get(0).getOfficeNumber(), testName.getOfficeNumber());
        assertEquals(actualUnprotectedNames.get(0).getCompany(), testName.getCompany());
        assertEquals(actualUnprotectedNames.size(), 4);
    }


    //TODO fix these sql tests
    /*@Test
    public void testGetAccountProtectedNames() throws Exception {
        Timestamp time = new Timestamp(new DateTime().withYear(2014).withMonthOfYear(11).withDayOfMonth(19).withTime(18,39,32,0).getMillis());
        ProtectedName testProtectedName = new ProtectedName("testComments", true, false, time, time, time, ProtectedNamesPriority.Low);

        List<Name> actualProtectedNames = accountProtectedNamesSQLService.getProtectedNames(1);

        Name name = actualProtectedNames.get(0);
        assertEquals(name.getFirstName(), testProtectedName.getFirstName());
        assertEquals(name.getOtherNames(), testProtectedName.getOtherNames());
        assertEquals(name.getMobileNumber(), testProtectedName.getMobileNumber());
        assertEquals(name.getOfficeNumber(), testProtectedName.getOfficeNumber());
        assertEquals(name.getCompany(), testProtectedName.getCompany());
        assertEquals(actualProtectedNames.size(), 3);
    }

    @Test
    public void testGetAccountClients() throws Exception {
        Timestamp clientAt = new Timestamp(new DateTime().withYear(2014).withMonthOfYear(11).withDayOfMonth(19).withTime(19,5,41,0).getMillis());
        Client testClient = new Client(1, "Neil", "Smith", "96621344", "N/A", "G4S", 0, clientAt);

        List<Name> actualClients = accountAccountClientsSQLService.getClients(1);

        assertEquals(actualClients.get(0).getFirstName(), testClient.getFirstName());
        assertEquals(actualClients.get(0).getOtherNames(), testClient.getOtherNames());
        assertEquals(actualClients.get(0).getMobileNumber(), testClient.getMobileNumber());
        assertEquals(actualClients.get(0).getOfficeNumber(), testClient.getOfficeNumber());
        assertEquals(actualClients.get(0).getCompany(), testClient.getCompany());
        assertEquals(actualClients.size(), 1);
    }*/
}