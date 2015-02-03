package database.names;

import dataObjects.Name;
import database.ConnectionService;
import org.jooq.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static generated.Tables.NAMES;
import static generated.Tables.UNPROTECTEDNAMES;

/**
 * Created by Vasia on 11/01/2015.
 */
@Service
public class AccountUnprotectedNamesSQLService extends NamesSQLService {

    private static List<Field<?>> unprotectedNameCreateFields = Arrays.asList(UNPROTECTEDNAMES.NAMEID, UNPROTECTEDNAMES.ACCOUNTID,
            UNPROTECTEDNAMES.COMMENTS, UNPROTECTEDNAMES.PRIORITY);

    @Autowired
    public AccountUnprotectedNamesSQLService(ConnectionService connectionService) {
        super(connectionService);
    }

    public List<Name> getUnprotectedNames(int id) throws SQLException, IllegalAccessException, InstantiationException {
        return getDSLContext()
                .select(getNameFields())
                .from(UNPROTECTEDNAMES)
                .naturalJoin(NAMES)
                .where(UNPROTECTEDNAMES.ACCOUNTID.equal(id))
                .fetchInto(Name.class);
    }

    public void createRecord(List record) throws SQLException, IllegalAccessException, InstantiationException{
            getDSLContext()
            .insertInto(UNPROTECTEDNAMES, unprotectedNameCreateFields)
            .values(record)
            .execute();
    }
}