package com.exapleTest;

import com.example.Feline;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FelineTest {

    @Test
    void eatMeatShouldReturnPredatorFood() throws Exception {

        Feline feline = new Feline();

        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");

        List<String> actualFood = feline.eatMeat();

        assertEquals(expectedFood, actualFood);
    }

    @Test
    void getFamilyShouldReturnFelineFamily() {

        Feline feline = new Feline();

        String actualFamily = feline.getFamily();

        assertEquals("Кошачьи", actualFamily);
    }

    @Test
    void getKittensWithoutParameterShouldReturnOne() {
        Feline feline = new Feline();
        int kittens = feline.getKittens();
        assertEquals(1, kittens);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 3, 5, 10})
    void getKittensWithParameterShouldReturnSameNumber(int kittensCount) {
        Feline feline = new Feline();
        int result = feline.getKittens(kittensCount);
        assertEquals(kittensCount, result);
    }
}