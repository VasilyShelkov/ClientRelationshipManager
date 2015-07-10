package database.names;

import dataObjects.Name;
import database.ConnectionService;
import database.JOOQSQLService;
import generated.Tables;
import org.jooq.Result;

import java.sql.SQLException;
import java.util.List;

import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

/**
 * Created by Vasia on 6/24/2015.
 */
public class NamesGeneralSQLService extends JOOQSQLService {

    public NamesGeneralSQLService(ConnectionService connectionService) {
        super(connectionService);
    }


    public List<Name> getAllNames() throws SQLException {
        Result<?> result = getDSLContext().select()
                .from(Tables.NAMES)
                .join(Tables.COMPANY)
                .using(Tables.NAMES.COMPANYID)
                .fetch();

        result
                .stream()
                .ma
                .collect(mapping(
                        r -> new Name(r.getValue(Tables.NAMES.NAMEID),

                        ),
                        toList()
                ));
        return null;
    }
}
