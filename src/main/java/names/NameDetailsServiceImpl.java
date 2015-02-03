package names;

import dataObjects.Name;
import database.names.NameDetailsSQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Vasia on 26/01/2015.
 */
@Service
public class NameDetailsServiceImpl implements NameDetailsService{

    private NameDetailsSQLService nameDetailsSQLService;

    @Autowired
    public NameDetailsServiceImpl(NameDetailsSQLService nameDetailsSQLService) {
        this.nameDetailsSQLService = nameDetailsSQLService;
    }

    @Override
    public List<Name> searchNames(String firstName, String otherNames, String company, String mobileNumber) throws SQLException, InstantiationException, IllegalAccessException {
        return nameDetailsSQLService.searchNames(firstName, otherNames, company, mobileNumber);
    }

    public Name getName(int nameId) throws SQLException, InstantiationException, IllegalAccessException{
        return nameDetailsSQLService.getName(nameId);
    }
}
