package names;

import dataObjects.Name;
import database.generic.GenericNamesSQLService;
import generated.Tables;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class NamesServiceImplTest {

    @Mock
    GenericNamesSQLService mockNamesSQLService;

    private NamesService namesService;
    private Name ExpectedName = new Name(1, "testFirstName", "testOtherNames", "testMobNum", "testCompNum", "testcompany", 2);

    @Before
    public void setUp() throws Exception {
        namesService = new NamesServiceImpl(mockNamesSQLService);
    }

    @Test
    public void returnedAccountSuccessfully() throws SQLException, InstantiationException, IllegalAccessException {
        when(mockNamesSQLService.getTable(eq(Tables.NAMES))).thenReturn(Arrays.asList(ExpectedName));
        List<Name> actualNamesList = namesService.getAllNames();

        assertEquals(actualNamesList.get(0), ExpectedName);
        assertEquals(actualNamesList.size(), 1);
    }

    @Test(expected = SQLException.class)
    public void getAllAccountsThrowsException() throws SQLException, InstantiationException, IllegalAccessException {
        when(mockNamesSQLService.getTable(eq(Tables.NAMES))).thenThrow(new SQLException());
        namesService.getAllNames();
    }
}