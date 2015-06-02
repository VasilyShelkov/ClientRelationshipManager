package names.protectednames;

import dataObjects.ProtectedName;

import java.sql.SQLException;

/**
 * Created by Vasia on 24/01/2015.
 */
public interface ProtectedNameDetailsService {
    ProtectedName getDetails(int nameId) throws SQLException, InstantiationException, IllegalAccessException;
    void removeUnprotectedName(int nameId) throws SQLException, InstantiationException, IllegalAccessException;
}
