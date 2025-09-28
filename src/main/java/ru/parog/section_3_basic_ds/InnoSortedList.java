package ru.parog.section_3_basic_ds;

/**
 * Упорядоченный список с уникальными элементами, реализованный на основе массива.
 * Элементы хранятся в отсортированном виде согласно {@link java.util.Comparator}, если он передан,
 * либо по их естественному порядку ({@link Comparable}).
 *
 * @param <E> тип элементов в списке
 */
public interface InnoSortedList<E> {

    /**
     * Возвращает количество элементов в списке.
     *
     * @return количество элементов
     */
    int size();

    /**
     * Проверяет, пуст ли список.
     *
     * @return {@code true}, если список пуст, иначе {@code false}
     */
    boolean isEmpty();

    /**
     * Возвращает элемент по индексу. Сложность: O(1)
     *
     * @param i индекс элемента (от 0 до size - 1)
     * @return элемент по указанному индексу
     * @throws IndexOutOfBoundsException если индекс вне диапазона
     */
    E get(int i);

    /**
     * Проверяет, содержится ли элемент в списке. Сложность: O(log n)
     *
     * @param element искомый элемент (не {@code null})
     * @return {@code true}, если элемент найден, иначе {@code false}
     * @throws NullPointerException если передан {@code null}
     */
    boolean contains(E element);

    /**
     * Возвращает индекс элемента в списке. Сложность: O(log n)
     *
     * @param element искомый элемент
     * @return индекс элемента, либо -1, если элемент отсутствует
     */
    int indexOf(E element);

    /**
     * Добавляет элемент в список с сохранением порядка. Сложность: O(n) из-за возможного сдвига элементов
     *
     * @param element элемент для добавления (не {@code null})
     * @return {@code true}, если элемент был добавлен,
     * {@code false}, если элемент уже присутствует
     * @throws NullPointerException если передан {@code null}
     */
    boolean add(E element);

    /**
     * Удаляет элемент по индексу. Сложность: O(n)
     *
     * @param i индекс удаляемого элемента
     * @return удалённый элемент
     * @throws IndexOutOfBoundsException если индекс вне диапазона
     */
    E removeAt(int i);

    /**
     * Возвращает массив всех элементов списка.
     * Размер массива равен текущему размеру списка.
     *
     * @return новый массив с копией элементов
     */
    Object[] toArray();
}
