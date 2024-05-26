package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class AddressTest {

    @Test
    void testNullPostalCode() {
        assertFalse(Address.isPostalCodeValid(null));
    }

    @Test
    void testEmptyPostalCode() {
        assertFalse(Address.isPostalCodeValid(""));
    }

    @Test
    void testInvalidLengthPostalCode() {
        assertFalse(Address.isPostalCodeValid("A1B2C"));
        assertFalse(Address.isPostalCodeValid("A1B2C3D4E5"));
    }

    @Test
    void testValidSixCharacterPostalCode() {
        assertTrue(Address.isPostalCodeValid("A1B2C3"));
    }

    @Test
    void testInvalidSixCharacterPostalCode() {
        assertFalse(Address.isPostalCodeValid("A1B2CD"));
        assertFalse(Address.isPostalCodeValid("A1B2C!"));
    }

    @Test
    void testValidSevenCharacterPostalCode() {
        assertTrue(Address.isPostalCodeValid("A1B 2C3"));
    }

    @Test
    void testInvalidSevenCharacterPostalCode() {
        assertFalse(Address.isPostalCodeValid("AAB2 C3"));
        assertFalse(Address.isPostalCodeValid("A1B 2CD"));
        assertFalse(Address.isPostalCodeValid("A1B 2C-"));
    }
}
