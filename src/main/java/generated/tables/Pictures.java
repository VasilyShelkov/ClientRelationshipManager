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
public class Pictures extends org.jooq.impl.TableImpl<generated.tables.records.PicturesRecord> {

	private static final long serialVersionUID = 1848736636;

	/**
	 * The singleton instance of <code>protectme.pictures</code>
	 */
	public static final generated.tables.Pictures PICTURES = new generated.tables.Pictures();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<generated.tables.records.PicturesRecord> getRecordType() {
		return generated.tables.records.PicturesRecord.class;
	}

	/**
	 * The column <code>protectme.pictures.PictureID</code>.
	 */
	public final org.jooq.TableField<generated.tables.records.PicturesRecord, java.lang.Integer> PICTUREID = createField("PictureID", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>protectme.pictures.Location</code>.
	 */
	public final org.jooq.TableField<generated.tables.records.PicturesRecord, java.lang.String> LOCATION = createField("Location", org.jooq.impl.SQLDataType.VARCHAR.length(50).nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>protectme.pictures.AddedAt</code>.
	 */
	public final org.jooq.TableField<generated.tables.records.PicturesRecord, java.sql.Timestamp> ADDEDAT = createField("AddedAt", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaulted(true), this, "");

	/**
	 * Create a <code>protectme.pictures</code> table reference
	 */
	public Pictures() {
		this("pictures", null);
	}

	/**
	 * Create an aliased <code>protectme.pictures</code> table reference
	 */
	public Pictures(java.lang.String alias) {
		this(alias, generated.tables.Pictures.PICTURES);
	}

	private Pictures(java.lang.String alias, org.jooq.Table<generated.tables.records.PicturesRecord> aliased) {
		this(alias, aliased, null);
	}

	private Pictures(java.lang.String alias, org.jooq.Table<generated.tables.records.PicturesRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, generated.Protectme.PROTECTME, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Identity<generated.tables.records.PicturesRecord, java.lang.Integer> getIdentity() {
		return generated.Keys.IDENTITY_PICTURES;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<generated.tables.records.PicturesRecord> getPrimaryKey() {
		return generated.Keys.KEY_PICTURES_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<generated.tables.records.PicturesRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<generated.tables.records.PicturesRecord>>asList(generated.Keys.KEY_PICTURES_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public generated.tables.Pictures as(java.lang.String alias) {
		return new generated.tables.Pictures(alias, this);
	}

	/**
	 * Rename this table
	 */
	public generated.tables.Pictures rename(java.lang.String name) {
		return new generated.tables.Pictures(name, null);
	}
}
