package com.exapleTest;
import com.example.Cat;
import com.example.Predator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;



@ExtendWith(MockitoExtension.class)
public class CatTest {

    @Mock
    Predator predatorMock;

    @Test
    void getSoundShouldReturnMeow() {
        Cat cat = new Cat(predatorMock);
        String sound = cat.getSound();
        assertEquals("Мяу", sound);
    }

    @Test
    void getFoodShouldReturnPredatorFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(predatorMock.eatMeat()).thenReturn(expectedFood);
        Cat cat = new Cat(predatorMock);
        List<String> actualFood = cat.getFood();
        assertEquals(expectedFood, actualFood);
    }

    @Test
    void getFoodShouldCallEatMeatMethod() throws Exception {
        Mockito.when(predatorMock.eatMeat()).thenReturn(List.of("Животные"));
        Cat cat = new Cat(predatorMock);
        cat.getFood();
        Mockito.verify(predatorMock).eatMeat();
    }
}