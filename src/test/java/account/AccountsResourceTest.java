package account;

import account.client.ClientAccountsService;
import account.protectedname.ProtectedNameAccountsService;
import account.unprotectedname.UnprotectedNameAccountsService;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by Vasia on 08/11/2014.
 */
@RunWith(MockitoJUnitRunner.class)
public class AccountsResourceTest {

    @Mock
    AccountService mockAccountService;

    @Mock
    AccountDetailService mockAccountDetailService;

    @Mock
    ClientAccountsService mockClientAccountsService;

    @Mock
    UnprotectedNameAccountsService mockUnprotectedNameAccountsService;

    @Mock
    ProtectedNameAccountsService mockProtectedNameAccountsService;

    private AccountsResource accountsResource;
    private Timestamp currentTime = new Timestamp(DateTime.now().getMillis());
    private Account testAccount = new Account(1, "test", "testUserName", null, true, currentTime, 1);
    private List<Account> accountList;
    private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

    @Before
    public void setUp() {
        accountsResource = new AccountsResource(mockAccountService, mockAccountDetailService,
                mockUnprotectedNameAccountsService, mockProtectedNameAccountsService, mockClientAccountsService, factory.getValidator());
        accountList = new ArrayList<>();
        accountList.add(testAccount);

    }

    @Test
    public void getAllAccountsOk() throws SQLException, IllegalAccessException, InstantiationException {
        int okStatus = 200;

        when(mockAccountService.getAllAccounts()).thenReturn(accountList);
        Response response = accountsResource.getAllAccounts();

        assertEquals(response.getStatus(), okStatus);
        assertEquals(((List<Account>) response.getEntity()).get(0), accountList.get(0));
    }

    @Test
     public void getAllAccountsError() throws SQLException, IllegalAccessException, InstantiationException {
        int errorStatus = 500;
        String errorMessage = "You Have An Error";

        when(mockAccountService.getAllAccounts()).thenThrow(new SQLException("You Have An Error"));
        Response response = accountsResource.getAllAccounts();

        assertEquals(response.getStatus(), errorStatus);
        assertEquals(response.getEntity(), errorMessage);
    }

    @Test
    public void getAllAccountsNull() throws SQLException, IllegalAccessException, InstantiationException {
        int okStatus = 200;

        when(mockAccountService.getAllAccounts()).thenReturn(null);
        Response response = accountsResource.getAllAccounts();

        assertEquals(response.getStatus(), okStatus);
        assertEquals(response.getEntity(), null);
    }

    @Test
    public void getAllAccountsSizeZero() throws SQLException, IllegalAccessException, InstantiationException {
        int okStatus = 200;

        when(mockAccountService.getAllAccounts()).thenReturn(new ArrayList<>());
        Response response = accountsResource.getAllAccounts();

        assertEquals(response.getStatus(), okStatus);
        assertEquals(((List<Account>) response.getEntity()).size(), 0);
    }

    @Test
    public void getUnprotectedNameAccountsOk() throws SQLException, IllegalAccessException, InstantiationException {
        int okStatus = 200;

        when(mockUnprotectedNameAccountsService.getUnprotectedNameAccounts(1)).thenReturn(accountList);
        Response response = accountsResource.getUnprotectedNameAccounts(1);

        assertEquals(response.getStatus(), okStatus);
        assertEquals(((List<Account>) response.getEntity()).get(0), accountList.get(0));
    }

    @Test
    public void getUnprotectedNameAccountsError() throws SQLException, IllegalAccessException, InstantiationException {
        int errorStatus = 500;
        String errorMessage = "You Have An Error";

        when(mockUnprotectedNameAccountsService.getUnprotectedNameAccounts(2)).thenThrow(new SQLException("You Have An Error"));
        Response response = accountsResource.getUnprotectedNameAccounts(2);

        assertEquals(response.getStatus(), errorStatus);
        assertEquals(response.getEntity(), errorMessage);
    }

    @Test
    public void getUnprotectedNameAccountsNull() throws SQLException, IllegalAccessException, InstantiationException {
        int okStatus = 200;

        when(mockUnprotectedNameAccountsService.getUnprotectedNameAccounts(3)).thenReturn(null);
        Response response = accountsResource.getUnprotectedNameAccounts(3);

        assertEquals(response.getStatus(), okStatus);
        assertEquals(response.getEntity(), null);
    }

    @Test
    public void getUnprotectedNameAccountsSizeZero() throws SQLException, IllegalAccessException, InstantiationException {
        int okStatus = 200;

        when(mockUnprotectedNameAccountsService.getUnprotectedNameAccounts(4)).thenReturn(new ArrayList<>());
        Response response = accountsResource.getUnprotectedNameAccounts(4);

        assertEquals(response.getStatus(), okStatus);
        assertEquals(((List<Account>) response.getEntity()).size(), 0);
    }

    @Test
    public void getProtectedNameAccountsOk() throws SQLException, IllegalAccessException, InstantiationException {
        int okStatus = 200;

        when(mockProtectedNameAccountsService.getProtectedNameAccounts(1)).thenReturn(accountList);
        Response response = accountsResource.getProtectedNameAccounts(1);

        assertEquals(response.getStatus(), okStatus);
        assertEquals(((List<Account>) response.getEntity()).get(0), accountList.get(0));
    }

