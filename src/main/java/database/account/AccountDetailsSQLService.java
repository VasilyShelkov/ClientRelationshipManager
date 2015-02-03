package database.account;

import dataObjects.Account;
import database.ConnectionService;
import generated.tables.records.AccountsRecord;
import org.jooq.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

import static generated.Tables.ACCOUNTS;
import static org.jooq.impl.DSL.row;

/**
 * Created by Vasia on 18/11/2014.
 */
@Service
public class AccountDetailsSQLService extends AccountsSQLService {

    @Autowired
    public AccountDetailsSQLService(ConnectionService connectionService) {
        super(connectionService);
    }

    public Account getAccountDetail(int id) throws SQLException, IllegalAccessException, InstantiationException {
        Record record = getDSLContext()
                .select(getAccountsFields())
                .from(ACCOUNTS)
                .where(ACCOUNTS.ACCOUNTID.equal(id))
                .fetchOne();
        if (record == null){
            return null;
        }
        return record.into(Account.class);
    }

    public Account getAccountDetail(String username) throws SQLException, IllegalAccessException, InstantiationException {
        Record record = getDSLContext()
                .select(getAccountsFields())
                .from(ACCOUNTS)
                .where(ACCOUNTS.USERNAME.equal(username))
                .fetchOne();
        if (record == null){
            return null;
        }
        return record.into(Account.class);
    }

    public Account updateAccount(int id, Account accountUpdated) throws SQLException, IllegalAccessException, InstantiationException {
        getDSLContext()
                .update(ACCOUNTS)
                .set(ACCOUNTS.NAME, accountUpdated.getName())
                .set(ACCOUNTS.USERNAME, accountUpdated.getUserName())
                .set(ACCOUNTS.PASSWORD, accountUpdated.getPassword())
                .set(ACCOUNTS.ADMIN, accountUpdated.getAdmin())
                .where(ACCOUNTS.ACCOUNTID.equal(id))
                .execute();
        return getAccountDetail(id);
    }

    public void deleteAccount(Account account) throws SQLException, IllegalAccessException, InstantiationException {
        getDSLContext()
                .delete(ACCOUNTS)
                .where(ACCOUNTS.USERNAME.equal(account.getUserName()))
                .execute();
    }

}
