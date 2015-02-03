package account.protectedname;

import dataObjects.Account;
import database.account.ProtectedNameAccountsSQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Vasia on 11/01/2015.
 */
@Service
public class ProtectedNameAccountsServiceImpl implements ProtectedNameAccountsService {

    private ProtectedNameAccountsSQLService protectedNameAccountsSQLService;

    @Autowired
    public ProtectedNameAccountsServiceImpl(ProtectedNameAccountsSQLService protectedNameAccountsSQLService) {
        this.protectedNameAccountsSQLService = protectedNameAccountsSQLService;
    }

    @Override
    public List<Account> getProtectedNameAccounts(int nameId) throws IllegalAccessException, SQLException, InstantiationException {
        return protectedNameAccountsSQLService.getAccounts(nameId);
    }
}
