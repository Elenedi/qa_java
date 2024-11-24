package com.example;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;

import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(Parameterized.class)
public class LionParamTest {

    @Mock
    Feline feline;

    private final String sex;
    private final boolean hasMane;

    public LionParamTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters(name = "Класс Lion. Пол: {0}")
    public static Object[][] setSexForLion() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void haveManeIsCorrect() throws Exception {
        MatcherAssert.assertThat("У львиц нет гривы",
                new Lion(feline, this.sex).doesHaveMane(),
                equalTo(hasMane)
        );
    }
}
