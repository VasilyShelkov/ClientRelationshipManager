package database.names;

import database.ConnectionService;
import database.JOOQSQLService;
import generated.tables.records.NamesRecord;
import org.jooq.TableField;

import java.util.Arrays;
import java.util.List;

import static generated.Tables.NAMES;

/**
 * Created by Vasia on 24/01/2015.
 */
abstract public class NamesSQLService extends JOOQSQLService {

    static private List<TableField<NamesRecord, ?>> nameFields = Arrays.asList(NAMES.NAMEID, NAMES.FIRSTNAME, NAMES.OTHERNAMES, NAMES.MOBILENUMBER, NAMES.COMPANYID, NAMES.PICTUREID);

    public NamesSQLService(ConnectionService connectionService) {
        super(connectionService);
    }

    protected static List<TableField<NamesRecord, ?>> getNameFields() {
        return nameFields;
    }
}
