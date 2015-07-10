package dataObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;
import generated.enums.UnprotectedNamesPriority;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.xml.stream.events.Comment;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Vasia on 18/11/2014.
 */
public class UnprotectedName extends Name{

    @NotNull
    private int accountId;

    private List<Comments> comments;
    private Timestamp addedAt;

    @NotBlank(message = "The priority of the unprotected name may not be empty")
    private UnprotectedNamesPriority priority;

    public UnprotectedName(int nameId, String firstName, String otherNames, String mobileNumber, Company company, int pictureID,
                           int accountId, Timestamp addedAt, UnprotectedNamesPriority priority) {
        super(nameId, firstName, otherNames, mobileNumber, company, pictureID);
        this.accountId = accountId;
        this.addedAt = addedAt;
        this.priority = priority;
    }

    @JsonCreator
    public UnprotectedName(@JsonProperty("nameId") int nameID, @JsonProperty("accountId") int accountID,
                           @JsonProperty("comments") List<Comments> comments, @JsonProperty("priority") UnprotectedNamesPriority priority) {
        super(nameID);
        this.accountId = accountID;
        this.comments = comments;
        this.priority = priority;
    }

    public int getAccountId() {
        return accountId;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public Timestamp getAddedAt() {
        return addedAt;
    }

    public UnprotectedNamesPriority getPriority() {
        return priority;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }

    public void setAddedAt(Timestamp addedAt) {
        this.addedAt = addedAt;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof UnprotectedName)) return false;
        if (!super.equals(o)) return false;
        UnprotectedName that = (UnprotectedName) o;
        return Objects.equal(accountId, that.accountId) &&
                Objects.equal(comments, that.comments) &&
                Objects.equal(addedAt, that.addedAt) &&
                Objects.equal(priority, that.priority);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), accountId, comments, addedAt, priority);
    }
}
