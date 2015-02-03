package account.unprotectedname;

import dataObjects.Account;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Vasia on 11/01/2015.
 */
public interface UnprotectedNameAccountsService {
    List<Account> getUnprotectedNameAccounts(int nameId) throws SQLException, InstantiationException, IllegalAccessException;
}
