package database.names;

import dataObjects.Name;
import dataObjects.ProtectedName;
import database.ConnectionService;
import org.jooq.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static generated.Tables.NAMES;
import static generated.Tables.PROTECTEDNAMES;

/**
 * Created by Vasia on 11/01/2015.
 */
@Service
public class AccountProtectedNamesSQLService extends NamesSQLService {

    private static List<Field<?>> protectedNameCreateFields = Arrays.asList(PROTECTEDNAMES.NAMEID, PROTECTEDNAMES.ACCOUNTID, PROTECTEDNAMES.COMMENTS,
            PROTECTEDNAMES.CALLED, PROTECTEDNAMES.BOOKED, PROTECTEDNAMES.CALLBACK, PROTECTEDNAMES.DATEBOOKED, PROTECTEDNAMES.PRIORITY);

    @Autowired
    public AccountProtectedNamesSQLService(ConnectionService connectionService) {
        super(connectionService);
    }

    public List<Name> getProtectedNames(int accountId) throws SQLException, IllegalAccessException, InstantiationException {
        return getDSLContext()
                .select(getNameFields())
                .from(PROTECTEDNAMES)
                .naturalJoin(NAMES)
                .where(PROTECTEDNAMES.ACCOUNTID.equal(accountId))
                .fetchInto(Name.class);
    }

    public void createRecord(List row) throws SQLException, IllegalAccessException, InstantiationException {
        getDSLContext()
            .insertInto(PROTECTEDNAMES, protectedNameCreateFields)
            .values(row)
            .execute();
    }
}
