package dataObjects;

import com.google.common.base.Objects;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by Vasia on 6/20/2015.
 */
public class Company {
    private int companyId;

    @Size(max = 50, message = "Size of the company name must be between 0 and 50 characters")
    @Pattern(regexp="([A-za-z\\s]+)?", message = "The company name can only include letters")
    private String name;

    @Size(max = 50, message = "Size of the office number must be between 0 and 50 characters")
    @Pattern(regexp="(\\+?[0-9\\s]+)?", message = "The office number can only include numbers and spaces")
    private String officeNumber;

    public Company(int companyId, String name, String officeNumber) {
        this.companyId = companyId;
        this.name = name;
        this.officeNumber = officeNumber;
    }

    public int getCompanyId() {
        return companyId;
    }

    public String getName() {
        return name;
    }

    public String getOfficeNumber() {
        return officeNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Company)) return false;
        Company company = (Company) o;
        return Objects.equal(companyId, company.companyId) &&
                Objects.equal(name, company.name) &&
                Objects.equal(officeNumber, company.officeNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(companyId, name, officeNumber);
    }
}
