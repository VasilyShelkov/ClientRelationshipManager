package account;

import dataObjects.Account;
import database.generic.GenericAccountSQLService;
import database.generic.GenericSQLService;
import generated.Tables;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyList;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceImplTest {

    @Mock
    GenericAccountSQLService mockAccountSQLService;

    private AccountService accountService;
    private Timestamp currentTime = new Timestamp(DateTime.now().getMillis());
    private Account account = new Account(2, "test", "testUserName", null, true, currentTime, 1);
    private List<Account> accountList;

    @Before
    public void setUp() {
        accountService = new AccountServiceImpl(mockAccountSQLService);
        accountList = new ArrayList();
        accountList.add(account);
    }

    @Test
    public void returnedAccountSuccessfully() throws SQLException, InstantiationException, IllegalAccessException {
        when(mockAccountSQLService.getTable(eq(Tables.ACCOUNTS))).thenReturn(accountList);
        List<Account> actualAccountsList = accountService.getAllAccounts();

        assertEquals(actualAccountsList.get(0), accountList.get(0));
        assertEquals(actualAccountsList.size(), 1);
    }

    @Test(expected = SQLException.class)
    public void getAllAccountsThrowsException() throws SQLException, InstantiationException, IllegalAccessException {
        when(mockAccountSQLService.getTable(eq(Tables.ACCOUNTS))).thenThrow(new SQLException());
        accountService.getAllAccounts();
    }


    @Test
     public void createdAccountSuccessfully() throws SQLException, InstantiationException, IllegalAccessException {
        Account expectedCreatedAccount = new Account("testName", "testUsername", "testPass", true);
        List row = Arrays.asList(expectedCreatedAccount.getName(), expectedCreatedAccount.getUserName(),
                expectedCreatedAccount.getPassword(), expectedCreatedAccount.getAdmin());

        when(mockAccountSQLService.createRecord(eq(Tables.ACCOUNTS), eq(row))).thenReturn(expectedCreatedAccount);
        Account returnedAccount = accountService.createAccount(expectedCreatedAccount);

        assertEquals(returnedAccount.getName(), expectedCreatedAccount.getName());
        assertEquals(returnedAccount.getUserName(), expectedCreatedAccount.getUserName());
        assertEquals(returnedAccount.getPassword(), expectedCreatedAccount.getPassword());
        assertEquals(returnedAccount.getAdmin(), expectedCreatedAccount.getAdmin());
    }

    @Test(expected = SQLException.class)
    public void createdAccountThrowsException() throws SQLException, InstantiationException, IllegalAccessException {
        Account expectedCreatedAccount = new Account("testName", "testUsername", "testPass", true);
        List row = Arrays.asList("testName", "testUsername", "testPass", true);

        when(mockAccountSQLService.createRecord(eq(Tables.ACCOUNTS), eq(row))).thenThrow(new SQLException());
        Account returnedAccount = accountService.createAccount(expectedCreatedAccount);
    }
}