package ru.parog.section_2_complexity_of_algo;

/**
 * 1.
 * Диапазон длины массива: 0 <= arr.length
 * Диапазон значения в массиве: −2^31 до 2^31-1
 * 2.
 * Тестовый класс {@link MinAndMaxTest}
 * 3.
 * Временная сложность: O(3(n/2)) -> O(n), где n - количество элементов во входящем массиве.
 * Пространственная сложность: O(1) - не используем дополнительных структур для хранения.
 */
public class MinAndMax {

    /**
     * Основная идея: используем парное сравнение. Внутри пары находим min и max.
     * Далее обновляем глобальный минимум: globalMin ? pairLocalMin.
     * Аналогично с глобальным максимумом: globalMax ? pairLocalMax.
     * Тогда получается 3 сравнения вместо 4 (если бы по отдельности проверять каждый элемент и на min, и на max).
     * В итоге выходит ровно 3(n/2) сравнений.
     *
     * @param arr входящий массив
     * @return результирующий массив, где первый элемент - минимум, второй элемент - максимум.
     */
    public static int[] findMinAndMax(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        if (arr.length == 1) return new int[]{arr[0], arr[0]};

        int globalMin = arr[0];
        int globalMax = arr[0];

        for (int i = 1; i < arr.length; i += 2) {
            int cur = arr[i - 1];
            int next = arr[i];

            int pairLocalMin = Math.min(cur, next);
            int pairLocalMax = Math.max(cur, next);

            globalMin = Math.min(pairLocalMin, globalMin);
            globalMax = Math.max(pairLocalMax, globalMax);
        }

        if (arr.length % 2 == 1) {
            globalMin = Math.min(arr[arr.length - 1], globalMin);
            globalMax = Math.max(arr[arr.length - 1], globalMax);
        }

        return new int[]{globalMin, globalMax};
    }
}
