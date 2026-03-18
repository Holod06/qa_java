package com.exapleTest;

import com.example.Feline;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FelineParameterizedTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 3, 5, 10})
    void getKittensWithParameterShouldReturnSameNumber(int kittensCount) {
        Feline feline = new Feline();
        int result = feline.getKittens(kittensCount);
        assertEquals(kittensCount, result);
    }
}