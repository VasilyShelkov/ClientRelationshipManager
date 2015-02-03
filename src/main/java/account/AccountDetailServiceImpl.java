package account;

import dataObjects.Account;
import database.account.AccountDetailsSQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * Created by Vasia on 18/11/2014.
 */
@Service
public class AccountDetailServiceImpl implements AccountDetailService {

    private AccountDetailsSQLService accountDetailSQLService;

    @Autowired
    public AccountDetailServiceImpl(AccountDetailsSQLService accountDetailSQLService) {
        this.accountDetailSQLService = accountDetailSQLService;
    }

    public Account getAccountDetails(int id) throws SQLException, InstantiationException, IllegalAccessException {
        return accountDetailSQLService.getAccountDetail(id);
    }

    public Account getAccountDetails(String username) throws SQLException, InstantiationException, IllegalAccessException {
        return accountDetailSQLService.getAccountDetail(username);
    }

    public Account updateAccount(int id, Account account) throws SQLException, InstantiationException, IllegalAccessException {
        return accountDetailSQLService.updateAccount(id, account);
    }

    public void deleteAccount(Account account) throws SQLException, InstantiationException, IllegalAccessException {
        accountDetailSQLService.deleteAccount(account);
    }
}
