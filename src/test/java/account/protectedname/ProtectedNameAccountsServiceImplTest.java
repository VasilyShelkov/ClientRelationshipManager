package account.protectedname;

import dataObjects.Account;
import database.account.ProtectedNameAccountsSQLService;
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
public class ProtectedNameAccountsServiceImplTest {

    @Mock
    ProtectedNameAccountsSQLService mockProtectedNameAccountSQLService;

    private ProtectedNameAccountsServiceImpl protectedNameAccountsService;
    private Timestamp currentTime;

    @Before
    public void setUp() throws Exception {
        protectedNameAccountsService = new ProtectedNameAccountsServiceImpl(mockProtectedNameAccountSQLService);
        currentTime = new Timestamp(DateTime.now().getMillis());
    }

    @Test
    public void testGetAccountDetailsByUsername() throws Exception {
        Account testAccount = new Account(1, "test", "testUserName", null, true, currentTime, 1);

        when(mockProtectedNameAccountSQLService.getAccounts(1)).thenReturn(Arrays.asList(testAccount));
        List<Account> actualAccountList = protectedNameAccountsService.getProtectedNameAccounts(1);

        assertEquals(actualAccountList.get(0), testAccount);
    }
}