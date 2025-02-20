package org.example.handsonproblems.validateemail;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.everit.json.schema.ValidationException;

public class EmailValidatorTest {

    @Test
    void testValidEmail() {
        String validEmail = "{ \"email\": \"aman@example.com\" }";

        // Expect no exception for a valid email
        assertDoesNotThrow(() -> Main.validateEmail(validEmail));
    }

    @Test
    void testInvalidEmail() {
        String invalidEmail = "{ \"email\": \"invalid-email\" }";

        // Expect an exception for an invalid email
        Exception exception = assertThrows(ValidationException.class, () -> Main.validateEmail(invalidEmail));

        // Check if the exception message contains "email"
        assertTrue(exception.getMessage().contains("email"));
    }

    @Test
    void testMissingEmailField() {
        String missingEmailField = "{ \"username\": \"aman\" }";

        // Expect an exception due to missing required "email" field
        Exception exception = assertThrows(ValidationException.class, () -> Main.validateEmail(missingEmailField));

        // Check if the exception message contains "required key [email]"
        assertTrue(exception.getMessage().contains("required key [email]"));
    }

    @Test
    void testEmptyJson() {
        String emptyJson = "{}";

        // Expect an exception due to missing required field
        Exception exception = assertThrows(ValidationException.class, () -> Main.validateEmail(emptyJson));

        assertTrue(exception.getMessage().contains("required key [email]"));
    }
}
