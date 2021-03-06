package database.account;

import dataObjects.Account;
import database.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

import static generated.tables.Accounts.ACCOUNTS;
import static generated.tables.Clients.CLIENTS;

/**
 * Created by Vasia on 11/01/2015.
 */
@Service
public class ClientAccountsSQLService extends AccountsSQLService {

    @Autowired
    public ClientAccountsSQLService(ConnectionService connectionService) {
        super(connectionService);
    }

    public List<Account> getAccounts(int id) throws SQLException, IllegalAccessException, InstantiationException {
        return getDSLContext()
                .select(getAccountsFields())
                .from(ACCOUNTS)
                .naturalJoin(CLIENTS)
                .where(CLIENTS.NAMEID.equal(id))
                .fetch().into(Account.class);
    }
}
