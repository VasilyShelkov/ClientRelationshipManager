/**
 * This class is generated by jOOQ
 */
package generated.tables.records;

import generated.enums.ProtectedNamesPriority;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.4.4" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ProtectednamesRecord extends org.jooq.impl.UpdatableRecordImpl<generated.tables.records.ProtectednamesRecord> implements org.jooq.Record8<java.lang.Integer, java.lang.Integer, java.lang.Boolean, java.lang.Boolean, java.sql.Timestamp, java.sql.Timestamp, java.sql.Timestamp, ProtectedNamesPriority> {

	private static final long serialVersionUID = 1553311467;

	/**
	 * Setter for <code>protectme.protectednames.AccountID</code>.
	 */
	public void setAccountid(java.lang.Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>protectme.protectednames.AccountID</code>.
	 */
	public java.lang.Integer getAccountid() {
		return (java.lang.Integer) getValue(0);
	}

	/**
	 * Setter for <code>protectme.protectednames.NameID</code>.
	 */
	public void setNameid(java.lang.Integer value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>protectme.protectednames.NameID</code>.
	 */
	public java.lang.Integer getNameid() {
		return (java.lang.Integer) getValue(1);
	}

	/**
	 * Setter for <code>protectme.protectednames.Called</code>.
	 */
	public void setCalled(java.lang.Boolean value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>protectme.protectednames.Called</code>.
	 */
	public java.lang.Boolean getCalled() {
		return (java.lang.Boolean) getValue(2);
	}

	/**
	 * Setter for <code>protectme.protectednames.Booked</code>.
	 */
	public void setBooked(java.lang.Boolean value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>protectme.protectednames.Booked</code>.
	 */
	public java.lang.Boolean getBooked() {
		return (java.lang.Boolean) getValue(3);
	}

	/**
	 * Setter for <code>protectme.protectednames.CallBack</code>.
	 */
	public void setCallback(java.sql.Timestamp value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>protectme.protectednames.CallBack</code>.
	 */
	public java.sql.Timestamp getCallback() {
		return (java.sql.Timestamp) getValue(4);
	}

	/**
	 * Setter for <code>protectme.protectednames.DateBooked</code>.
	 */
	public void setDatebooked(java.sql.Timestamp value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>protectme.protectednames.DateBooked</code>.
	 */
	public java.sql.Timestamp getDatebooked() {
		return (java.sql.Timestamp) getValue(5);
	}

	/**
	 * Setter for <code>protectme.protectednames.ProtectedAt</code>.
	 */
	public void setProtectedat(java.sql.Timestamp value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>protectme.protectednames.ProtectedAt</code>.
	 */
	public java.sql.Timestamp getProtectedat() {
		return (java.sql.Timestamp) getValue(6);
	}

	/**
	 * Setter for <code>protectme.protectednames.Priority</code>.
	 */
	public void setPriority(ProtectedNamesPriority value) {
		setValue(7, value);
	}

	/**
	 * Getter for <code>protectme.protectednames.Priority</code>.
	 */
	public ProtectedNamesPriority getPriority() {
		return (ProtectedNamesPriority) getValue(7);
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
	// Record8 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row8<java.lang.Integer, java.lang.Integer, java.lang.Boolean, java.lang.Boolean, java.sql.Timestamp, java.sql.Timestamp, java.sql.Timestamp, ProtectedNamesPriority> fieldsRow() {
		return (org.jooq.Row8) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row8<java.lang.Integer, java.lang.Integer, java.lang.Boolean, java.lang.Boolean, java.sql.Timestamp, java.sql.Timestamp, java.sql.Timestamp, ProtectedNamesPriority> valuesRow() {
		return (org.jooq.Row8) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field1() {
		return generated.tables.Protectednames.PROTECTEDNAMES.ACCOUNTID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field2() {
		return generated.tables.Protectednames.PROTECTEDNAMES.NAMEID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Boolean> field3() {
		return generated.tables.Protectednames.PROTECTEDNAMES.CALLED;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Boolean> field4() {
		return generated.tables.Protectednames.PROTECTEDNAMES.BOOKED;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.sql.Timestamp> field5() {
		return generated.tables.Protectednames.PROTECTEDNAMES.CALLBACK;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.sql.Timestamp> field6() {
		return generated.tables.Protectednames.PROTECTEDNAMES.DATEBOOKED;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.sql.Timestamp> field7() {
		return generated.tables.Protectednames.PROTECTEDNAMES.PROTECTEDAT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<ProtectedNamesPriority> field8() {
		return generated.tables.Protectednames.PROTECTEDNAMES.PRIORITY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value1() {
		return getAccountid();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value2() {
		return getNameid();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Boolean value3() {
		return getCalled();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Boolean value4() {
		return getBooked();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.sql.Timestamp value5() {
		return getCallback();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.sql.Timestamp value6() {
		return getDatebooked();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.sql.Timestamp value7() {
		return getProtectedat();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ProtectedNamesPriority value8() {
		return getPriority();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ProtectednamesRecord value1(java.lang.Integer value) {
		setAccountid(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ProtectednamesRecord value2(java.lang.Integer value) {
		setNameid(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ProtectednamesRecord value3(java.lang.Boolean value) {
		setCalled(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ProtectednamesRecord value4(java.lang.Boolean value) {
		setBooked(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ProtectednamesRecord value5(java.sql.Timestamp value) {
		setCallback(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ProtectednamesRecord value6(java.sql.Timestamp value) {
		setDatebooked(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ProtectednamesRecord value7(java.sql.Timestamp value) {
		setProtectedat(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ProtectednamesRecord value8(ProtectedNamesPriority value) {
		setPriority(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ProtectednamesRecord values(java.lang.Integer value1, java.lang.Integer value2, java.lang.Boolean value3, java.lang.Boolean value4, java.sql.Timestamp value5, java.sql.Timestamp value6, java.sql.Timestamp value7, ProtectedNamesPriority value8) {
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached ProtectednamesRecord
	 */
	public ProtectednamesRecord() {
		super(generated.tables.Protectednames.PROTECTEDNAMES);
	}

	/**
	 * Create a detached, initialised ProtectednamesRecord
	 */
	public ProtectednamesRecord(java.lang.Integer accountid, java.lang.Integer nameid, java.lang.Boolean called, java.lang.Boolean booked, java.sql.Timestamp callback, java.sql.Timestamp datebooked, java.sql.Timestamp protectedat, ProtectedNamesPriority priority) {
		super(generated.tables.Protectednames.PROTECTEDNAMES);

		setValue(0, accountid);
		setValue(1, nameid);
		setValue(2, called);
		setValue(3, booked);
		setValue(4, callback);
		setValue(5, datebooked);
		setValue(6, protectedat);
		setValue(7, priority);
	}
}
