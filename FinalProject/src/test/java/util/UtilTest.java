package util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UtilTest {

    @Test
    void testLowerCase() {
        assertEquals("Hello World", Util.toTitleCase("hello world"));
    }

    @Test
    void testUpperCase() {
        assertEquals("Hello World", Util.toTitleCase("HELLO WORLD"));
    }

    @Test
    void testMixedCase() {
        assertEquals("Hello World", Util.toTitleCase("hElLo wOrlD"));
    }

    @Test
    void testEmptyString() {
        assertEquals("", Util.toTitleCase(""));
    }
}
