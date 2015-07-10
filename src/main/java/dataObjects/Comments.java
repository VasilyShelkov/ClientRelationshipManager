package dataObjects;

import java.sql.Timestamp;

/**
 * Created by Vasia on 6/20/2015.
 */
public class Comments {

    private int commentId;
    private String comment;
    private Timestamp lastUpdated;

    public int getCommentId() {
        return commentId;
    }

    public String getComment() {
        return comment;
    }

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }
}
