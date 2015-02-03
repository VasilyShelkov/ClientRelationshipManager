package names.unprotectednames;

import dataObjects.Name;
import dataObjects.UnprotectedName;
import database.names.AccountUnprotectedNamesSQLService;
import generated.Tables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vasia on 11/01/2015.
 */
@Service
public class AccountUnprotectedNamesServiceImpl implements AccountUnprotectedNamesService {

    private AccountUnprotectedNamesSQLService accountUnprotectedNamesSQLService;

    @Autowired
    public AccountUnprotectedNamesServiceImpl(AccountUnprotectedNamesSQLService accountUnprotectedNamesSQLService) {
        this.accountUnprotectedNamesSQLService = accountUnprotectedNamesSQLService;
    }

    @Override
    public List<Name> getUnprotectedNames(int accountId) throws SQLException, InstantiationException, IllegalAccessException {
        return accountUnprotectedNamesSQLService.getUnprotectedNames(accountId);
    }

    @Override
    public UnprotectedName createUnprotectedName(UnprotectedName unprotectedName) throws SQLException, InstantiationException, IllegalAccessException {
        return accountUnprotectedNamesSQLService.createRecord(unprotectedName);
    }
}
