package database.names;

import dataObjects.UnprotectedName;
import database.ConnectionService;
import database.JOOQSQLService;
import org.jooq.Field;
import org.jooq.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static generated.Tables.NAMES;
import static generated.Tables.UNPROTECTEDNAMES;

/**
 * Created by Vasia on 24/01/2015.
 */
@Service
public class UnprotectedNameDetailsSQLService extends JOOQSQLService {

    static private List<Field<?>> unprotectedNameFields = Arrays.asList(UNPROTECTEDNAMES.COMMENTS, UNPROTECTEDNAMES.ADDEDAT, UNPROTECTEDNAMES.PRIORITY);

    @Autowired
    public UnprotectedNameDetailsSQLService(ConnectionService connectionService) {
        super(connectionService);
    }

    public UnprotectedName getUnprotectedNameDetails(int nameId, int accountId) throws SQLException, IllegalAccessException, InstantiationException {
        Record record = getDSLContext()
                .select(unprotectedNameFields)
                .from(UNPROTECTEDNAMES)
                .naturalJoin(NAMES)
                .where(UNPROTECTEDNAMES.ACCOUNTID.equal(accountId))
                .and(UNPROTECTEDNAMES.NAMEID.equal(nameId))
                .fetchOne();
        if(record == null){
            return null;
        }
        return record.into(UnprotectedName.class);
    }

    public void removeUnprotectedName(int nameId, int accountId) throws SQLException, IllegalAccessException, InstantiationException {
        getDSLContext()
            .delete(UNPROTECTEDNAMES)
            .where(UNPROTECTEDNAMES.NAMEID.equal(nameId))
            .and(UNPROTECTEDNAMES.ACCOUNTID.equal(accountId))
            .execute();
    }
}
