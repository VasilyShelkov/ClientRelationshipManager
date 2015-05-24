package dataObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.sql.Timestamp;

/**
 * Created by Vasia on 18/11/2014.
 */
public class Client {

    private int nameId;
    private int accountId;
    private Timestamp clientAt;

    public Client(Timestamp clientAt) {
        this.clientAt = clientAt;
    }

    @JsonCreator
    public Client(@JsonProperty("nameId") int nameId,@JsonProperty("accountId") int accountId) {
        this.nameId = nameId;
        this.accountId = accountId;
    }

    public int getNameId() {
        return nameId;
    }

    public int getAccountId() {
        return accountId;
    }

    public Timestamp getClientAt() {
        return clientAt;
    }

    public void setClientAt(Timestamp clientAt) {
        this.clientAt = clientAt;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 31).
                append(nameId).
                append(accountId).
                append(clientAt).
                toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Client))
            return false;
        if (obj == this)
            return true;

        Client rhs = (Client) obj;
        return new EqualsBuilder().
                append(nameId, rhs.nameId).
                append(accountId, rhs.accountId).
                append(clientAt, rhs.clientAt).
                isEquals();
    }
}
