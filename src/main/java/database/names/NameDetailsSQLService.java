package database.names;

import dataObjects.Name;
import database.ConnectionService;
import org.jooq.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

import static generated.Tables.NAMES;

/**
 * Created by Vasia on 26/01/2015.
 */
@Service
public class NameDetailsSQLService extends NamesSQLService{

    @Autowired
    public NameDetailsSQLService(ConnectionService connectionService) {
        super(connectionService);
    }

    public List<Name> searchNames(String firstName, String otherNames, String company, String mobileNumber) throws SQLException, IllegalAccessException, InstantiationException {
        return getDSLContext()
                .select(getNameFields())
                .from(NAMES)
                .where(NAMES.FIRSTNAME.equal(firstName))
                .and(NAMES.OTHERNAMES.equal(otherNames))
                .and(NAMES.COMPANY.equal(company))
                .or(NAMES.MOBILENUMBER.equal(mobileNumber))
                .fetchInto(Name.class);
    }

    public Name getName(int nameId) throws SQLException, IllegalAccessException, InstantiationException{
        Record record = getDSLContext()
                .select(getNameFields())
                .from(NAMES)
                .where(NAMES.NAMEID.equal(nameId))
                .fetchOne();
        if (record == null){
            return null;
        }
        return record
                .into(Name.class);
    }
}
