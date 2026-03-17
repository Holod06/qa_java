package com.exapleTest;

import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class LionTest {

    @Mock
    Feline felineMock;

    @Test
    void maleLionShouldHaveMane() throws Exception {
        Lion lion = new Lion("Самец", felineMock);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    void femaleLionShouldNotHaveMane() throws Exception {
        Lion lion = new Lion("Самка", felineMock);
        assertFalse(lion.doesHaveMane());
    }

    @Test
    void constructorShouldThrowExceptionForInvalidSex() {
        assertThrows(Exception.class, () -> {
            new Lion("Кот", felineMock);
        });
    }

    @Test
    void getKittensShouldCallFeline() throws Exception {
        Mockito.when(felineMock.getKittens()).thenReturn(5);
        Lion lion = new Lion("Самка", felineMock);
        int result = lion.getKittens();
        assertEquals(5, result);
        Mockito.verify(felineMock).getKittens();
    }

    @Test
    void getFoodShouldReturnFoodFromFeline() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(felineMock.getFood("Хищник")).thenReturn(expectedFood);
        Lion lion = new Lion("Самец", felineMock);
        List<String> actualFood = lion.getFood();
        assertEquals(expectedFood, actualFood);
        Mockito.verify(felineMock).getFood("Хищник");
    }
}