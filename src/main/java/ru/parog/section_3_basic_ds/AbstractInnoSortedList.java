package ru.parog.section_3_basic_ds;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Базовая реализация интерфейса {@link InnoSortedList}, работающая на основе массива.
 *
 * @param <E> тип элементов в списке
 */
public abstract class AbstractInnoSortedList<E> implements InnoSortedList<E> {
    /**
     * Начальная ёмкость.
     */
    public static final int DEFAULT_INITIAL_CAPACITY = 10;

    /**
     * Массив для хранения элементов.
     */
    protected E[] elements;
    /**
     * Текущий размер списка.
     */
    protected int size;
    /**
     * Компаратор для упорядочивания элементов.
     */
    protected Comparator<? super E> comparator;

    /**
     * Конструктор без параметров.
     * Использует естественный порядок элементов.
     */
    protected AbstractInnoSortedList() {
        this(null);
    }

    /**
     * Конструктор с заданным компаратором.
     *
     * @param comparator компаратор для упорядочивания элементов (может быть {@code null})
     */
    protected AbstractInnoSortedList(Comparator<? super E> comparator) {
        this.elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
        this.size = 0;
        this.comparator = comparator;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E get(int i) {
        if (i < 0 || i >= size) throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + size);
        return elements[i];
    }

    @Override
    public boolean contains(E element) {
        if (element == null) throw new NullPointerException("Null elements not supported");
        return binarySearch(element) >= 0;
    }

    @Override
    public int indexOf(E element) {
        if (element == null) return -1;
        int position = binarySearch(element);
        return position >= 0 ? position : -1;
    }

    @Override
    public boolean add(E element) {
        if (element == null) {
            throw new NullPointerException("Element cannot be null");
        }

        int position = binarySearch(element);
        if (position >= 0) {
            // элемент присутствует в списке
            return false;
        }

        int insPos = -position - 1;
        ensureCapacity(size + 1);

        System.arraycopy(elements, insPos, elements, insPos + 1, size - insPos);
        elements[insPos] = element;
        size++;

        return true;
    }

    @Override
    public E removeAt(int i) {
        if (i >= 0 && i < size) {
            E deleted = elements[i];
            System.arraycopy(elements, i + 1, elements, i, size - i - 1);
            elements[--size] = null;
            return deleted;
        }
        throw new IndexOutOfBoundsException("Index out of bounds");
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append('[');
        for (int i = 0; i < size; i++) {
            if (i > 0) builder.append(", ");
            builder.append(elements[i]);
        }
        builder.append(']');
        return builder.toString();
    }

    /**
     * Реализация бинарного поиска.
     * Возвращает два варианта результата:
     * 1. Если элемент найден → индекс в массиве.
     * 2. Если элемент не найден → отрицательное значение
     *
     * @param target элемент для поиска
     * @return индекс элемента или позиция вставки (отрицательное значение)
     */
    private int binarySearch(E target) {
        int low = 0;
        int high = size - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (compare(elements[mid], target) == 0) {
                return mid;
            } else if (compare(elements[mid], target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -(low + 1);
    }

    /**
     * Гарантирует, что внутренний массив имеет достаточную ёмкость.
     * При необходимости увеличивает массив в 2 раза.
     *
     * @param minCapacity минимальная необходимая ёмкость
     */
    private void ensureCapacity(int minCapacity) {
        if (elements.length < minCapacity) {
            int newCapacity = Math.max(elements.length * 2, minCapacity);
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    /**
     * Сравнивает два элемента с использованием компаратора или
     * их естественного порядка.
     *
     * @param a первый элемент
     * @param b второй элемент
     * @return отрицательное число, если {@code a < b},
     * ноль, если {@code a == b},
     * положительное число, если {@code a > b}
     * @throws ClassCastException если элементы не реализуют {@link Comparable}
     *                            и компаратор отсутствует
     */
    private int compare(E a, E b) {
        if (comparator != null) {
            return comparator.compare(a, b);
        } else {
            if (a instanceof Comparable) {
                return ((Comparable<? super E>) a).compareTo(b);
            } else {
                throw new ClassCastException("I don't know how to compare the elements." +
                        " The elements must implement Comparable or pass Comparator.");
            }
        }
    }
}
