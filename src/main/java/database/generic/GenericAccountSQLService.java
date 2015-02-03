package database.generic;

import dataObjects.Account;
import database.ConnectionService;
import generated.tables.records.AccountsRecord;
import org.jooq.TableField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

import static generated.Tables.ACCOUNTS;

/**
 * Created by Vasia on 15/01/2015.
 */
@Service
public class GenericAccountSQLService extends GenericSQLService<Account, AccountsRecord> {

    private static List<TableField<AccountsRecord,?>> accountGetFields = Arrays.asList(ACCOUNTS.ACCOUNTID, ACCOUNTS.NAME, ACCOUNTS.USERNAME, ACCOUNTS.ADMIN, ACCOUNTS.CREATEDAT, ACCOUNTS.PICTUREID);
    private static List<TableField<AccountsRecord,?>> accountCreateFields = Arrays.asList(ACCOUNTS.NAME, ACCOUNTS.USERNAME, ACCOUNTS.PASSWORD, ACCOUNTS.ADMIN);

    @Autowired
    public GenericAccountSQLService(Class<Account> accountClazz, ConnectionService connectionService) {
        super(accountClazz, accountGetFields, accountCreateFields, connectionService);
    }
}
