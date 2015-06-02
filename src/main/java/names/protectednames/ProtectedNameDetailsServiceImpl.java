package names.protectednames;

import dataObjects.ProtectedName;
import database.names.ProtectedNameDetailsSQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * Created by Vasia on 24/01/2015.
 */
@Service
public class ProtectedNameDetailsServiceImpl implements ProtectedNameDetailsService {

    private ProtectedNameDetailsSQLService protectedNameDetailsSQLService;

    @Autowired
    public ProtectedNameDetailsServiceImpl(ProtectedNameDetailsSQLService protectedNameDetailsSQLService) {
        this.protectedNameDetailsSQLService = protectedNameDetailsSQLService;
    }

    @Override
    public ProtectedName getDetails(int nameId) throws SQLException, InstantiationException, IllegalAccessException {
        return protectedNameDetailsSQLService.getProtectedNameDetails(nameId);
    }

    @Override
    public void removeUnprotectedName(int nameId) throws SQLException, InstantiationException, IllegalAccessException{
        protectedNameDetailsSQLService.removeProtectedName(nameId);
    }
}
