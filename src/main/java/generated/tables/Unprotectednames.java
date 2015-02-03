/**
 * This class is generated by jOOQ
 */
package generated.tables;

import generated.enums.unprotectedNamesPriority;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.4.4" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Unprotectednames extends org.jooq.impl.TableImpl<generated.tables.records.UnprotectednamesRecord> {

	private static final long serialVersionUID = 1090487518;

	/**
	 * The singleton instance of <code>protectme.unprotectednames</code>
	 */
	public static final generated.tables.Unprotectednames UNPROTECTEDNAMES = new generated.tables.Unprotectednames();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<generated.tables.records.UnprotectednamesRecord> getRecordType() {
		return generated.tables.records.UnprotectednamesRecord.class;
	}

	/**
	 * The column <code>protectme.unprotectednames.NameID</code>.
	 */
	public final org.jooq.TableField<generated.tables.records.UnprotectednamesRecord, java.lang.Integer> NAMEID = createField("NameID", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>protectme.unprotectednames.AccountID</code>.
	 */
	public final org.jooq.TableField<generated.tables.records.UnprotectednamesRecord, java.lang.Integer> ACCOUNTID = createField("AccountID", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>protectme.unprotectednames.Comments</code>.
	 */
	public final org.jooq.TableField<generated.tables.records.UnprotectednamesRecord, java.lang.String> COMMENTS = createField("Comments", org.jooq.impl.SQLDataType.VARCHAR.length(50).nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>protectme.unprotectednames.AddedAt</code>.
	 */
	public final org.jooq.TableField<generated.tables.records.UnprotectednamesRecord, java.sql.Timestamp> ADDEDAT = createField("AddedAt", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>protectme.unprotectednames.Priority</code>.
	 */
	public final org.jooq.TableField<generated.tables.records.UnprotectednamesRecord, unprotectedNamesPriority> PRIORITY = createField("Priority", org.jooq.util.mysql.MySQLDataType.VARCHAR.asEnumDataType(unprotectedNamesPriority.class), this, "");

	/**
	 * Create a <code>protectme.unprotectednames</code> table reference
	 */
	public Unprotectednames() {
		this("unprotectednames", null);
	}

	/**
	 * Create an aliased <code>protectme.unprotectednames</code> table reference
	 */
	public Unprotectednames(java.lang.String alias) {
		this(alias, generated.tables.Unprotectednames.UNPROTECTEDNAMES);
	}

	private Unprotectednames(java.lang.String alias, org.jooq.Table<generated.tables.records.UnprotectednamesRecord> aliased) {
		this(alias, aliased, null);
	}

	private Unprotectednames(java.lang.String alias, org.jooq.Table<generated.tables.records.UnprotectednamesRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, generated.Protectme.PROTECTME, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<generated.tables.records.UnprotectednamesRecord> getPrimaryKey() {
		return generated.Keys.KEY_UNPROTECTEDNAMES_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<generated.tables.records.UnprotectednamesRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<generated.tables.records.UnprotectednamesRecord>>asList(generated.Keys.KEY_UNPROTECTEDNAMES_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public generated.tables.Unprotectednames as(java.lang.String alias) {
		return new generated.tables.Unprotectednames(alias, this);
	}

	/**
	 * Rename this table
	 */
	public generated.tables.Unprotectednames rename(java.lang.String name) {
		return new generated.tables.Unprotectednames(name, null);
	}
}
