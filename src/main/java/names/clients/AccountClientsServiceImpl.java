package names.clients;

import dataObjects.Client;
import dataObjects.Name;
import database.names.AccountClientsSQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Vasia on 11/01/2015.
 */
@Service
public class AccountClientsServiceImpl implements AccountClientsService {

    private AccountClientsSQLService accountAccountClientsSQLService;

    @Autowired
    public AccountClientsServiceImpl(AccountClientsSQLService accountAccountClientsSQLService) {
        this.accountAccountClientsSQLService = accountAccountClientsSQLService;
    }

    @Override
    public List<Name> getClients(int accountId) throws SQLException, InstantiationException, IllegalAccessException {
        return accountAccountClientsSQLService.getClients(accountId);
    }

    @Override
    public Client createClient(Client client) throws SQLException, InstantiationException, IllegalAccessException {
        List row = new ArrayList();
        row.add(client.getNameId());
        row.add(client.getAccountId());
        accountAccountClientsSQLService.createRecord(row);
        client.setClientAt(new Timestamp(new Date().getTime()));
        return client;
    }
}
