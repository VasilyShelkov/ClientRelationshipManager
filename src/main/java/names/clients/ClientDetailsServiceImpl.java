package names.clients;

import dataObjects.Client;
import database.names.ClientDetailsSQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * Created by Vasia on 24/01/2015.
 */
@Service
public class ClientDetailsServiceImpl implements ClientDetailsService {

    private ClientDetailsSQLService clientDetailsSQLService;

    @Autowired
    public ClientDetailsServiceImpl(ClientDetailsSQLService clientDetailsSQLService) {
        this.clientDetailsSQLService = clientDetailsSQLService;
    }

    @Override
    public Client getDetails(int nameId) throws SQLException, InstantiationException, IllegalAccessException {
        return clientDetailsSQLService.getClientDetails(nameId);
    }

    @Override
    public void deleteAccount(int nameId) throws IllegalAccessException, SQLException, InstantiationException {
        clientDetailsSQLService.removeClient(nameId);
    }
}
