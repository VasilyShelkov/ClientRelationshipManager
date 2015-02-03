package account;

import dataObjects.Account;
import database.generic.GenericAccountSQLService;
import database.generic.GenericSQLService;
import generated.Tables;
import generated.tables.records.AccountsRecord;
import org.jooq.TableField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static generated.tables.Accounts.ACCOUNTS;

/**
 * Created by Vasia on 08/11/2014.
 */
@Service
public class AccountServiceImpl implements AccountService {

    private GenericAccountSQLService accountSQLService;

    @Autowired
    public AccountServiceImpl(GenericAccountSQLService accountGenericSQLService) {
        this.accountSQLService = accountGenericSQLService;
    }

    @Override
    public List<Account> getAllAccounts() throws SQLException, InstantiationException, IllegalAccessException {
        return accountSQLService.getTable(Tables.ACCOUNTS);
    }

    @Override
    public Account createAccount(Account account) throws SQLException, InstantiationException, IllegalAccessException {
        List row = new ArrayList();
        row.add(account.getName());
        row.add(account.getUserName());
        row.add(account.getPassword());
        row.add(account.getAdmin());
        return accountSQLService.createRecord(Tables.ACCOUNTS, row);
    }
}
