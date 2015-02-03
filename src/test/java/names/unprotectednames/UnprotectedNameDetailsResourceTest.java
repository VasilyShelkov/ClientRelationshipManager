package names.unprotectednames;

import dataObjects.Name;
import dataObjects.UnprotectedName;
import generated.enums.unprotectedNamesPriority;
import names.NameDetailsService;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.sql.Timestamp;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UnprotectedNameDetailsResourceTest {

    @Mock
    UnprotectedNameDetailsService mockUnprotectedNameDetailService;

    @Mock
    NameDetailsService mockNameDetailsService;

    private UnprotectedNameDetailsResource unprotectedNameDetailsResource;
    private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private Timestamp currentTime;
    private Name testName;
    private UnprotectedName testUnprotectedName;

    @Before
    public void setUp() {
        unprotectedNameDetailsResource = new UnprotectedNameDetailsResource(mockUnprotectedNameDetailService, mockNameDetailsService, factory.getValidator());
        currentTime = new Timestamp(DateTime.now().getMillis());
        testName = new Name("testFirstName", "testOtherNames", "testMobNumber", "testOfficeNumber", "testCompany");
        testUnprotectedName = new UnprotectedName("testComments", currentTime, unprotectedNamesPriority.Medium);
    }

    @Test
    public void getClientDetailTest() throws IllegalAccessException, SQLException, InstantiationException {
        int okStatus = 200;

        when(mockUnprotectedNameDetailService.getDetails(1, 2)).thenReturn(testUnprotectedName);
        Response response = unprotectedNameDetailsResource.getUnprotectedNameDetails(1, 2);

        assertEquals(response.getStatus(), okStatus);
        assertEquals(response.getEntity(), testUnprotectedName);
    }

    @Test
    public void getClientDetailErrorTest() throws SQLException, IllegalAccessException, InstantiationException {
        int errorStatus = 500;
        String errorMessage = "You Have An Error";

        when(mockUnprotectedNameDetailService.getDetails(1, 2)).thenThrow(new SQLException("You Have An Error"));
        Response response = unprotectedNameDetailsResource.getUnprotectedNameDetails(1, 2);

        assertEquals(response.getStatus(), errorStatus);
        assertEquals(response.getEntity(), errorMessage);
    }

    //TODO: update for Unprotected Name Details
    /*@Test
    public void updateClientWithExistingClient() throws SQLException, IllegalAccessException, InstantiationException {
        int conflictStatus = 409;
        String errorMessage = "Can not change originalUserName's username to testNewUserName because a different account is already using that username";
        Account testAccount = new Account("test", "testNewUserName", "testPass", true);
        Account originalAccount = new Account(2, "originalTestName", "originalUserName", true, currentTime, 1);

        when(mockClientDetailServiceImpl.getAccountDetails(eq("testUserName"))).thenReturn(originalAccount);
        when(mockClientDetailServiceImpl.getAccountDetails(eq(testAccount.getUserName()))).thenReturn(testAccount);
        Response response = unprotectedNameDetailsResource.updateAccount("testUserName", testAccount);

        assertEquals(response.getStatus(), conflictStatus);
        assertEquals(response.getEntity(), errorMessage);
    }

    @Test
    public void updateFaultyClient() throws SQLException, IllegalAccessException, InstantiationException {
        int badRequestStatus = 400;
        String actual = "Your name may not be empty";
        Account testAccount = new Account("", "testUserName", "testPass", true);
        Account originalAccount = new Account(2, "differentTestName", "differentUserName", true, currentTime, 1);

        when(mockClientDetailServiceImpl.getAccountDetails(eq("differentUserName"))).thenReturn(originalAccount);
        when(mockClientDetailServiceImpl.getAccountDetails(eq(testAccount.getUserName()))).thenReturn(null);
        Response response = unprotectedNameDetailsResource.updateAccount("differentUserName", testAccount);

        assertEquals(response.getStatus(), badRequestStatus);
        assertEquals(((Set<ConstraintViolation<Account>>) response.getEntity()).size(), 1);
        assertEquals(((Set<ConstraintViolation<Account>>) response.getEntity()).iterator().next().getMessage(), actual);
    }

    @Test
    public void updateAccountSuccessfully() throws SQLException, IllegalAccessException, InstantiationException {
        int updatedStatus = 200;
        Account testAccount = new Account("test", "testUserName", "testPass", true);
        Account originalAccount = new Account(2, "differentTestName", "differentUserName", true, currentTime, 1);

        Account expectedAccount = new Account(2, "test", "testUserName", true, currentTime, 1);
        when(mockClientDetailServiceImpl.getAccountDetails(eq("differentUserName"))).thenReturn(originalAccount);
        when(mockClientDetailServiceImpl.getAccountDetails(eq(testAccount.getUserName()))).thenReturn(null);
        when(mockClientDetailServiceImpl.updateAccount(2, testAccount)).thenReturn(expectedAccount);
        Response response = unprotectedNameDetailsResource.updateAccount("differentUserName", testAccount);

        assertEquals(response.getStatus(), updatedStatus);
        assertEquals(response.getEntity(), expectedAccount);
    }

    @Test
    public void updateAccountServerError() throws SQLException, IllegalAccessException, InstantiationException {
        int serverErrorStatus = 500;
        String errorMessage = "You have an error!";
        Account testAccount = new Account("testName", "testUsername", "testPass", false);
        Account originalAccount = new Account(2, "differentTestName", "differentUserName", true, currentTime, 1);

        when(mockClientDetailServiceImpl.getAccountDetails(eq("differentUserName"))).thenReturn(originalAccount);
        when(mockClientDetailServiceImpl.getAccountDetails(eq(testAccount.getUserName()))).thenReturn(null);
        when(mockClientDetailServiceImpl.updateAccount(2, testAccount)).thenThrow(new SQLException("You have an error!"));
        Response response = unprotectedNameDetailsResource.updateAccount("differentUserName", testAccount);

        assertEquals(response.getStatus(), serverErrorStatus);
        assertEquals(response.getEntity(), errorMessage);
    }

    @Test
    public void updateNonExistentAccountError() throws SQLException, IllegalAccessException, InstantiationException {
        int noContentStatus = 204;
        String errorMessage = "Account that you're trying to edit does not exist and therefore can not be updated";
        Account testAccount = new Account("testName", "testUsername", "testPass", false);

        when(mockClientDetailServiceImpl.getAccountDetails(eq("differentUserName"))).thenReturn(null);
        Response response = unprotectedNameDetailsResource.updateAccount("differentUserName", testAccount);

        assertEquals(response.getStatus(), noContentStatus);
        assertEquals(response.getEntity(), errorMessage);
    }*/

    @Test
    public void deleteIncorrectlySpeltAccount() throws IllegalAccessException, SQLException, InstantiationException {
        int notAcceptableStatus = 406;
        String errorMessage = "Did not delete unprotected name because the first name was not spelt correctly in CAPITALS";

        when(mockNameDetailsService.getName(1)).thenReturn(testName);
        Response response = unprotectedNameDetailsResource.removeUnprotectedName(1, 2, "WRONGFIRSTNAME");

        assertEquals(response.getStatus(), notAcceptableStatus);
        assertEquals(response.getEntity(), errorMessage);
    }

    @Test
    public void deleteNoExistingClientWithId() throws IllegalAccessException, SQLException, InstantiationException {
        int noContentStatus = 400;
        String errorMessage = "testFirstName testOtherNames does not exist and therefore can not be deleted";

        when(mockNameDetailsService.getName(1)).thenReturn(testName);
        when(mockUnprotectedNameDetailService.getDetails(1, 2)).thenReturn(null);
        Response response = unprotectedNameDetailsResource.removeUnprotectedName(1, 2, "TESTFIRSTNAME");

        assertEquals(response.getStatus(), noContentStatus);
        assertEquals(response.getEntity(), errorMessage);
    }

    @Test
    public void deleteThrowsException() throws IllegalAccessException, SQLException, InstantiationException {
        int serverErrorStatus = 500;
        String errorMessage = "You have an error";

        when(mockNameDetailsService.getName(1)).thenReturn(testName);
        when(mockUnprotectedNameDetailService.getDetails(1, 2)).thenThrow(new SQLException("You have an error"));
        Response response = unprotectedNameDetailsResource.removeUnprotectedName(1, 2, "TESTFIRSTNAME");

        assertEquals(response.getStatus(), serverErrorStatus);
        assertEquals(response.getEntity(), errorMessage);
    }
}