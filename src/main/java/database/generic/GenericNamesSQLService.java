package database.generic;

import dataObjects.Name;
import database.ConnectionService;
import generated.tables.records.NamesRecord;
import org.jooq.TableField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

import static generated.tables.Names.NAMES;

/**
 * Created by Vasia on 21/01/2015.
 */
@Service
public class GenericNamesSQLService extends GenericSQLService<Name, NamesRecord> {

    private static List<TableField<NamesRecord,?>> nameGetFields = Arrays.asList(NAMES.NAMEID, NAMES.FIRSTNAME, NAMES.OTHERNAMES, NAMES.MOBILENUMBER, NAMES.OFFICENUMBER, NAMES.COMPANY, NAMES.PICTUREID);
    private static List<TableField<NamesRecord,?>> nameCreateFields = Arrays.asList(NAMES.FIRSTNAME, NAMES.OTHERNAMES, NAMES.MOBILENUMBER, NAMES.OFFICENUMBER, NAMES.COMPANY);

    @Autowired
    public GenericNamesSQLService(Class<Name> nameClazz, ConnectionService connectionService) {
        super(nameClazz, nameGetFields, nameCreateFields, connectionService);
    }
}
