package names.unprotectednames;

import dataObjects.Account;
import dataObjects.UnprotectedName;
import database.names.UnprotectedNameDetailsSQLService;
import generated.enums.unprotectedNamesPriority;
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
public class UnprotectedNameDetailsServiceImplTest {

    @Mock
    UnprotectedNameDetailsSQLService mockUnprotectedNameDetailsSQLService;

    private UnprotectedNameDetailsServiceImpl UnprotectedNameDetailService;
    private Timestamp currentTime;

    @Before
    public void setUp() throws Exception {
        UnprotectedNameDetailService = new UnprotectedNameDetailsServiceImpl(mockUnprotectedNameDetailsSQLService);
        currentTime = new Timestamp(DateTime.now().getMillis());
    }

    @Test
    public void testGetAccountDetailsById() throws Exception {
        UnprotectedName testUnprotectedName = new UnprotectedName("testComments", currentTime, unprotectedNamesPriority.Medium);

        when(mockUnprotectedNameDetailsSQLService.getUnprotectedNameDetails(1, 2)).thenReturn(testUnprotectedName);
        UnprotectedName actualUnprotectedName = UnprotectedNameDetailService.getDetails(1, 2);

        assertEquals(actualUnprotectedName, testUnprotectedName);
    }
}