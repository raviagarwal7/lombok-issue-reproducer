package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class SimplePojoTest {
    @Test
    public void testConstructor() {
        SimplePojo sp = new SimplePojo(null, null);
        System.out.println(sp);
    }

    @Test
    public void testSetters() {
        assertThrows(
                NullPointerException.class,
                () -> {
                    SimplePojo sp = new SimplePojo();
                    sp.setNonNullProperty(null);
                    sp.setNullableProperty(null);
                    System.out.println(sp);
                },
                "Expected to throw NPE"
        );
    }

    @Test
    public void testBuilder() {
        SimplePojo sp = SimplePojo.builder().nonNullProperty(null).build();
        System.out.println(sp);
    }

    @Test
    public void testToBuilder() {
        SimplePojo sp = new SimplePojo();
        SimplePojo spNew = sp.toBuilder().build();
        System.out.println(spNew);
    }
}
