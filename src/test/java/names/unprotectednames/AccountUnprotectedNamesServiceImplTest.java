package names.unprotectednames;

import dataObjects.Name;
import database.names.AccountUnprotectedNamesSQLService;
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
public class AccountUnprotectedNamesServiceImplTest {

    @Mock
    AccountUnprotectedNamesSQLService mockAccountUnprotectedNamesSQLService;

    private AccountUnprotectedNamesService accountUnprotectedNamesService;

    @Before
    public void setUp() throws Exception {
        accountUnprotectedNamesService = new AccountUnprotectedNamesServiceImpl(mockAccountUnprotectedNamesSQLService);
    }

    @Test
    public void testGetAccountDetailsByUsername() throws Exception {
        Name testName = new Name(1, "testFirstName", "testOtherNames", "testMobNum", "testCompNum", "testcompany", 2);

        when(mockAccountUnprotectedNamesSQLService.getUnprotectedNames(1)).thenReturn(Arrays.asList(testName));
        List<Name> actualAccountList = accountUnprotectedNamesService.getUnprotectedNames(1);

        assertEquals(actualAccountList.get(0), testName);
    }

}