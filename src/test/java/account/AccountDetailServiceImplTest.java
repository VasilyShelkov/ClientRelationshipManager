package account;

import dataObjects.Account;
import database.account.AccountDetailsSQLService;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Timestamp;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AccountDetailServiceImplTest {

    @Mock
    AccountDetailsSQLService mockAccountDetailSQLService;

    private AccountDetailServiceImpl accountsDetailService;
    private Timestamp currentTime;

    @Before
    public void setUp() throws Exception {
        accountsDetailService = new AccountDetailServiceImpl(mockAccountDetailSQLService);
        currentTime = new Timestamp(DateTime.now().getMillis());
    }

    @Test
    public void testGetAccountDetailsByUsername() throws Exception {
        Account testAccount = new Account(1, "test", "testUserName", null, true, currentTime, 1);

        when(mockAccountDetailSQLService.getAccountDetail(eq("testUsername"))).thenReturn(testAccount);
        Account actualAccount = accountsDetailService.getAccountDetails("testUsername");

        assertEquals(actualAccount, testAccount);
    }

    @Test
    public void testGetAccountDetailsById() throws Exception {
        Account testAccount = new Account(1, "test", "testUserName", null, true, currentTime, 1);

        when(mockAccountDetailSQLService.getAccountDetail(1)).thenReturn(testAccount);
        Account actualAccount = accountsDetailService.getAccountDetails(1);

        assertEquals(actualAccount, testAccount);
    }

    @Test
    public void updateAccountDetails() throws Exception {
        Account testAccount = new Account("test", "testUserName", "testPass", true);
        Account expectedAccount = new Account(2,"expectedtestName", null, "expectedTestUsername", true, currentTime, 1);

        when(mockAccountDetailSQLService.updateAccount(eq(1), eq(testAccount))).thenReturn(expectedAccount);
        Account actualAccount = accountsDetailService.updateAccount(1, testAccount);

        assertEquals(actualAccount, expectedAccount);
    }
}