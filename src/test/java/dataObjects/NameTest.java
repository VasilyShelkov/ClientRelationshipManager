package dataObjects;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class NameTest {

    private static Validator validator;
    private Name testName;
    private String expectedMessage;
    private int expectedViolationSize;

    public NameTest(Name testName, String expectedMessage, int expectedViolationSize) {
        this.testName = testName;
        this.expectedMessage = expectedMessage;
        this.expectedViolationSize = expectedViolationSize;
    }

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Parameterized.Parameters(name = "{1} check")
    public static Collection<Object[]> generateData() {
        String fakeLongNumber = "0094304903920480924808203480283048028304809238802384098";
        String fakeLongName = "fakeblaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        return Arrays.asList(new Object[][]{
                {new Name("testFirstName", "testOtherName", "+12345", "+12345", "testCompany"), "name numbers with +", 0},
                {new Name("testFirstName", "testOtherName", "12345", "12345", "testCompany"), "name", 0},
                {new Name("testFirstName", "testOtherName", "12345", "12345", ""), "name without company", 0},
                {new Name("testFirstName", "", "12345", "", "testCompany"), "name without Other names and Office Number", 0},
                {new Name("testFirstName", "test other names", "12345", "12 34 56", "testCompany"), "name with spaces", 0},
                {new Name("  ", "", "12345", "12345", "testCompany"), "You must either include first name or other names", 1},
                {new Name("testFirstName", "testOtherName", "", "  ", "testCompany"),
                        "You must either include mobile number or company number", 1},
                {new Name(fakeLongName, "testOtherName", "12345", "12345", "testCompany"),
                        "Size of the first name must be between 0 and 50 characters", 1},
                {new Name("testFirstName", fakeLongName, "12345", "12345", "testCompany"),
                        "Size of the other names must be between 0 and 50 characters", 1},
                {new Name("testFirstName", "testOtherName", fakeLongNumber, "12345", "testCompany"),
                        "Size of the mobile number must be between 0 and 50 characters", 1},
                {new Name("testFirstName", "testOtherName", "12345", fakeLongNumber, "testCompany"),
                        "Size of the office number must be between 0 and 50 characters", 1},
                {new Name("testFirstName", "testOtherName", "12345", "12345", fakeLongName),
                        "Size of the company name must be between 0 and 50 characters", 1}
        });
    }

    @Test
    public void validationChecks() {
        Set<ConstraintViolation<Name>> constraintViolations = validator.validate( this.testName );

        assertEquals(constraintViolations.size(), this.expectedViolationSize);
        if(this.expectedViolationSize > 0)
            assertEquals(constraintViolations.iterator().next().getMessage(), this.expectedMessage);
    }
}