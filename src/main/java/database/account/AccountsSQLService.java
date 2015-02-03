package database.account;

import database.ConnectionService;
import database.JOOQSQLService;
import generated.tables.records.AccountsRecord;
import org.jooq.TableField;

import java.util.Arrays;
import java.util.List;

import static generated.Tables.ACCOUNTS;

/**
 * Created by Vasia on 24/01/2015.
 */
public class AccountsSQLService extends JOOQSQLService {

    private static List<TableField<AccountsRecord, ?>> accountsFields = Arrays.asList(ACCOUNTS.ACCOUNTID, ACCOUNTS.NAME, ACCOUNTS.USERNAME, ACCOUNTS.ADMIN, ACCOUNTS.CREATEDAT, ACCOUNTS.PICTUREID);

    public AccountsSQLService(ConnectionService connectionService) {
        super(connectionService);
    }

    public static List<TableField<AccountsRecord, ?>> getAccountsFields() {
        return accountsFields;
    }
}
