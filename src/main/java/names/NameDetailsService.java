package names;

import dataObjects.Name;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Vasia on 26/01/2015.
 */
public interface NameDetailsService {
    List<Name> searchNames(String firstName, String otherNames, String company, String mobileNumber) throws SQLException, InstantiationException, IllegalAccessException;
    Name getName(int nameId) throws SQLException, InstantiationException, IllegalAccessException;
}
