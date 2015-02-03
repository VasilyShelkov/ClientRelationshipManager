package account;

import dataObjects.Account;

import java.sql.SQLException;

/**
 * Created by Vasia on 19/11/2014.
 */
public interface AccountDetailService {

    Account getAccountDetails(int id) throws SQLException, InstantiationException, IllegalAccessException;
    Account getAccountDetails(String username) throws SQLException, InstantiationException, IllegalAccessException;
    Account updateAccount(int id, Account account) throws SQLException, InstantiationException, IllegalAccessException;
    void deleteAccount(Account account) throws SQLException, InstantiationException, IllegalAccessException;
}
