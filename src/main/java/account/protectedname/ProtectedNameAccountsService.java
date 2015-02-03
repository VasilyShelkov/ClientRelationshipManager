package account.protectedname;

import dataObjects.Account;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Vasia on 11/01/2015.
 */
public interface ProtectedNameAccountsService {
    List<Account> getProtectedNameAccounts(int nameId) throws SQLException, InstantiationException, IllegalAccessException;
}
