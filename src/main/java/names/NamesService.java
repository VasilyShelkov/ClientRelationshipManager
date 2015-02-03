package names;

import dataObjects.Name;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Vasia on 14/12/2014.
 */
public interface NamesService {
    List<Name> getAllNames() throws SQLException, InstantiationException, IllegalAccessException;
    Name createName(Name name) throws SQLException, InstantiationException, IllegalAccessException;
}
