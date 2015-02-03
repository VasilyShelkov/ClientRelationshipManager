/**
 * This class is generated by jOOQ
 */
package generated.tables.records;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.4.4" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ClientsRecord extends org.jooq.impl.UpdatableRecordImpl<generated.tables.records.ClientsRecord> implements org.jooq.Record3<java.lang.Integer, java.lang.Integer, java.sql.Timestamp> {

	private static final long serialVersionUID = 1677257072;

	/**
	 * Setter for <code>protectme.clients.NameID</code>.
	 */
	public void setNameid(java.lang.Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>protectme.clients.NameID</code>.
	 */
	public java.lang.Integer getNameid() {
		return (java.lang.Integer) getValue(0);
	}

	/**
	 * Setter for <code>protectme.clients.AccountID</code>.
	 */
	public void setAccountid(java.lang.Integer value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>protectme.clients.AccountID</code>.
	 */
	public java.lang.Integer getAccountid() {
		return (java.lang.Integer) getValue(1);
	}

	/**
	 * Setter for <code>protectme.clients.ClientAt</code>.
	 */
	public void setClientat(java.sql.Timestamp value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>protectme.clients.ClientAt</code>.
	 */
	public java.sql.Timestamp getClientat() {
		return (java.sql.Timestamp) getValue(2);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Record2<java.lang.Integer, java.lang.Integer> key() {
		return (org.jooq.Record2) super.key();
	}

	// -------------------------------------------------------------------------
	// Record3 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row3<java.lang.Integer, java.lang.Integer, java.sql.Timestamp> fieldsRow() {
		return (org.jooq.Row3) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row3<java.lang.Integer, java.lang.Integer, java.sql.Timestamp> valuesRow() {
		return (org.jooq.Row3) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field1() {
		return generated.tables.Clients.CLIENTS.NAMEID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field2() {
		return generated.tables.Clients.CLIENTS.ACCOUNTID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.sql.Timestamp> field3() {
		return generated.tables.Clients.CLIENTS.CLIENTAT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value1() {
		return getNameid();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value2() {
		return getAccountid();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.sql.Timestamp value3() {
		return getClientat();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ClientsRecord value1(java.lang.Integer value) {
		setNameid(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ClientsRecord value2(java.lang.Integer value) {
		setAccountid(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ClientsRecord value3(java.sql.Timestamp value) {
		setClientat(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ClientsRecord values(java.lang.Integer value1, java.lang.Integer value2, java.sql.Timestamp value3) {
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached ClientsRecord
	 */
	public ClientsRecord() {
		super(generated.tables.Clients.CLIENTS);
	}

	/**
	 * Create a detached, initialised ClientsRecord
	 */
	public ClientsRecord(java.lang.Integer nameid, java.lang.Integer accountid, java.sql.Timestamp clientat) {
		super(generated.tables.Clients.CLIENTS);

		setValue(0, nameid);
		setValue(1, accountid);
		setValue(2, clientat);
	}
}