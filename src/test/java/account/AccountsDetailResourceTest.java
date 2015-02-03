package account;

import dataObjects.Account;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

/**
 * Created by Vasia on 08/11/2014.
 */
@RunWith(MockitoJUnitRunner.class)
public class AccountsDetailResourceTest {

    @Mock
    AccountDetailServiceImpl mockAccountDetailServiceImpl;

    private AccountsDetailResource accountsDetailResource;
    private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private Timestamp currentTime;

    @Before
    public void setUp() {
        accountsDetailResource = new AccountsDetailResource(mockAccountDetailServiceImpl, factory.getValidator());
        currentTime = new Timestamp(DateTime.now().getMillis());
    }

    @Test
    public void getAccountDetailTest() throws IllegalAccessException, SQLException, InstantiationException {
        int okStatus = 200;
        Timestamp currentTime = new Timestamp(DateTime.now().getMillis());
        Account account = new Account(1, "test", "testUserName", null, true, currentTime, 1);

        when(mockAccountDetailServiceImpl.getAccountDetails(1)).thenReturn(account);
        Response response = accountsDetailResource.getAccountDetails(1);

        assertEquals(response.getStatus(), okStatus);
        assertEquals(response.getEntity(), account);
    }

    @Test
    public void getAccountDetailErrorTest() throws SQLException, IllegalAccessException, InstantiationException {
        int errorStatus = 500;
        String errorMessage = "You Have An Error";

        when(mockAccountDetailServiceImpl.getAccountDetails(1)).thenThrow(new SQLException("You Have An Error"));
        Response response = accountsDetailResource.getAccountDetails(1);

        assertEquals(response.getStatus(), errorStatus);
        assertEquals(response.getEntity(), errorMessage);
    }

    @Test
    public void updateAccountWithExistingAccountUsername() throws SQLException, IllegalAccessException, InstantiationException {
        int conflictStatus = 409;
        String errorMessage = "Can not change originalUserName's username to testNewUserName because a different account is already using that username";
        Account testAccount = new Account("test", "testNewUserName", "testPass", true);
        Account originalAccount = new Account(1, "originalTestName", "originalUserName", null, true, currentTime, 1);

        when(mockAccountDetailServiceImpl.getAccountDetails(eq("testNewUserName"))).thenReturn(testAccount);
        when(mockAccountDetailServiceImpl.getAccountDetails(2)).thenReturn(originalAccount);
        Response response = accountsDetailResource.updateAccount(2, testAccount);

        assertEquals(response.getStatus(), conflictStatus);
        assertEquals(response.getEntity(), errorMessage);
    }

    @Test
    public void updateFaultyAccount() throws SQLException, IllegalAccessException, InstantiationException {
        int badRequestStatus = 400;
        String actual = "Your name may not be empty";
        Account testAccount = new Account("", "testUserName", "testPass", true);
        Account originalAccount = new Account(1, "differentTestName", "differentUserName", null, true, currentTime, 1);

        when(mockAccountDetailServiceImpl.getAccountDetails(1)).thenReturn(null);
        when(mockAccountDetailServiceImpl.getAccountDetails(2)).thenReturn(originalAccount);
        Response response = accountsDetailResource.updateAccount(2, testAccount);

        assertEquals(response.getStatus(), badRequestStatus);
        assertEquals(((Set<ConstraintViolation<Account>>) response.getEntity()).size(), 1);
        assertEquals(((Set<ConstraintViolation<Account>>) response.getEntity()).iterator().next().getMessage(), actual);
    }

    @Test
    public void updateAccountSuccessfully() throws SQLException, IllegalAccessException, InstantiationException {
        int updatedStatus = 200;
        Account testAccount = new Account("test", "testUserName", "testPass", true);
        Account originalAccount = new Account(2, "differentTestName", "differentUserName", true, currentTime, 1);

        Account expectedAccount = new Account(2, "test", "testUserName", null, true, currentTime, 1);
        when(mockAccountDetailServiceImpl.getAccountDetails(eq("testUserName"))).thenReturn(null);
        when(mockAccountDetailServiceImpl.getAccountDetails(2)).thenReturn(originalAccount);
        when(mockAccountDetailServiceImpl.updateAccount(eq(2), eq(testAccount))).thenReturn(expectedAccount);
        Response response = accountsDetailResource.updateAccount(2, testAccount);

        assertEquals(response.getStatus(), updatedStatus);
        assertEquals(response.getEntity(), expectedAccount);
    }

