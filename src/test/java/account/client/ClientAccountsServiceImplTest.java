package account.client;

import dataObjects.Account;
import database.account.ClientAccountsSQLService;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ClientAccountsServiceImplTest {

    @Mock
    ClientAccountsSQLService mockClientAccountSQLService;

    private ClientAccountsServiceImpl clientAccountsService;
    private Timestamp currentTime;

    @Before
    public void setUp() throws Exception {
        clientAccountsService = new ClientAccountsServiceImpl(mockClientAccountSQLService);
        currentTime = new Timestamp(DateTime.now().getMillis());
    }

    @Test
    public void testGetAccountDetailsByUsername() throws Exception {
        Account testAccount = new Account(1, "test", "testUserName", null, true, currentTime, 1);

        when(mockClientAccountSQLService.getAccounts(1)).thenReturn(Arrays.asList(testAccount));
        List<Account> actualAccountList = clientAccountsService.getClientNameAccounts(1);

        assertEquals(actualAccountList.get(0), testAccount);
    }

}