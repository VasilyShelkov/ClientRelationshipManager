package names.unprotectednames;

import dataObjects.Name;
import dataObjects.UnprotectedName;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Vasia on 11/01/2015.
 */
public interface AccountUnprotectedNamesService {
    List<Name> getUnprotectedNames(int accountId) throws SQLException, InstantiationException, IllegalAccessException;
    UnprotectedName createUnprotectedName(UnprotectedName unprotectedName) throws SQLException, InstantiationException, IllegalAccessException;
}
