package names.unprotectednames;

import dataObjects.UnprotectedName;

import java.sql.SQLException;

/**
 * Created by Vasia on 24/01/2015.
 */
public interface UnprotectedNameDetailsService {
    UnprotectedName getDetails(int nameId, int accountId) throws SQLException, InstantiationException, IllegalAccessException;
    void removeUnprotectedName(int nameId, int accountId) throws SQLException, IllegalAccessException, InstantiationException;
}
