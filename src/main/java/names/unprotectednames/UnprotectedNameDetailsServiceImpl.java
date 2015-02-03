package names.unprotectednames;

import dataObjects.UnprotectedName;
import database.names.UnprotectedNameDetailsSQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * Created by Vasia on 24/01/2015.
 */
@Service
public class UnprotectedNameDetailsServiceImpl implements UnprotectedNameDetailsService {

    private UnprotectedNameDetailsSQLService unprotectedNameDetailsSQLService;

    @Autowired
    public UnprotectedNameDetailsServiceImpl(UnprotectedNameDetailsSQLService unprotectedNameDetailsSQLService) {
        this.unprotectedNameDetailsSQLService = unprotectedNameDetailsSQLService;
    }

    @Override
    public UnprotectedName getDetails(int nameId, int accountId) throws SQLException, InstantiationException, IllegalAccessException {
        return unprotectedNameDetailsSQLService.getUnprotectedNameDetails(nameId, accountId);
    }

    @Override
    public void removeUnprotectedName(int nameId, int accountId) throws SQLException, IllegalAccessException, InstantiationException {
        unprotectedNameDetailsSQLService.removeUnprotectedName(nameId, accountId);
    }
}
