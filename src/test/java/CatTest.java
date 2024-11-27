package com.example;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    @Test
    public void soundIsCorrectTest() {
        String expectedString = "Мяу";

        MatcherAssert.assertThat("Коты издают другие звуки",
                new Cat(feline).getSound(),
                equalTo(expectedString)
        );
    }

    @Test
    public void foodIsCorrectTest() throws Exception {
        Cat cat = new Cat(feline);
        List<String> expectedListOfFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(expectedListOfFood);

        MatcherAssert.assertThat("Некорректный список еды",
                cat.getFood(),
                equalTo(expectedListOfFood)
        );
    }
}
