package database.names;

import dataObjects.Client;
import database.ConnectionService;
import database.JOOQSQLService;
import org.jooq.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static generated.Tables.CLIENTS;
import static generated.Tables.NAMES;

/**
 * Created by Vasia on 24/01/2015.
 */
@Service
public class ClientDetailsSQLService extends JOOQSQLService {

    static private List<Field<?>> clientFields = Arrays.asList(NAMES.FIRSTNAME, NAMES.OTHERNAMES, NAMES.MOBILENUMBER,
            NAMES.OFFICENUMBER, NAMES.COMPANY, NAMES.PICTUREID);

    @Autowired
    public ClientDetailsSQLService(ConnectionService connectionService) {
        super(connectionService);
    }

    public Client getClientDetails(int nameId, int accountId) throws SQLException, IllegalAccessException, InstantiationException {
        return getDSLContext()
                .select(clientFields)
                .from(CLIENTS)
                .naturalJoin(NAMES)
                .where(CLIENTS.ACCOUNTID.equal(accountId))
                .and(CLIENTS.NAMEID.equal(nameId))
                .fetchOne().into(Client.class);
    }

    public void removeClient(int nameId, int accountId) throws SQLException, IllegalAccessException, InstantiationException {
        getDSLContext()
            .delete(CLIENTS)
            .where(CLIENTS.NAMEID.equal(nameId))
            .and(CLIENTS.ACCOUNTID.equal(accountId))
            .execute();
    }
}
