package dataObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

/**
 * Created by Vasia on 08/11/2014.
 */
public class Account {

    private int accountID;

    @NotBlank(message = "Your name may not be empty")
    @Size(max = 50, message = "Size of your name must be between 0 and 50 characters")
    private String name;

    @NotBlank(message = "Your username may not be empty")
    @Size(max = 50, message = "Size of your username must be between 0 and 50 characters")
    @Pattern(regexp = "[A-z0-9a-z]+", message = "Your username can only include letters and numbers")
    private String userName;

    @NotBlank(message = "Your password may not be empty")
    @Size(min = 6, max = 50, message = "Size of your password must be between 6 and 50 characters")
    @Pattern(regexp = "[A-z0-9a-z!?^%&$*#+@_-]+", message = "Your password can only letters, numbers and !?^%&@$*#+_- symbols")
    private String password;

    @NotNull(message = "You must choose whether the account is an admin")
    private Boolean admin;
    private Timestamp createdAt;
    private int pictureID;

    public Account(int accountID, String name, String userName, Boolean admin, Timestamp createdAt, int pictureID) {
        this.accountID = accountID;
        this.name = name;
        this.userName = userName;
        this.admin = admin;
        this.createdAt = createdAt;
        this.pictureID = pictureID;
    }

    public Account(int accountID, String name, String userName, String password, Boolean admin, Timestamp createdAt, int pictureID) {
        this.accountID = accountID;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.admin = admin;
        this.createdAt = createdAt;
        this.pictureID = pictureID;
    }

    @JsonCreator
    public Account(@JsonProperty("name") String name, @JsonProperty("userName") String userName, @JsonProperty("password") String pass, @JsonProperty("admin") Boolean admin) {
        this.name = name;
        this.userName = userName;
        this.password = pass;
        this.admin = admin;
    }

    public int getAccountID() {
        return accountID;
    }

    public String getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public int getPictureID() {
        return pictureID;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 31). // two randomly chosen prime numbers
                // if deriving: appendSuper(super.hashCode()).
                append(accountID).
                append(name).
                append(userName).
                append(admin).
                append(createdAt).
                append(pictureID).
                append(password).
                toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Account))
            return false;
        if (obj == this)
            return true;

        Account rhs = (Account) obj;
        return new EqualsBuilder().
                // if deriving: appendSuper(super.equals(obj)).
                        append(accountID, rhs.accountID).
                append(name, rhs.name).
                append(userName, rhs.userName).
                append(admin, rhs.admin).
                append(createdAt, rhs.createdAt).
                append(pictureID, rhs.pictureID).
                append(password, rhs.password).
                isEquals();
    }
}
