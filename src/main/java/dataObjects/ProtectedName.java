package dataObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import generated.enums.ProtectedNamesPriority;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.sql.Timestamp;

/**
 * Created by Vasia on 18/11/2014.
 */
public class ProtectedName{

    private int nameId;
    private int accountId;
    private String comments;
    private boolean called;
    private boolean booked;
    private Timestamp callback;
    private Timestamp dateBooked;
    private Timestamp protectedAt;
    private ProtectedNamesPriority priority;

    public ProtectedName(String comments, boolean called, boolean booked, Timestamp callback, Timestamp dateBooked,
                         Timestamp protectedAt, ProtectedNamesPriority priority) {
        this.comments = comments;
        this.called = called;
        this.booked = booked;
        this.callback = callback;
        this.dateBooked = dateBooked;
        this.protectedAt = protectedAt;
        this.priority = priority;
    }

    @JsonCreator
    public ProtectedName(@JsonProperty("nameId") int nameId,@JsonProperty("accountId") int accountId,@JsonProperty("comments") String comments,
                         @JsonProperty("called") boolean called,@JsonProperty("booked") boolean booked,@JsonProperty("callback") Timestamp callback,
                         @JsonProperty("dateBooked") Timestamp dateBooked,@JsonProperty("priority") ProtectedNamesPriority priority) {
        this.nameId = nameId;
        this.accountId = accountId;
        this.comments = comments;
        this.called = called;
        this.booked = booked;
        this.callback = callback;
        this.dateBooked = dateBooked;
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

    public void setNameId(int nameId) {
        this.nameId = nameId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public void setProtectedAt(Timestamp protectedAt) {
        this.protectedAt = protectedAt;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 31).
                append(nameId).
                append(accountId).
                append(comments).
                append(called).
                append(booked).
                append(callback).
                append(dateBooked).
                append(protectedAt).
                append(priority).
                toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ProtectedName))
            return false;
        if (obj == this)
            return true;

        ProtectedName rhs = (ProtectedName) obj;
        return new EqualsBuilder().
                append(nameId, rhs.nameId).
                append(accountId, rhs.accountId).
                append(comments, rhs.comments).
                append(called, rhs.called).
                append(booked, rhs.booked).
                append(callback, rhs.callback).
                append(dateBooked, rhs.dateBooked).
                append(protectedAt, rhs.protectedAt).
                append(priority, rhs.priority).
                isEquals();
    }
}
