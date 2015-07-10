package dataObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;
import generated.enums.ProtectedNamesPriority;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.NotBlank;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Vasia on 18/11/2014.
 */
public class ProtectedName extends Name{

    private int accountId;
    private List<Comments> comments;
    private boolean called;
    private boolean booked;
    private Timestamp callback;
    private Timestamp dateBooked;
    private Timestamp protectedAt;

    @NotBlank(message = "The priority of the unprotected name may not be empty")
    private ProtectedNamesPriority priority;

    public ProtectedName(int nameId, String firstName, String otherNames, String mobileNumber, Company company, int pictureID,
                         int accountId, List<Comments> comments, boolean called, boolean booked, Timestamp callback,
                         Timestamp dateBooked, Timestamp protectedAt, ProtectedNamesPriority priority) {
        super(nameId, firstName, otherNames, mobileNumber, company, pictureID);
        this.accountId = accountId;
        this.comments = comments;
        this.called = called;
        this.booked = booked;
        this.callback = callback;
        this.dateBooked = dateBooked;
        this.protectedAt = protectedAt;
        this.priority = priority;
    }

    @JsonCreator
    public ProtectedName(@JsonProperty("nameId") int nameId,@JsonProperty("accountId") int accountId,
                         @JsonProperty("comments") List<Comments> comments, @JsonProperty("called") boolean called,
                         @JsonProperty("booked") boolean booked,@JsonProperty("callback") Timestamp callback,
                         @JsonProperty("dateBooked") Timestamp dateBooked,
                         @JsonProperty("priority") ProtectedNamesPriority priority) {
        super(nameId);
        this.accountId = accountId;
        this.comments = comments;
        this.called = called;
        this.booked = booked;
        this.callback = callback;
        this.dateBooked = dateBooked;
        this.priority = priority;
    }

    public int getAccountId() {
        return accountId;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public boolean isCalled() {
        return called;
    }

    public boolean isBooked() {
        return booked;
    }

    public Timestamp getCallback() {
        return callback;
    }

    public Timestamp getDateBooked() {
        return dateBooked;
    }

    public Timestamp getProtectedAt() {
        return protectedAt;
    }

    public ProtectedNamesPriority getPriority() {
        return priority;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public void setProtectedAt(Timestamp protectedAt) {
        this.protectedAt = protectedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProtectedName)) return false;
        if (!super.equals(o)) return false;
        ProtectedName that = (ProtectedName) o;
        return Objects.equal(accountId, that.accountId) &&
                Objects.equal(called, that.called) &&
                Objects.equal(booked, that.booked) &&
                Objects.equal(comments, that.comments) &&
                Objects.equal(callback, that.callback) &&
                Objects.equal(dateBooked, that.dateBooked) &&
                Objects.equal(protectedAt, that.protectedAt) &&
                Objects.equal(priority, that.priority);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), accountId, comments, called, booked, callback, dateBooked, protectedAt, priority);
    }
}
