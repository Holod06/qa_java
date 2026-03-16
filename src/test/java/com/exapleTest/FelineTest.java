package com.exapleTest;
import com.example.Feline;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;





//Animal наследование , поэтому mock е нужен
@ExtendWith(MockitoExtension.class)
public class FelineTest {

    @Spy
    Feline felineSpy;

    @Test
    void eatMeatShouldReturnFood() throws Exception {
        Feline feline = new Feline();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = feline.eatMeat();
        assertEquals(expectedFood, actualFood);
    }

    @Test
    void getFamilyShouldReturnFamily() {
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

    @Test
    void eatMeatShouldCallGetFoodMethod() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.doReturn(expectedFood).when(felineSpy).getFood("Хищник");
        List<String> result = felineSpy.eatMeat();
        assertEquals(expectedFood, result);
        Mockito.verify(felineSpy).getFood("Хищник");
    }
}