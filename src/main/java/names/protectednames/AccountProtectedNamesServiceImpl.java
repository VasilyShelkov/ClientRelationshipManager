package names.protectednames;

import dataObjects.Name;
import dataObjects.ProtectedName;
import database.names.AccountProtectedNamesSQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jimy on 11/01/2015.
 */
@Service
public class AccountProtectedNamesServiceImpl implements AccountProtectedNamesService {

    private AccountProtectedNamesSQLService accountAccountProtectedNamesSQLService;

    @Autowired
    public AccountProtectedNamesServiceImpl(AccountProtectedNamesSQLService accountAccountProtectedNamesSQLService) {
        this.accountAccountProtectedNamesSQLService = accountAccountProtectedNamesSQLService;
    }

    @Override
    public List<Name> getProtectedNames(int accountId) throws SQLException, InstantiationException, IllegalAccessException {
        return accountAccountProtectedNamesSQLService.getProtectedNames(accountId);
    }

    @Override
    public ProtectedName createProtectedName(int accountId, ProtectedName protectedName) throws SQLException, IllegalAccessException, InstantiationException {
        List row = new ArrayList();
        row.add(protectedName.getNameId());
        row.add(protectedName.getAccountId());
        row.add(protectedName.getComments());
        row.add(protectedName.isCalled());
        row.add(protectedName.isBooked());
        row.add(protectedName.getCallback());
        row.add(protectedName.getDateBooked());
        row.add(protectedName.getPriority());
        return accountAccountProtectedNamesSQLService.createRecord(row);
    }
}
