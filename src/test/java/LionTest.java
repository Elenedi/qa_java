package com.example;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {


    @Mock
    Feline feline;

    @Test
    public void createLionThrowsExceptionTest() {
        Exception exception = assertThrows(Exception.class, () -> {
            new Lion(feline, "Не определено");
                });
        MatcherAssert.assertThat(exception.getMessage(), equalTo("Используйте допустимые значения пола животного - самец или самка"));
    }

    @Test
    public void kittensIsCorrectTest() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        int expectedCount = 1;
        Mockito.when(feline.getKittens()).thenReturn(expectedCount);

        MatcherAssert.assertThat("Некорректное количество котят",
                lion.getKittens(),
                equalTo(expectedCount)
        );
    }

    @Test
    public void foodIsCorrectTest() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        List<String> expectedListOfFood = List.of("Баранина");
        Mockito.when(feline.eatMeat()).thenReturn(expectedListOfFood);

        MatcherAssert.assertThat("Некорректный список еды",
                lion.getFood(),
                equalTo(expectedListOfFood)
        );
    }
}
