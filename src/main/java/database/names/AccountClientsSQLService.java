package database.names;

import dataObjects.Client;
import dataObjects.Name;
import dataObjects.UnprotectedName;
import database.ConnectionService;
import org.jooq.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static generated.Tables.CLIENTS;
import static generated.Tables.NAMES;
import static generated.Tables.UNPROTECTEDNAMES;

/**
 * Created by Vasia on 11/01/2015.
 */
@Service
public class AccountClientsSQLService extends NamesSQLService {

    private static List<Field<?>> clientGetFields = Arrays.asList(CLIENTS.NAMEID, CLIENTS.ACCOUNTID, CLIENTS.CLIENTAT);
    private static List<Field<?>> clientCreateFields = Arrays.asList(CLIENTS.NAMEID, CLIENTS.ACCOUNTID);

    @Autowired
    public AccountClientsSQLService(ConnectionService connectionService) {
        super(connectionService);
    }

    public List<Name> getClients(int id) throws SQLException, IllegalAccessException, InstantiationException {
        return getDSLContext()
                .select(getNameFields())
                .from(CLIENTS)
                .naturalJoin(NAMES)
                .where(CLIENTS.ACCOUNTID.equal(id))
                .fetchInto(Name.class);
    }

    public Client createRecord(List row) throws SQLException, IllegalAccessException, InstantiationException {
        return getDSLContext()
                .insertInto(CLIENTS, clientCreateFields)
                .values(row)
                .returning(clientGetFields)
                .fetchOne()
                .into(Client.class);
    }
}
