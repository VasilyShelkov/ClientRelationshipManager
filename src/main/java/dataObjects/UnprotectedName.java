package dataObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import generated.enums.unprotectedNamesPriority;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
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
    private unprotectedNamesPriority priority;

    public UnprotectedName(String comments, Timestamp addedAt, unprotectedNamesPriority priority) {
        this.comments = comments;
        this.addedAt = addedAt;
        this.priority = priority;
    }

    @JsonCreator
    public UnprotectedName(@JsonProperty("nameId") int nameId, @JsonProperty("accountId") int accountId, @JsonProperty("comments") String comments, @JsonProperty("priority") unprotectedNamesPriority priority) {
        this.nameId = nameId;
        this.accountId = accountId;
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

    public unprotectedNamesPriority getPriority() {
        return priority;
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