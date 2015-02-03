package database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Vasia on 09/11/2014.
 */
@Service
public class ConnectionService extends DatabaseService {

    @Autowired
    public ConnectionService(String url, String user, String pass) {
        super(url, user, pass);
    }

    public Connection connectToSQLDb() throws SQLException {
        return  DriverManager.getConnection(getUrl(), getUser(), getPass());
    }
}
