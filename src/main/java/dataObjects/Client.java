package dataObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.sql.Timestamp;

/**
 * Created by Vasia on 18/11/2014.
 */
public class Client extends Name {

    private int accountId;
    private Timestamp clientAt;

    public Client(int nameId, String firstName, String otherNames, String mobileNumber, Company company, int pictureID,
                  int accountId, Timestamp clientAt) {
        super(nameId, firstName, otherNames, mobileNumber, company, pictureID);
        this.accountId = accountId;
        this.clientAt = clientAt;
    }

    @JsonCreator
    public Client(@JsonProperty("nameId") int nameId,@JsonProperty("accountId") int accountId) {
        super(nameId);
        this.accountId = accountId;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        if (!super.equals(o)) return false;
        Client client = (Client) o;
        return Objects.equal(accountId, client.accountId) &&
                Objects.equal(clientAt, client.clientAt);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), accountId, clientAt);
    }
}
