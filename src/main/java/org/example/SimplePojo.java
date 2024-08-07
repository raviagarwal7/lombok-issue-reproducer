package org.example;

import lombok.*;

import javax.annotation.Nonnull;

@Data
@NoArgsConstructor
@Builder(toBuilder = true)
public class SimplePojo {
    @Nonnull
    private String nonNullProperty;

    private String nullableProperty;

    public SimplePojo(String nonNullProperty, String nullableProperty) {
        this.nonNullProperty = nonNullProperty;
        this.nullableProperty = nullableProperty;
    }
}
