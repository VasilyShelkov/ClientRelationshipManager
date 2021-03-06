/**
 * This class is generated by jOOQ
 */
package generated;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.4.4" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Protectme extends org.jooq.impl.SchemaImpl {

	private static final long serialVersionUID = -1847931577;

	/**
	 * The singleton instance of <code>protectme</code>
	 */
	public static final Protectme PROTECTME = new Protectme();

	/**
	 * No further instances allowed
	 */
	private Protectme() {
		super("protectme");
	}

	@Override
	public final java.util.List<org.jooq.Table<?>> getTables() {
		java.util.List result = new java.util.ArrayList();
		result.addAll(getTables0());
		return result;
	}

	private final java.util.List<org.jooq.Table<?>> getTables0() {
		return java.util.Arrays.<org.jooq.Table<?>>asList(
			generated.tables.Accounts.ACCOUNTS,
			generated.tables.Clients.CLIENTS,
			generated.tables.Comments.COMMENTS,
			generated.tables.Company.COMPANY,
			generated.tables.Names.NAMES,
			generated.tables.Pictures.PICTURES,
			generated.tables.Protectednames.PROTECTEDNAMES,
			generated.tables.Unprotectednames.UNPROTECTEDNAMES);
	}
}
