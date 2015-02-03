package names.protectednames;

import dataObjects.ProtectedName;
import database.names.ProtectedNameDetailsSQLService;
import generated.enums.ProtectedNamesPriority;
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
public class ProtectedNameDetailsServiceImplTest {

    @Mock
    ProtectedNameDetailsSQLService mockUnprotectedNameDetailsSQLService;

    private ProtectedNameDetailsServiceImpl UnprotectedNameDetailService;
    private Timestamp currentTime;

    @Before
    public void setUp() throws Exception {
        UnprotectedNameDetailService = new ProtectedNameDetailsServiceImpl(mockUnprotectedNameDetailsSQLService);
        currentTime = new Timestamp(DateTime.now().getMillis());
    }

    @Test
    public void testGetAccountDetailsById() throws Exception {
        ProtectedName testProtectedName = new ProtectedName("testComments", true, false, currentTime, currentTime, currentTime, ProtectedNamesPriority.Medium);

        when(mockUnprotectedNameDetailsSQLService.getProtectedNameDetails(1, 2)).thenReturn(testProtectedName);
        ProtectedName actualProtectedName = UnprotectedNameDetailService.getDetails(1, 2);

        assertEquals(actualProtectedName, testProtectedName);
    }
}