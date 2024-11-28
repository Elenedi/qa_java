package com.example;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;

public class FelineTest {

    @Test
    public void familyIsCorrectTest() {
        String expectedFelineFamilyName = "Кошачьи";
        MatcherAssert.assertThat("Неверное название семейства",
                new Feline().getFamily(),
                equalTo(expectedFelineFamilyName)
        );
    }

    @Test
    public void kittensInputCountIsCorrectTest() {
        int expectedCount = 3;
        MatcherAssert.assertThat("Неверное количество котят",
                new Feline().getKittens(expectedCount),
                equalTo(expectedCount)
        );
    }

    @Test
    public void kittensDefaultIsCorrectTest() {
        int expectedCount = 1;
        MatcherAssert.assertThat("Неверное количество котят",
                new Feline().getKittens(),
                equalTo(expectedCount)
        );
    }

    @Test
    public void eatMeatIsCorrectTest() throws Exception {
        Feline feline = new Feline();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        MatcherAssert.assertThat("Неверный список еды",
                feline.eatMeat(),
                equalTo(expectedFood)
        );
    }
}