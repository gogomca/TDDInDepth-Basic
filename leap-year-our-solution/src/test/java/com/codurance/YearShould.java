package com.codurance;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codurance.YearAssert.assertThat;

class YearShould {
    @Test
    public void notBeLeapYearWhen1997() {
        Year year = new Year(1997);

        assertThat(year).isNotLeap();
    }

    @ParameterizedTest
    @MethodSource("yearsDivisibleBy400")
    public void beALeapYearWhenDivisibleBy400(Year year) {
        assertThat(year).isLeap();
    }

    @ParameterizedTest
    @MethodSource("yearsDivisibleBy4")
    public void beALeapYearWhenDivisibleBy4(Year year) {
        assertThat(year).isLeap();
    }

    @ParameterizedTest
    @MethodSource("yearsDivisibleBy4And100ButNot400")
    public void notBeALeapYearWhenDivisibleBy4And100ButNot400(Year year) {
        assertThat(year).isNotLeap();
    }

    public static Stream<Year> yearsDivisibleBy400() {
        return Stream.of(
            new Year(1200),
            new Year(1600),
            new Year(2000)
        );
    }

    public static Stream<Year> yearsDivisibleBy4() {
        return Stream.of(
            new Year(1988),
            new Year(1992),
            new Year(1996)
        );
    }

    public static Stream<Year> yearsDivisibleBy4And100ButNot400() {
        return Stream.of(
            new Year(1700),
            new Year(1800),
            new Year(1900)
        );
    }
}

