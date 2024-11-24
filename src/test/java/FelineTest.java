package com.example;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;

public class FelineTest {

    @Test
    public void familyIsCorrect() {
        String expectedFelineFamilyName = "Кошачьи";
        MatcherAssert.assertThat("Неверное название семейства",
                new Feline().getFamily(),
                equalTo(expectedFelineFamilyName)
        );
    }

    @Test
    public void kittensInputCountIsCorrect() {
        int expectedCount = 3;
        MatcherAssert.assertThat("Неверное количество котят",
                new Feline().getKittens(expectedCount),
                equalTo(expectedCount)
        );
    }

    @Test
    public void kittensDefaultIsCorrect() {
        int expectedCount = 1;
        MatcherAssert.assertThat("Неверное количество котят",
                new Feline().getKittens(),
                equalTo(expectedCount)
        );
    }

    @Test
    public void eatMeatIsCorrect() throws Exception {
        Feline feline = new Feline();

        MatcherAssert.assertThat("Неверный список еды",
                feline.eatMeat(),
                equalTo(feline.getFood("Хищник"))
        );
    }
}