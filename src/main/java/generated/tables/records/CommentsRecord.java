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
public class CommentsRecord extends org.jooq.impl.UpdatableRecordImpl<generated.tables.records.CommentsRecord> implements org.jooq.Record5<java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.String, java.sql.Timestamp> {

	private static final long serialVersionUID = 668129986;

	/**
	 * Setter for <code>protectme.comments.AccountID</code>.
	 */
	public void setAccountid(java.lang.Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>protectme.comments.AccountID</code>.
	 */
	public java.lang.Integer getAccountid() {
		return (java.lang.Integer) getValue(0);
	}

	/**
	 * Setter for <code>protectme.comments.NameID</code>.
	 */
	public void setNameid(java.lang.Integer value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>protectme.comments.NameID</code>.
	 */
	public java.lang.Integer getNameid() {
		return (java.lang.Integer) getValue(1);
	}

	/**
	 * Setter for <code>protectme.comments.CommentID</code>.
	 */
	public void setCommentid(java.lang.Integer value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>protectme.comments.CommentID</code>.
	 */
	public java.lang.Integer getCommentid() {
		return (java.lang.Integer) getValue(2);
	}

	/**
	 * Setter for <code>protectme.comments.Comment</code>.
	 */
	public void setComment(java.lang.String value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>protectme.comments.Comment</code>.
	 */
	public java.lang.String getComment() {
		return (java.lang.String) getValue(3);
	}

	/**
	 * Setter for <code>protectme.comments.LastUpdated</code>.
	 */
	public void setLastupdated(java.sql.Timestamp value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>protectme.comments.LastUpdated</code>.
	 */
	public java.sql.Timestamp getLastupdated() {
		return (java.sql.Timestamp) getValue(4);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Record3<java.lang.Integer, java.lang.Integer, java.lang.Integer> key() {
		return (org.jooq.Record3) super.key();
	}

	// -------------------------------------------------------------------------
	// Record5 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row5<java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.String, java.sql.Timestamp> fieldsRow() {
		return (org.jooq.Row5) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row5<java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.String, java.sql.Timestamp> valuesRow() {
		return (org.jooq.Row5) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field1() {
		return generated.tables.Comments.COMMENTS.ACCOUNTID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field2() {
		return generated.tables.Comments.COMMENTS.NAMEID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field3() {
		return generated.tables.Comments.COMMENTS.COMMENTID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field4() {
		return generated.tables.Comments.COMMENTS.COMMENT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.sql.Timestamp> field5() {
		return generated.tables.Comments.COMMENTS.LASTUPDATED;
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
	public java.lang.Integer value3() {
		return getCommentid();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value4() {
		return getComment();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.sql.Timestamp value5() {
		return getLastupdated();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CommentsRecord value1(java.lang.Integer value) {
		setAccountid(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CommentsRecord value2(java.lang.Integer value) {
		setNameid(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CommentsRecord value3(java.lang.Integer value) {
		setCommentid(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CommentsRecord value4(java.lang.String value) {
		setComment(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CommentsRecord value5(java.sql.Timestamp value) {
		setLastupdated(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CommentsRecord values(java.lang.Integer value1, java.lang.Integer value2, java.lang.Integer value3, java.lang.String value4, java.sql.Timestamp value5) {
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached CommentsRecord
	 */
	public CommentsRecord() {
		super(generated.tables.Comments.COMMENTS);
	}

	/**
	 * Create a detached, initialised CommentsRecord
	 */
	public CommentsRecord(java.lang.Integer accountid, java.lang.Integer nameid, java.lang.Integer commentid, java.lang.String comment, java.sql.Timestamp lastupdated) {
		super(generated.tables.Comments.COMMENTS);

		setValue(0, accountid);
		setValue(1, nameid);
		setValue(2, commentid);
		setValue(3, comment);
		setValue(4, lastupdated);
	}
}
