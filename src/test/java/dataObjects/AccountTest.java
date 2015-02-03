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
public class AccountTest {

    private static Validator validator;
    private Account testAccount;
    private String expectedMessage;
    private int expectedViolationSize;

    public AccountTest(Account testAccount, String expectedMessage, int expectedViolationSize) {
        this.testAccount = testAccount;
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
        String fakeLongUserName = "fakeblaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        return Arrays.asList(new Object[][] {
            { new Account( "testName", "testUsername", "te!s-t@P?a&s^s*w#o+r_d", false), null, 0 },
            { new Account( null, "testUsername", "testPassword", false), "Your name may not be empty", 1 },
            { new Account( fakeLongUserName, "testUsername", "testPassword", false),
                    "Size of your name must be between 0 and 50 characters", 1 },
            { new Account( "testName", null, "testPassword", false), "Your username may not be empty", 1 },
            { new Account( "testName", fakeLongUserName, "testPassword", false),
                    "Size of your username must be between 0 and 50 characters", 1 },
            { new Account( "testName", "testUsernameWith???", "testPassword", false),
                    "Your username can only include letters and numbers", 1 },
            { new Account( "testName", "testUsername", "12345", false),
                    "Size of your password must be between 6 and 50 characters", 1 },
            { new Account( "testName", "testUsername", fakeLongUserName, false),
                    "Size of your password must be between 6 and 50 characters", 1 },
            { new Account( "testName", "testUsername", "haha'injec:t;ion'", false),
                    "Your password can only letters, numbers and !?^%&@$*#+_- symbols", 1 },
            { new Account( "testName", "testUsername", "!@validPassword", null),
                    "You must choose whether the account is an admin", 1 }
        });
    }

    @Test
    public void validationChecks() {
        Set<ConstraintViolation<Account>> constraintViolations = validator.validate( this.testAccount );

        assertEquals(constraintViolations.size(), this.expectedViolationSize);
        if(this.expectedMessage != null)
            assertEquals(constraintViolations.iterator().next().getMessage(), this.expectedMessage);
    }
}