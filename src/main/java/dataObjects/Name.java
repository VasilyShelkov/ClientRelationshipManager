package dataObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;

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

    @NotNull
    @Valid
    private Company company;

    private int pictureID;

    //Used to create unprotected/protected/client name as other details aren't relevant
    public Name(int nameId) {
        this.nameId = nameId;
    }

    public Name(int nameId, String firstName, String otherNames, String mobileNumber, Company company, int pictureID) {
        this.nameId = nameId;
        this.firstName = firstName;
        this.otherNames = otherNames;
        this.mobileNumber = mobileNumber;
        this.company = company;
        this.pictureID = pictureID;
    }

    @JsonCreator
    public Name(@JsonProperty("firstName") String firstName, @JsonProperty("otherNames") String otherNames,
                @JsonProperty("mobileNumber") String mobileNumber, @JsonProperty("company") Company company) {
        this.firstName = firstName;
        this.otherNames = otherNames;
        this.mobileNumber = mobileNumber;
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

    public Company getCompany() {
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
        return (company.getOfficeNumber() != null && company.getOfficeNumber().trim().length() > 0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Name)) return false;
        Name name = (Name) o;
        return com.google.common.base.Objects.equal(nameId, name.nameId) &&
                com.google.common.base.Objects.equal(pictureID, name.pictureID) &&
                com.google.common.base.Objects.equal(firstName, name.firstName) &&
                com.google.common.base.Objects.equal(otherNames, name.otherNames) &&
                com.google.common.base.Objects.equal(mobileNumber, name.mobileNumber) &&
                com.google.common.base.Objects.equal(company, name.company);
    }

    @Override
    public int hashCode() {
        return com.google.common.base.Objects.hashCode(nameId, firstName, otherNames, mobileNumber, company, pictureID);
    }
}