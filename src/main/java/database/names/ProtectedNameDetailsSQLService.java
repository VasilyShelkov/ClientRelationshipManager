package database.names;

import dataObjects.ProtectedName;
import database.ConnectionService;
import database.JOOQSQLService;
import org.jooq.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static generated.Tables.NAMES;
import static generated.Tables.PROTECTEDNAMES;

/**
 * Created by Vasia on 24/01/2015.
 */
@Service
public class ProtectedNameDetailsSQLService extends JOOQSQLService {

    static private List<Field<?>> protectedNameFields = Arrays.asList(NAMES.FIRSTNAME, NAMES.OTHERNAMES, NAMES.MOBILENUMBER,
            NAMES.OFFICENUMBER, NAMES.COMPANY, NAMES.PICTUREID);

    @Autowired
    public ProtectedNameDetailsSQLService(ConnectionService connectionService) {
        super(connectionService);
    }

    public ProtectedName getProtectedNameDetails(int nameId, int accountId) throws SQLException, IllegalAccessException, InstantiationException {
        return getDSLContext()
                .select(protectedNameFields)
                .from(PROTECTEDNAMES)
                .naturalJoin(NAMES)
                .where(PROTECTEDNAMES.ACCOUNTID.equal(accountId))
                .and(PROTECTEDNAMES.NAMEID.equal(nameId))
                .fetchOne().into(ProtectedName.class);
    }

    public void removeProtectedName(int nameId, int accountId) throws SQLException, InstantiationException, IllegalAccessException{
        getDSLContext()
            .delete(PROTECTEDNAMES)
            .where(PROTECTEDNAMES.NAMEID.equal(nameId))
            .and(PROTECTEDNAMES.ACCOUNTID.equal(accountId))
            .execute();
    }
}
