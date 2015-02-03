package database;

/**
 * Created by Vasia on 09/11/2014.
 */
public abstract class DatabaseService {
    private String url;
    private String user;
    private String pass;

    protected DatabaseService(String url, String user, String pass) {
        this.url = url;
        this.user = user;
        this.pass = pass;
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }
}
