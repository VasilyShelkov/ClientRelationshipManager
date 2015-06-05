/**
 * This class is generated by jOOQ
 */
package generated.tables;

import generated.enums.ProtectedNamesPriority;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.4.4" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Protectednames extends org.jooq.impl.TableImpl<generated.tables.records.ProtectednamesRecord> {

	private static final long serialVersionUID = 1460054654;

	/**
	 * The singleton instance of <code>protectme.protectednames</code>
	 */
	public static final generated.tables.Protectednames PROTECTEDNAMES = new generated.tables.Protectednames();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<generated.tables.records.ProtectednamesRecord> getRecordType() {
		return generated.tables.records.ProtectednamesRecord.class;
	}

	/**
	 * The column <code>protectme.protectednames.AccountID</code>.
	 */
	public final org.jooq.TableField<generated.tables.records.ProtectednamesRecord, java.lang.Integer> ACCOUNTID = createField("AccountID", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>protectme.protectednames.NameID</code>.
	 */
	public final org.jooq.TableField<generated.tables.records.ProtectednamesRecord, java.lang.Integer> NAMEID = createField("NameID", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>protectme.protectednames.Called</code>.
	 */
	public final org.jooq.TableField<generated.tables.records.ProtectednamesRecord, java.lang.Boolean> CALLED = createField("Called", org.jooq.impl.SQLDataType.BIT.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>protectme.protectednames.Booked</code>.
	 */
	public final org.jooq.TableField<generated.tables.records.ProtectednamesRecord, java.lang.Boolean> BOOKED = createField("Booked", org.jooq.impl.SQLDataType.BIT.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>protectme.protectednames.CallBack</code>.
	 */
	public final org.jooq.TableField<generated.tables.records.ProtectednamesRecord, java.sql.Timestamp> CALLBACK = createField("CallBack", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

	/**
	 * The column <code>protectme.protectednames.DateBooked</code>.
	 */
	public final org.jooq.TableField<generated.tables.records.ProtectednamesRecord, java.sql.Timestamp> DATEBOOKED = createField("DateBooked", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

	/**
	 * The column <code>protectme.protectednames.ProtectedAt</code>.
	 */
	public final org.jooq.TableField<generated.tables.records.ProtectednamesRecord, java.sql.Timestamp> PROTECTEDAT = createField("ProtectedAt", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>protectme.protectednames.Priority</code>.
	 */
	public final org.jooq.TableField<generated.tables.records.ProtectednamesRecord, ProtectedNamesPriority> PRIORITY = createField("Priority", org.jooq.util.mysql.MySQLDataType.VARCHAR.asEnumDataType(ProtectedNamesPriority.class), this, "");

	/**
	 * Create a <code>protectme.protectednames</code> table reference
	 */
	public Protectednames() {
		this("protectednames", null);
	}

	/**
	 * Create an aliased <code>protectme.protectednames</code> table reference
	 */
	public Protectednames(java.lang.String alias) {
		this(alias, generated.tables.Protectednames.PROTECTEDNAMES);
	}

	private Protectednames(java.lang.String alias, org.jooq.Table<generated.tables.records.ProtectednamesRecord> aliased) {
		this(alias, aliased, null);
	}

	private Protectednames(java.lang.String alias, org.jooq.Table<generated.tables.records.ProtectednamesRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, generated.Protectme.PROTECTME, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<generated.tables.records.ProtectednamesRecord> getPrimaryKey() {
		return generated.Keys.KEY_PROTECTEDNAMES_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<generated.tables.records.ProtectednamesRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<generated.tables.records.ProtectednamesRecord>>asList(generated.Keys.KEY_PROTECTEDNAMES_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public generated.tables.Protectednames as(java.lang.String alias) {
		return new generated.tables.Protectednames(alias, this);
	}

	/**
	 * Rename this table
	 */
	public generated.tables.Protectednames rename(java.lang.String name) {
		return new generated.tables.Protectednames(name, null);
	}
}