    @Test
    public void updateAccountServerError() throws SQLException, IllegalAccessException, InstantiationException {
        int serverErrorStatus = 500;
        String errorMessage = "You have an error!";
        Account testAccount = new Account("testName", "testUsername", "testPass", false);
        Account originalAccount = new Account(1, "differentTestName", "differentUserName", true, currentTime, 1);

        when(mockAccountDetailServiceImpl.getAccountDetails(eq("testUsername"))).thenThrow(new SQLException("You have an error!"));
        when(mockAccountDetailServiceImpl.getAccountDetails(2)).thenReturn(originalAccount);
        Response response = accountsDetailResource.updateAccount(2, testAccount);

        assertEquals(response.getStatus(), serverErrorStatus);
        assertEquals(response.getEntity(), errorMessage);
    }

    @Test
    public void updateNonExistentAccountError() throws SQLException, IllegalAccessException, InstantiationException {
        int noContentStatus = 204;
        String errorMessage = "Account that you're trying to edit does not exist and therefore can not be updated";
        Account testAccount = new Account("testName", "testUsername", "testPass", false);

        when(mockAccountDetailServiceImpl.getAccountDetails(eq("differentUserName"))).thenReturn(null);
        Response response = accountsDetailResource.updateAccount(5, testAccount);

        assertEquals(response.getStatus(), noContentStatus);
        assertEquals(response.getEntity(), errorMessage);
    }

    @Test
    public void deleteIncorrectlySpeltAccount() {
        int notAcceptableStatus = 406;
        String errorMessage = "Did not delete account because the username was not spelt correctly in CAPITALS";
        Account testAccount = new Account("testName", "rightTestUserName", "testPass", true);

        Response response = accountsDetailResource.deleteAccount("WRONGUSERNAME", 1, testAccount);

        assertEquals(response.getStatus(), notAcceptableStatus);
        assertEquals(response.getEntity(), errorMessage);
    }

    @Test
    public void deleteNoExistingAccountWithUsername() throws IllegalAccessException, SQLException, InstantiationException {
        int noContentStatus = 204;
        String errorMessage = "rightTestUserName does not exist and therefore can not be deleted";
        Account testAccount = new Account(1, "testName", "rightTestUserName", true, currentTime, 2);

        when(mockAccountDetailServiceImpl.getAccountDetails(1)).thenReturn(null);
        Response response = accountsDetailResource.deleteAccount("RIGHTTESTUSERNAME", 1, testAccount);

        assertEquals(response.getStatus(), noContentStatus);
        assertEquals(response.getEntity(), errorMessage);
    }

    @Test
    public void deleteThrowsException() throws IllegalAccessException, SQLException, InstantiationException {
        int serverErrorStatus = 500;
        String errorMessage = "You have an error";
        Account testAccount = new Account(1, "testName", "rightTestUserName", true, currentTime, 2);

        when(mockAccountDetailServiceImpl.getAccountDetails(1)).thenThrow(new SQLException("You have an error"));
        Response response = accountsDetailResource.deleteAccount("RIGHTTESTUSERNAME", 1, testAccount);

        assertEquals(response.getStatus(), serverErrorStatus);
        assertEquals(response.getEntity(), errorMessage);
    }

    //TODO: delete successful account
    /*@Test
    public void deleteAccountSuccessfully() throws IllegalAccessException, SQLException, InstantiationException {
        int okStatus = 200;
        String message = "Account Deleted Successfully";
        Account testAccount = new Account("testName", "rightTestUserName", "testPass", true);

        Response response = accountsDetailResource.removeProtectedName("RIGHTTESTUSERNAME", testAccount);

        assertEquals(response.getStatus(), okStatus);
        assertEquals(response.getEntity(), message);
    }*/
}
