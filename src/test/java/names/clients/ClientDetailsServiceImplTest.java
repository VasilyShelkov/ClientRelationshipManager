package names.clients;

import dataObjects.Client;
import database.names.ClientDetailsSQLService;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Timestamp;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ClientDetailsServiceImplTest {

    @Mock
    ClientDetailsSQLService mockClientDetailsSQLService;

    private ClientDetailsServiceImpl ClientDetailService;
    private Timestamp currentTime;

    @Before
    public void setUp() throws Exception {
        ClientDetailService = new ClientDetailsServiceImpl(mockClientDetailsSQLService);
        currentTime = new Timestamp(DateTime.now().getMillis());
    }

    @Test
    public void testGetAccountDetailsById() throws Exception {
        Client testClient = new Client(1, 2, currentTime);

        when(mockClientDetailsSQLService.getClientDetails(1, 2)).thenReturn(testClient);
        Client actualClient = ClientDetailService.getDetails(1, 2);

        assertEquals(actualClient, testClient);
    }

}