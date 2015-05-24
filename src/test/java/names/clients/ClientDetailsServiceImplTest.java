package names.clients;

import dataObjects.Client;
import database.names.ClientDetailsSQLService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ClientDetailsServiceImplTest {

    @Mock
    ClientDetailsSQLService mockClientDetailsSQLService;

    private ClientDetailsServiceImpl ClientDetailService;

    @Before
    public void setUp() throws Exception {
        ClientDetailService = new ClientDetailsServiceImpl(mockClientDetailsSQLService);
    }

    @Test
    public void testGetAccountDetailsById() throws Exception {
        Client testClient = new Client(1, 2);

        when(mockClientDetailsSQLService.getClientDetails(1, 2)).thenReturn(testClient);
        Client actualClient = ClientDetailService.getDetails(1, 2);

        assertEquals(actualClient, testClient);
    }

}