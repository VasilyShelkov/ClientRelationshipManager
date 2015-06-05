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
public class Comments extends org.jooq.impl.TableImpl<generated.tables.records.CommentsRecord> {

	private static final long serialVersionUID = -1744828375;

	/**
	 * The singleton instance of <code>protectme.comments</code>
	 */
	public static final generated.tables.Comments COMMENTS = new generated.tables.Comments();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<generated.tables.records.CommentsRecord> getRecordType() {
		return generated.tables.records.CommentsRecord.class;
	}

	/**
	 * The column <code>protectme.comments.AccountID</code>.
	 */
	public final org.jooq.TableField<generated.tables.records.CommentsRecord, java.lang.Integer> ACCOUNTID = createField("AccountID", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>protectme.comments.NameID</code>.
	 */
	public final org.jooq.TableField<generated.tables.records.CommentsRecord, java.lang.Integer> NAMEID = createField("NameID", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>protectme.comments.CommentID</code>.
	 */
	public final org.jooq.TableField<generated.tables.records.CommentsRecord, java.lang.Integer> COMMENTID = createField("CommentID", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>protectme.comments.Comment</code>.
	 */
	public final org.jooq.TableField<generated.tables.records.CommentsRecord, java.lang.String> COMMENT = createField("Comment", org.jooq.impl.SQLDataType.CLOB.length(65535), this, "");

	/**
	 * The column <code>protectme.comments.LastUpdated</code>.
	 */
	public final org.jooq.TableField<generated.tables.records.CommentsRecord, java.sql.Timestamp> LASTUPDATED = createField("LastUpdated", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaulted(true), this, "");

	/**
	 * Create a <code>protectme.comments</code> table reference
	 */
	public Comments() {
		this("comments", null);
	}

	/**
	 * Create an aliased <code>protectme.comments</code> table reference
	 */
	public Comments(java.lang.String alias) {
		this(alias, generated.tables.Comments.COMMENTS);
	}

	private Comments(java.lang.String alias, org.jooq.Table<generated.tables.records.CommentsRecord> aliased) {
		this(alias, aliased, null);
	}

	private Comments(java.lang.String alias, org.jooq.Table<generated.tables.records.CommentsRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, generated.Protectme.PROTECTME, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<generated.tables.records.CommentsRecord> getPrimaryKey() {
		return generated.Keys.KEY_COMMENTS_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<generated.tables.records.CommentsRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<generated.tables.records.CommentsRecord>>asList(generated.Keys.KEY_COMMENTS_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public generated.tables.Comments as(java.lang.String alias) {
		return new generated.tables.Comments(alias, this);
	}

	/**
	 * Rename this table
	 */
	public generated.tables.Comments rename(java.lang.String name) {
		return new generated.tables.Comments(name, null);
	}
}