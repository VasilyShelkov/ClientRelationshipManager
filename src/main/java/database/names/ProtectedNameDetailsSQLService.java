package database.names;

import dataObjects.ProtectedName;
import database.ConnectionService;
import database.JOOQSQLService;
import org.jooq.Field;
import org.jooq.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static generated.Tables.PROTECTEDNAMES;

/**
 * Created by Vasia on 24/01/2015.
 */
@Service
public class ProtectedNameDetailsSQLService extends JOOQSQLService {

    static private List<Field<?>> protectedNameFields = Arrays.asList(PROTECTEDNAMES.COMMENTS, PROTECTEDNAMES.CALLED,
            PROTECTEDNAMES.BOOKED, PROTECTEDNAMES.CALLBACK, PROTECTEDNAMES.DATEBOOKED, PROTECTEDNAMES.PROTECTEDAT,
            PROTECTEDNAMES.PRIORITY);

    @Autowired
    public ProtectedNameDetailsSQLService(ConnectionService connectionService) {
        super(connectionService);
    }

    public ProtectedName getProtectedNameDetails(int nameId) throws SQLException, IllegalAccessException, InstantiationException {
        Record record = getDSLContext()
                .select(protectedNameFields)
                .from(PROTECTEDNAMES)
                .where(PROTECTEDNAMES.NAMEID.equal(nameId))
                .fetchOne();
        if (record == null){
            return null;
        }
        return record.into(ProtectedName.class);
    }

    public void removeProtectedName(int nameId) throws SQLException, InstantiationException, IllegalAccessException{
        getDSLContext()
            .delete(PROTECTEDNAMES)
            .where(PROTECTEDNAMES.NAMEID.equal(nameId))
            .execute();
    }
}
