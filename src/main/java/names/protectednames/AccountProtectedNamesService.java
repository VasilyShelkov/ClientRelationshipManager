package names.protectednames;

import dataObjects.Name;
import dataObjects.ProtectedName;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Vasia on 11/01/2015.
 */
public interface AccountProtectedNamesService {
    List<Name> getProtectedNames(int accountId) throws SQLException, InstantiationException, IllegalAccessException;
    ProtectedName createProtectedName(int accountId, ProtectedName protectedName) throws SQLException, IllegalAccessException, InstantiationException;
}
