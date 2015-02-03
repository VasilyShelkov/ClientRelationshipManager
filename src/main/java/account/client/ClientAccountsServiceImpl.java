package account.client;

import dataObjects.Account;
import database.account.ClientAccountsSQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Vasia on 11/01/2015.
 */
@Service
public class ClientAccountsServiceImpl implements ClientAccountsService {

    private ClientAccountsSQLService clientAccountsSQLService;

    @Autowired
    public ClientAccountsServiceImpl(ClientAccountsSQLService clientAccountsSQLService) {
        this.clientAccountsSQLService = clientAccountsSQLService;
    }

    @Override
    public List<Account> getClientNameAccounts(int nameId) throws SQLException, InstantiationException, IllegalAccessException {
        return clientAccountsSQLService.getAccounts(nameId);
    }
}
