package dataObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by Vasia on 19/11/2014.
 */
public class Name {

    private int nameId;

    @Size(max = 50, message = "Size of the first name must be between 0 and 50 characters")
    @Pattern(regexp="([A-za-z\\s-]+)?", message = "The first name can only include letters and spaces")
    private String firstName;

    @Size(max = 50, message = "Size of the other names must be between 0 and 50 characters")
    @Pattern(regexp="([A-za-z\\s-]+)?", message = "The other names can only include letters and spaces")
    private String otherNames;

    @Size(max = 50, message = "Size of the mobile number must be between 0 and 50 characters")
    @Pattern(regexp="(\\+?[0-9\\s]+)?", message = "The mobile number can only include numbers and spaces")
    private String mobileNumber;

    @Size(max = 50, message = "Size of the office number must be between 0 and 50 characters")
    @Pattern(regexp="(\\+?[0-9\\s]+)?", message = "The office number can only include numbers and spaces")
    private String officeNumber;

    @Size(max = 50, message = "Size of the company name must be between 0 and 50 characters")
    @Pattern(regexp="([A-za-z\\s]+)?", message = "The company name can only include letters")
    private String company;

    private int pictureID;

    public Name(int nameId, String firstName, String otherNames, String mobileNumber, String officeNumber, String company, int pictureID) {
        this.nameId = nameId;
        this.firstName = firstName;
        this.otherNames = otherNames;
        this.mobileNumber = mobileNumber;
        this.officeNumber = officeNumber;
        this.company = company;
        this.pictureID = pictureID;
    }

    @JsonCreator
    public Name(@JsonProperty("firstName") String firstName, @JsonProperty("otherNames") String otherNames,
                @JsonProperty("mobileNumber") String mobileNumber, @JsonProperty("officeNumber") String officeNumber, @JsonProperty("company") String company) {
        this.firstName = firstName;
        this.otherNames = otherNames;
        this.mobileNumber = mobileNumber;
        this.officeNumber = officeNumber;
        this.company = company;
    }

    public int getNameId() {
        return nameId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getOtherNames() {
        return otherNames;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getOfficeNumber() {
        return officeNumber;
    }

    public String getCompany() {
        return company;
    }

    public int getPictureID() {
        return pictureID;
    }

    @AssertTrue(message = "You must either include first name or other names")
    private boolean isNamesValid() {
        if(firstName != null && firstName.trim().length() > 0)
            return true;
        return (otherNames != null && otherNames.trim().length() > 0);
    }

    @AssertTrue(message = "You must either include mobile number or company number")
    private boolean isPhoneNumbersValid() {
        if(mobileNumber != null && mobileNumber.trim().length() > 0)
            return true;
        return (officeNumber != null && officeNumber.trim().length() > 0);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 31). // two randomly chosen prime numbers
                // if deriving: appendSuper(super.hashCode()).
                append(firstName).
                append(otherNames).
                append(mobileNumber).
                append(officeNumber).
                append(company).
                append(pictureID).
                toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Name))
            return false;
        if (obj == this)
            return true;

        Name rhs = (Name) obj;
        return new EqualsBuilder().
                // if deriving: appendSuper(super.equals(obj)).
                append(firstName, rhs.firstName).
                append(otherNames, rhs.otherNames).
                append(mobileNumber, rhs.mobileNumber).
                append(officeNumber, rhs.officeNumber).
                append(company, rhs.company).
                append(pictureID, rhs.pictureID).
                isEquals();
    }
}