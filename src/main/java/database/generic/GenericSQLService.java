package database.generic;

import dataObjects.Account;
import database.ConnectionService;
import database.JOOQSQLService;
import generated.tables.records.NamesRecord;
import org.jooq.Record;
import org.jooq.TableField;
import org.jooq.impl.TableImpl;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Vasia on 09/11/2014.
 */
@Service
public abstract class GenericSQLService<T, U extends Record> extends JOOQSQLService {

    private Class<T> clazz;
    private List<TableField<U,?>> getFields;
    private List<TableField<U,?>> createFields;

    public GenericSQLService(Class<T> clazzToSet, List<TableField<U,?>> getFields, List<TableField<U,?>> createFields, ConnectionService connectionService) {
        super(connectionService);
        this.clazz = clazzToSet;
        this.getFields = getFields;
        this.createFields = createFields;
    }

    public List<T> getTable(TableImpl<U> table) throws SQLException, IllegalAccessException, InstantiationException {
        return getDSLContext().select(getFields)
                .from(table)
                .fetchInto(clazz);
    }

    public T createRecord(TableImpl<U> table, List row) throws SQLException, IllegalAccessException, InstantiationException{
        return getDSLContext().insertInto(table, createFields)
                .values(row)
                .returning(getFields)
                .fetchOne()
                .into(clazz);
    }
}
