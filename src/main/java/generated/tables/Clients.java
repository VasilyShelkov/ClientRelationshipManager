/**
 * This class is generated by jOOQ
 */
package generated.tables;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.4.4" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Clients extends org.jooq.impl.TableImpl<generated.tables.records.ClientsRecord> {

	private static final long serialVersionUID = -870444520;

	/**
	 * The singleton instance of <code>protectme.clients</code>
	 */
	public static final generated.tables.Clients CLIENTS = new generated.tables.Clients();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<generated.tables.records.ClientsRecord> getRecordType() {
		return generated.tables.records.ClientsRecord.class;
	}

	/**
	 * The column <code>protectme.clients.NameID</code>.
	 */
	public final org.jooq.TableField<generated.tables.records.ClientsRecord, java.lang.Integer> NAMEID = createField("NameID", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>protectme.clients.AccountID</code>.
	 */
	public final org.jooq.TableField<generated.tables.records.ClientsRecord, java.lang.Integer> ACCOUNTID = createField("AccountID", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>protectme.clients.ClientAt</code>.
	 */
	public final org.jooq.TableField<generated.tables.records.ClientsRecord, java.sql.Timestamp> CLIENTAT = createField("ClientAt", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaulted(true), this, "");

	/**
	 * Create a <code>protectme.clients</code> table reference
	 */
	public Clients() {
		this("clients", null);
	}

	/**
	 * Create an aliased <code>protectme.clients</code> table reference
	 */
	public Clients(java.lang.String alias) {
		this(alias, generated.tables.Clients.CLIENTS);
	}

	private Clients(java.lang.String alias, org.jooq.Table<generated.tables.records.ClientsRecord> aliased) {
		this(alias, aliased, null);
	}

	private Clients(java.lang.String alias, org.jooq.Table<generated.tables.records.ClientsRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, generated.Protectme.PROTECTME, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<generated.tables.records.ClientsRecord> getPrimaryKey() {
		return generated.Keys.KEY_CLIENTS_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<generated.tables.records.ClientsRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<generated.tables.records.ClientsRecord>>asList(generated.Keys.KEY_CLIENTS_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public generated.tables.Clients as(java.lang.String alias) {
		return new generated.tables.Clients(alias, this);
	}

	/**
	 * Rename this table
	 */
	public generated.tables.Clients rename(java.lang.String name) {
		return new generated.tables.Clients(name, null);
	}
}
