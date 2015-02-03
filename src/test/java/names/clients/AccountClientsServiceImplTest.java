package names.clients;

import dataObjects.Name;
import database.names.AccountClientsSQLService;
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
public class AccountClientsServiceImplTest {

    @Mock
    AccountClientsSQLService mockAccountClientsSQLService;

    private AccountClientsService accountClientService;

    @Before
    public void setUp() throws Exception {
        accountClientService = new AccountClientsServiceImpl(mockAccountClientsSQLService);
    }

    @Test
    public void testGetAccountDetailsByUsername() throws Exception {
        Name testName = new Name(1, "testFirstName", "testOtherNames", "testMobNum", "testCompNum", "testcompany", 2);

        when(mockAccountClientsSQLService.getClients(1)).thenReturn(Arrays.asList(testName));
        List<Name> actualAccountList = accountClientService.getClients(1);

        assertEquals(actualAccountList.get(0), testName);
    }
}