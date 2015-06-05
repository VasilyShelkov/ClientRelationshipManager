package dataObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import generated.enums.UnprotectedNamesPriority;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.NotBlank;

import java.sql.Timestamp;

/**
 * Created by Vasia on 18/11/2014.
 */
public class UnprotectedName{

    private int nameId;
    private int accountId;
    private String comments;
    private Timestamp addedAt;

    @NotBlank(message = "The priority of the unprotected name may not be empty")
    private UnprotectedNamesPriority priority;

    public UnprotectedName(String comments, Timestamp addedAt, UnprotectedNamesPriority priority) {
        this.comments = comments;
        this.addedAt = addedAt;
        this.priority = priority;
    }

    @JsonCreator
    public UnprotectedName(@JsonProperty("nameId") int nameID, @JsonProperty("accountId") int accountID, @JsonProperty("comments") String comments, @JsonProperty("priority") UnprotectedNamesPriority priority) {
        this.nameId = nameID;
        this.accountId = accountID;
        this.comments = comments;
        this.priority = priority;
    }

    public int getNameId() {
        return nameId;
    }

    public int getAccountId() {
        return accountId;
    }

    public String getComments() {
        return comments;
    }

    public Timestamp getAddedAt() {
        return addedAt;
    }

    public UnprotectedNamesPriority getPriority() {
        return priority;
    }

    public void setAddedAt(Timestamp addedAt) {
        this.addedAt = addedAt;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 31).
                append(nameId).
                append(accountId).
                append(comments).
                append(addedAt).
                append(priority).
                toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof UnprotectedName))
            return false;
        if (obj == this)
            return true;

        UnprotectedName rhs = (UnprotectedName) obj;
        return new EqualsBuilder().
                append(nameId, rhs.nameId).
                append(accountId, rhs.accountId).
                append(comments, rhs.comments).
                append(addedAt, rhs.addedAt).
                append(priority, rhs.priority).
                isEquals();
    }
}
