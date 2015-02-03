package names;

import account.client.ClientAccountsService;
import account.protectedname.ProtectedNameAccountsService;
import dataObjects.Name;
import names.clients.AccountClientsService;
import names.clients.ClientDetailsService;
import names.protectednames.AccountProtectedNamesService;
import names.protectednames.ProtectedNameDetailsService;
import names.unprotectednames.AccountUnprotectedNamesService;
import names.unprotectednames.UnprotectedNameDetailsService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.validation.Validation;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class NamesResourceTest {

    @Mock
    NamesService mockNamesService;

    @Mock
    NameDetailsService mockNameDetailsService;

    @Mock
    AccountUnprotectedNamesService mockUnprotectedNamesService;

    @Mock
    UnprotectedNameDetailsService mockUnprotectedNameDetailsService;

    @Mock
    AccountProtectedNamesService mockProtectedNamesService;

    @Mock
    ProtectedNameDetailsService mockProtectedNameDetailsService;

    @Mock
    AccountClientsService mockClientsService;

    @Mock
    ClientDetailsService mockClientDetailsService;

    @Mock
    ProtectedNameAccountsService mockProtectedNameAccountsService;

    @Mock
    ClientAccountsService mockClientAccountsService;

    private NamesResource namesResource;

    @Before
    public void setUp() throws Exception {
        namesResource = new NamesResource(mockNamesService, mockNameDetailsService, mockUnprotectedNamesService,
                mockUnprotectedNameDetailsService, mockProtectedNamesService, mockClientsService, mockProtectedNameAccountsService,
                mockProtectedNameDetailsService, mockClientAccountsService, mockClientDetailsService, Validation.buildDefaultValidatorFactory().getValidator());
    }

    @Test
    public void getAllNamesOk() throws SQLException, IllegalAccessException, InstantiationException{
        int okStatus = 200;
        Name testName = new Name("testFirst", "testOther", "12345", "678910", "testCompany");
        List<Name> testList = new ArrayList<>();
        testList.add(testName);

        when(mockNamesService.getAllNames()).thenReturn(testList);
        Response response = namesResource.getAllNames();

        assertEquals(response.getStatus(), okStatus);
        assertEquals(((List<Name>) response.getEntity()).get(0), testName);
    }

    @Test
    public void getAllNamesNull() throws SQLException, IllegalAccessException, InstantiationException{
        int okStatus = 200;

        when(mockNamesService.getAllNames()).thenReturn(null);
        Response response = namesResource.getAllNames();

        assertEquals(response.getStatus(), okStatus);
        assertEquals(response.getEntity(), null);
    }

    @Test
    public void getAllNamesSizeZero() throws SQLException, IllegalAccessException, InstantiationException{
        int okStatus = 200;

        when(mockNamesService.getAllNames()).thenReturn(new ArrayList<>());
        Response response = namesResource.getAllNames();

        assertEquals(response.getStatus(), okStatus);
        assertEquals(((List<Name>) response.getEntity()).size(), 0);
    }

    @Test
    public void getAllNamesError() throws SQLException, IllegalAccessException, InstantiationException{
        int errorStatus = 500;
        String errorMessage = "You Have An Error";

        when(mockNamesService.getAllNames()).thenThrow(new SQLException("You Have An Error"));
        Response response = namesResource.getAllNames();

        assertEquals(response.getStatus(), errorStatus);
        assertEquals(response.getEntity(), errorMessage);
    }

    @Test
    public void getAllUnprotectedNamesOK() throws SQLException, IllegalAccessException, InstantiationException{
        int okStatus = 200;
        Name testUnprotectedName = new Name("testFirst", "testOther", "12345", "678910", "testCompany");
        List<Name> testList = new ArrayList<>();
        testList.add(testUnprotectedName);

        when(mockUnprotectedNamesService.getUnprotectedNames(1)).thenReturn(testList);
        Response response = namesResource.getAllAccountUnprotectedNames(1);

        assertEquals(response.getStatus(), okStatus);
        assertEquals(((List<Name>) response.getEntity()).get(0), testUnprotectedName);
    }

    @Test
    public void getAllUnprotectedNamesNull() throws SQLException, IllegalAccessException, InstantiationException{
        int okStatus = 200;

        when(mockUnprotectedNamesService.getUnprotectedNames(2)).thenReturn(null);
        Response response = namesResource.getAllAccountUnprotectedNames(2);

        assertEquals(response.getStatus(), okStatus);
        assertEquals(response.getEntity(), null);
    }

    @Test
    public void getAllUnprotectedNamesSizeZero() throws SQLException, IllegalAccessException, InstantiationException{
        int okStatus = 200;

        when(mockUnprotectedNamesService.getUnprotectedNames(3)).thenReturn(new ArrayList<>());
        Response response = namesResource.getAllAccountUnprotectedNames(3);

        assertEquals(response.getStatus(), okStatus);
        assertEquals(((List<Name>) response.getEntity()).size(), 0);
    }

    @Test
    public void getAllUnprotectedNamesError() throws SQLException, IllegalAccessException, InstantiationException{
        int errorStatus = 500;
        String errorMessage = "You Have An Error";

        when(mockUnprotectedNamesService.getUnprotectedNames(4)).thenThrow(new SQLException("You Have An Error"));
        Response response = namesResource.getAllAccountUnprotectedNames(4);

        assertEquals(response.getStatus(), errorStatus);
        assertEquals(response.getEntity(), errorMessage);
    }

    @Test
    public void getAllProtectedNamesOK() throws SQLException, IllegalAccessException, InstantiationException{
        int okStatus = 200;
        Name testProtectedName = new Name("testFirst", "testOther", "12345", "678910", "testCompany");
        List<Name> testList = new ArrayList<>();
        testList.add(testProtectedName);

        when(mockProtectedNamesService.getProtectedNames(1)).thenReturn(testList);
        Response response = namesResource.getAllAccountProtectedNames(1);

        assertEquals(response.getStatus(), okStatus);
        assertEquals(((List<Name>) response.getEntity()).get(0), testProtectedName);
    }

    @Test
    public void getAllProtectedNamesNoNull() throws SQLException, IllegalAccessException, InstantiationException{
        int okStatus = 200;

        when(mockProtectedNamesService.getProtectedNames(2)).thenReturn(null);
        Response response = namesResource.getAllAccountProtectedNames(2);

        assertEquals(response.getStatus(), okStatus);
        assertEquals(response.getEntity(), null);
    }

    @Test
    public void getAllProtectedNamesSizeZero() throws SQLException, IllegalAccessException, InstantiationException{
        int okStatus = 200;

        when(mockProtectedNamesService.getProtectedNames(3)).thenReturn(new ArrayList<>());
        Response response = namesResource.getAllAccountProtectedNames(3);

        assertEquals(response.getStatus(), okStatus);
        assertEquals(((List<Name>) response.getEntity()).size(), 0);
    }

    @Test
    public void getAllProtectedNamesError() throws SQLException, IllegalAccessException, InstantiationException{
        int errorStatus = 500;
        String errorMessage = "You Have An Error";

        when(mockProtectedNamesService.getProtectedNames(4)).thenThrow(new SQLException("You Have An Error"));
        Response response = namesResource.getAllAccountProtectedNames(4);

        assertEquals(response.getStatus(), errorStatus);
        assertEquals(response.getEntity(), errorMessage);
    }

    @Test
    public void getAllClientNamesOK() throws SQLException, IllegalAccessException, InstantiationException{
        int okStatus = 200;
        Name testClientName = new Name("testFirst", "testOther", "12345", "678910", "testCompany");
        List<Name> testList = new ArrayList<>();
        testList.add(testClientName);

        when(mockClientsService.getClients(1)).thenReturn(testList);
        Response response = namesResource.getAllAccountClients(1);

        assertEquals(response.getStatus(), okStatus);
        assertEquals(((List<Name>) response.getEntity()).get(0), testClientName);
    }

    @Test
     public void getAllClientNamesNull() throws SQLException, IllegalAccessException, InstantiationException{
        int okStatus = 200;

        when(mockClientsService.getClients(2)).thenReturn(null);
        Response response = namesResource.getAllAccountClients(2);

        assertEquals(response.getStatus(), okStatus);
        assertEquals(response.getEntity(), null);
    }

    @Test
    public void getAllClientNamesSizeZero() throws SQLException, IllegalAccessException, InstantiationException{
        int okStatus = 200;

        when(mockClientsService.getClients(3)).thenReturn(new ArrayList<>());
        Response response = namesResource.getAllAccountClients(3);

        assertEquals(response.getStatus(), okStatus);
        assertEquals(((List<Name>) response.getEntity()).size(), 0);
    }

    @Test
    public void getAllClientNamesError() throws SQLException, IllegalAccessException, InstantiationException{
        int errorStatus = 500;
        String errorMessage = "You Have An Error";

        when(mockClientsService.getClients(4)).thenThrow(new SQLException("You Have An Error"));
        Response response = namesResource.getAllAccountClients(4);

        assertEquals(response.getStatus(), errorStatus);
        assertEquals(response.getEntity(), errorMessage);
    }
}