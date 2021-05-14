package org.mindfulrunner;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BTest {
    @Test
    public void testNaming() {
        String name = "B";

        String expectedNaming = "NamingV1: " + "Naming:v1, abstract class, name: " + name;

        NamingV1 namingV1 = new NamingV1();
        String actualNaming = namingV1.getNaming(name);
        System.out.println(actualNaming);

        assertEquals(expectedNaming, actualNaming);
    }
}
