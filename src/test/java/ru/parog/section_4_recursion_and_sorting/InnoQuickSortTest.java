package ru.parog.section_4_recursion_and_sorting;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InnoQuickSortTest {

    /**
     * Должен сортировать обычный несортированный массив
     */
    @Test
    void shouldSortUnsortedArray() {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        int[] expected = {11, 12, 22, 25, 34, 64, 90};

        InnoQuickSort.quickSort(arr);

        assertThat(arr)
                .containsExactly(expected);
    }

    /**
     * Должен сортировать обычный несортированный массив
     */
    @Test
    void shouldHandleAlreadySortedArray() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};

        InnoQuickSort.quickSort(arr);

        assertThat(arr)
                .containsExactly(expected);
    }

    /**
     * Должен правильно обрабатывать массив, отсортированный в обратном порядке
     */
    @Test
    void shouldHandleReverseSortedArray() {
        int[] arr = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};

        InnoQuickSort.quickSort(arr);

        assertThat(arr)
                .containsExactly(expected);
    }

    /**
     * Должен обрабатывать массив с одинаковыми элементами
     */
    @Test
    void shouldHandleArrayWithDuplicates() {
        int[] arr = {5, 2, 8, 2, 9, 1, 5, 5};
        int[] expected = {1, 2, 2, 5, 5, 5, 8, 9};

        InnoQuickSort.quickSort(arr);

        assertThat(arr)
                .containsExactly(expected);
    }

    /**
     * Должен обрабатывать массив, где все элементы одинаковые
     */
    @Test
    void shouldHandleArrayWithAllSameElements() {
        int[] arr = {7, 7, 7, 7, 7};
        int[] expected = {7, 7, 7, 7, 7};

        InnoQuickSort.quickSort(arr);

        assertThat(arr)
                .containsExactly(expected);
    }

    /**
     * Должен выбросить исключение на пустой массив.
     */
    @Test
    void shouldHandleEmptyArray() {
        int[] arr = {};

        assertThatThrownBy(() -> InnoQuickSort.quickSort(arr))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Массив не может быть пустым");

    }

    /**
     * Должен обрабатывать массив с одним элементом
     */
    @Test
    void shouldHandleSingleElementArray() {
        int[] arr = {42};
        int[] expected = {42};

        InnoQuickSort.quickSort(arr);

        assertThat(arr)
                .containsExactly(expected);
    }

    /**
     * Должен обрабатывать массив с двумя элементами
     */
    @Test
    void shouldHandleTwoElementArray() {
        int[] arr = {2, 1};
        int[] expected = {1, 2};

        InnoQuickSort.quickSort(arr);

        assertThat(arr)
                .containsExactly(expected);
    }
}
