package ru.parog.section_2_complexity_of_algo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Тестовый класс для задачи {@link MinAndMax}
 */
public class MinAndMaxTest {
    @Test
    void MinAndMaxTest1() {
        assertThat(MinAndMax.findMinAndMax(new int[]{})).isEqualTo(null);
    }

    @Test
    void MinAndMaxTest2() {
        assertThat(MinAndMax.findMinAndMax(new int[]{1})).isEqualTo(new int[]{1, 1});
    }

    @Test
    void MinAndMaxTest3() {
        assertThat(MinAndMax.findMinAndMax(new int[]{2, 1, -1})).isEqualTo(new int[]{-1, 2});
    }

    @Test
    void MinAndMaxTest4() {
        assertThat(MinAndMax.findMinAndMax(new int[]{7, 3, 9, 1, 5})).isEqualTo(new int[]{1, 9});
    }

    @Test
    void MinAndMaxTest5() {
        assertThat(MinAndMax.findMinAndMax(new int[]{7, 3, 9, 1, 5, 1000000})).isEqualTo(new int[]{1, 1000000});
    }
}
