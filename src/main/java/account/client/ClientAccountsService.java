package account.client;

import dataObjects.Account;
import dataObjects.Client;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Vasia on 11/01/2015.
 */
public interface ClientAccountsService {
    List<Account> getClientNameAccounts(int nameId) throws SQLException, InstantiationException, IllegalAccessException;
}
