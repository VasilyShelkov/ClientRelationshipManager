package names;

import dataObjects.Name;
import database.generic.GenericNamesSQLService;
import database.names.NamesGeneralSQLService;
import generated.Tables;
import generated.tables.records.NamesRecord;
import org.jooq.TableField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static generated.tables.Names.NAMES;

/**
 * Created by Vasia on 14/12/2014.
 */
@Service
public class NamesServiceImpl implements NamesService {

    private NamesGeneralSQLService namesSQLService;

    @Autowired
    public NamesServiceImpl(NamesGeneralSQLService namesGenericSQLService) {
        this.namesSQLService = namesGenericSQLService;
    }

    public List<Name> getAllNames() throws SQLException, InstantiationException, IllegalAccessException {
        return namesSQLService.getAllNames();
    }

    @Override
    public Name createName(Name name) throws SQLException, InstantiationException, IllegalAccessException {
        List row = new ArrayList();
        row.add(name.getFirstName());
        row.add(name.getOtherNames());
        row.add(name.getMobileNumber());
        row.add(name.getOfficeNumber());
        row.add(name.getCompany());
        return namesSQLService.createRecord(Tables.NAMES, row);
    }
}
