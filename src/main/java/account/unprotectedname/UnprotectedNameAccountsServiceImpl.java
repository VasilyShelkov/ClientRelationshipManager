package account.unprotectedname;

import dataObjects.Account;
import database.account.UnprotectedNameAccountsSQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
/**
 * Created by Vasia on 11/01/2015.
 */
@Service
public class UnprotectedNameAccountsServiceImpl implements UnprotectedNameAccountsService {

    private UnprotectedNameAccountsSQLService unprotectedNameAccountsSQLService;

    @Autowired
    public UnprotectedNameAccountsServiceImpl(UnprotectedNameAccountsSQLService unprotectedNameAccountsSQLService) {
        this.unprotectedNameAccountsSQLService = unprotectedNameAccountsSQLService;
    }

    @Override
    public List<Account> getUnprotectedNameAccounts(int nameId) throws SQLException, InstantiationException, IllegalAccessException {
        return unprotectedNameAccountsSQLService.getAccounts(nameId);
    }
}
