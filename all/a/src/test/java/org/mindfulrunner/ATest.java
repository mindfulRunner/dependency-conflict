package org.mindfulrunner;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ATest {
    @Test
    public void testNaming() {
        String name = "A";

        String expectedNaming = "NamingV2: " + "Naming:v2, interface, name: " + name;

        NamingV2 namingV2 = new NamingV2();
        String actualNaming = namingV2.getNaming(name);
        System.out.println(actualNaming);

        assertEquals(expectedNaming, actualNaming);
    }

    @Test
    public void testNaming_from_b() {
        String name = "B";

        String expectedNaming = "NamingV1: " + "Naming:v1, abstract class, name: " + name;

        NamingV1 namingV1 = new NamingV1();
        String actualNaming = namingV1.getNaming(name);
        System.out.println(actualNaming);

        assertEquals(expectedNaming, actualNaming);
    }
}