    @Test
    public void getProtectedNameAccountsError() throws SQLException, IllegalAccessException, InstantiationException {
        int errorStatus = 500;
        String errorMessage = "You Have An Error";

        when(mockProtectedNameAccountsService.getProtectedNameAccounts(2)).thenThrow(new SQLException("You Have An Error"));
        Response response = accountsResource.getProtectedNameAccounts(2);

        assertEquals(response.getStatus(), errorStatus);
        assertEquals(response.getEntity(), errorMessage);
    }

    @Test
    public void getProtectedNameAccountsNull() throws SQLException, IllegalAccessException, InstantiationException {
        int okStatus = 200;

        when(mockProtectedNameAccountsService.getProtectedNameAccounts(3)).thenReturn(null);
        Response response = accountsResource.getProtectedNameAccounts(3);

        assertEquals(response.getStatus(), okStatus);
        assertEquals(response.getEntity(), null);
    }

    @Test
    public void getProtectedNameAccountsSizeZero() throws SQLException, IllegalAccessException, InstantiationException {
        int okStatus = 200;

        when(mockProtectedNameAccountsService.getProtectedNameAccounts(4)).thenReturn(new ArrayList<>());
        Response response = accountsResource.getProtectedNameAccounts(4);

        assertEquals(response.getStatus(), okStatus);
        assertEquals(((List<Account>) response.getEntity()).size(), 0);
    }

    @Test
    public void getClientAccountsOk() throws SQLException, IllegalAccessException, InstantiationException {
        int okStatus = 200;

        when(mockClientAccountsService.getClientNameAccounts(1)).thenReturn(accountList);
        Response response = accountsResource.getClientAccounts(1);

        assertEquals(response.getStatus(), okStatus);
        assertEquals(((List<Account>) response.getEntity()).get(0), accountList.get(0));
    }

    @Test
    public void getClientAccountsError() throws SQLException, IllegalAccessException, InstantiationException {
        int errorStatus = 500;
        String errorMessage = "You Have An Error";

        when(mockClientAccountsService.getClientNameAccounts(2)).thenThrow(new SQLException("You Have An Error"));
        Response response = accountsResource.getClientAccounts(2);

        assertEquals(response.getStatus(), errorStatus);
        assertEquals(response.getEntity(), errorMessage);
    }

    @Test
    public void getClientAccountsNull() throws SQLException, IllegalAccessException, InstantiationException {
        int okStatus = 200;

        when(mockClientAccountsService.getClientNameAccounts(3)).thenReturn(null);
        Response response = accountsResource.getClientAccounts(3);

        assertEquals(response.getStatus(), okStatus);
        assertEquals(response.getEntity(), null);
    }

    @Test
    public void getClientAccountsSizeZero() throws SQLException, IllegalAccessException, InstantiationException {
        int okStatus = 200;

        when(mockClientAccountsService.getClientNameAccounts(4)).thenReturn(new ArrayList<>());
        Response response = accountsResource.getClientAccounts(4);

        assertEquals(response.getStatus(), okStatus);
        assertEquals(((List<Account>) response.getEntity()).size(), 0);
    }

    @Test
    public void createExistingAccount() throws SQLException, IllegalAccessException, InstantiationException {
        int conflictStatus = 409;
        String errorMessage = "An account with that username already exists";

        when(mockAccountDetailService.getAccountDetails("testUsername")).thenReturn(new Account("existingName", "existingUsername", "testPass", true));
        Response response = accountsResource.createAccount(new Account("testName", "testUsername", "testPass", false));

        assertEquals(response.getStatus(), conflictStatus);
        assertEquals(response.getEntity(), errorMessage);
    }

    @Test
    public void createFaultyAccount() throws SQLException, IllegalAccessException, InstantiationException {
        int badRequestStatus = 400;
        String actual = "Your name may not be empty";

        Response response = accountsResource.createAccount(new Account("", "testUsername", "testPass", true));

        assertEquals(response.getStatus(), badRequestStatus);
        assertEquals(((Set<ConstraintViolation<Account>>) response.getEntity()).size(), 1);
        assertEquals(((Set<ConstraintViolation<Account>>) response.getEntity()).iterator().next().getMessage(), actual);
    }

    @Test
    public void createAccountSuccessfully() throws SQLException, IllegalAccessException, InstantiationException {
        int createdStatus = 201;

        Account testAccount = new Account("testName", "testUsername", "testPass", true);
        when(mockAccountService.createAccount(testAccount)).thenReturn(testAccount);
        Response response = accountsResource.createAccount(testAccount);

        assertEquals(response.getStatus(), createdStatus);
        assertEquals(response.getEntity(), testAccount);
    }

    @Test
    public void createEAccountServerError() throws SQLException, IllegalAccessException, InstantiationException {
        int serverErrorStatus = 500;
        String errorMessage = "You have an error!";

        when(mockAccountDetailService.getAccountDetails("testUsername")).thenThrow(new SQLException("You have an error!"));
        Response response = accountsResource.createAccount(new Account("testName", "testUsername", "testPass", false));

        assertEquals(response.getStatus(), serverErrorStatus);
        assertEquals(response.getEntity(), errorMessage);
    }
}
