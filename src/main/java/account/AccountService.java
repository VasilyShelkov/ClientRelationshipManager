package account;

import dataObjects.Account;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Vasia on 08/11/2014.
 */
public interface AccountService {
    List<Account> getAllAccounts() throws SQLException, InstantiationException, IllegalAccessException;
    Account createAccount(Account account) throws SQLException, InstantiationException, IllegalAccessException;
}
