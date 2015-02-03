package database;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Vasia on 11/01/2015.
 */
public abstract class JOOQSQLService {

    private final ConnectionService connectionService;

    public JOOQSQLService(ConnectionService connectionService) {
        this.connectionService = connectionService;
    }

    protected DSLContext getDSLContext() throws SQLException {
        Connection conn = connectionService.connectToSQLDb();
        return DSL.using(conn, SQLDialect.MYSQL);
    }
}
