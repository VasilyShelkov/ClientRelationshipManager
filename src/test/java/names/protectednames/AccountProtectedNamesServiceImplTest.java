package names.protectednames;

import dataObjects.Name;
import database.names.AccountProtectedNamesSQLService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AccountProtectedNamesServiceImplTest {

    @Mock
    AccountProtectedNamesSQLService mockAccountProtectedNamesSQLService;

    private AccountProtectedNamesService accountProtectedNamesService;

    @Before
    public void setUp() throws Exception {
        accountProtectedNamesService = new AccountProtectedNamesServiceImpl(mockAccountProtectedNamesSQLService);
    }

    @Test
    public void testGetAccountDetailsByUsername() throws Exception {
        Name testName = new Name(1, "testFirstName", "testOtherNames", "testMobNum", "testCompNum", "testcompany", 2);

        when(mockAccountProtectedNamesSQLService.getProtectedNames(1)).thenReturn(Arrays.asList(testName));
        List<Name> actualAccountList = accountProtectedNamesService.getProtectedNames(1);

        assertEquals(actualAccountList.get(0), testName);
    }
}