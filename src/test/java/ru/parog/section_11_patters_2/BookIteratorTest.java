package ru.parog.section_11_patters_2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BookIteratorTest {
    private BookCollection collection;
    private Book book1;
    private Book book2;
    private Book book3;

    @BeforeEach
    void setUp() {
        collection = new BookCollection();
        book1 = new Book("Чистый код", "Роберт Мартин");
        book2 = new Book("Паттерны проектирования", "GoF");
        book3 = new Book("Рефакторинг", "Мартин Фаулер");
    }

    /**
     * Итератор пустой коллекции не имеет элементов
     */
    @Test
    void emptyCollectionIteratorHasNoElements() {
        InnoIterator<Book> iterator = collection.iterator();

        assertThat(iterator.hasNext()).isFalse();
    }

    /**
     * Вызов next() на пустом итераторе выбрасывает исключение
     */
    @Test
    void nextOnEmptyIteratorShouldThrowException() {
        InnoIterator<Book> iterator = collection.iterator();

        assertThatThrownBy(iterator::next)
                .isInstanceOf(NoSuchElementException.class)
                .hasMessageContaining("Больше нет элементов");
    }

    /**
     * Итератор возвращает все элементы в правильном порядке
     */
    @Test
    void iteratorReturnsAllElementsInOrder() {
        collection.add(book1);
        collection.add(book2);
        collection.add(book3);

        InnoIterator<Book> iterator = collection.iterator();

        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(book1);

        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(book2);

        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(book3);

        assertThat(iterator.hasNext()).isFalse();
    }

    /**
     * Можно обойти коллекцию с одним элементом
     */
    @Test
    void canIterateOverSingleElement() {
        collection.add(book1);

        InnoIterator<Book> iterator = collection.iterator();

        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(book1);
        assertThat(iterator.hasNext()).isFalse();
    }

    /**
     * Вызов next() после окончания коллекции выбрасывает исключение
     */
    @Test
    void nextAfterEndShouldThrowException() {
        collection.add(book1);

        InnoIterator<Book> iterator = collection.iterator();
        iterator.next(); // первый элемент

        assertThatThrownBy(iterator::next)
                .isInstanceOf(NoSuchElementException.class);
    }

    /**
     * Разные итераторы работают независимо
     */
    @Test
    void differentIteratorsWorkIndependently() {
        collection.add(book1);
        collection.add(book2);
        collection.add(book3);

        InnoIterator<Book> iterator1 = collection.iterator();
        InnoIterator<Book> iterator2 = collection.iterator();

        // Продвигаем первый итератор
        assertThat(iterator1.next()).isEqualTo(book1);
        assertThat(iterator1.next()).isEqualTo(book2);

        // Второй итератор должен начинаться с начала
        assertThat(iterator2.next()).isEqualTo(book1);

        // Первый итератор продолжает с того же места
        assertThat(iterator1.next()).isEqualTo(book3);
    }

    /**
     * Можно обойти коллекцию через while-цикл
     */
    @Test
    void canIterateUsingWhileLoop() {
        collection.add(book1);
        collection.add(book2);
        collection.add(book3);

        InnoIterator<Book> iterator = collection.iterator();
        int count = 0;

        while (iterator.hasNext()) {
            Book book = iterator.next();
            assertThat(book).isNotNull();
            count++;
        }

        assertThat(count).isEqualTo(3);
    }

    /**
     * Итератор работает с большим количеством элементов
     */
    @Test
    void iteratorWorksWithManyElements() {
        int numberOfBooks = 100;

        for (int i = 0; i < numberOfBooks; i++) {
            collection.add(new Book("Книга " + i, "Автор " + i));
        }

        InnoIterator<Book> iterator = collection.iterator();
        int count = 0;

        while (iterator.hasNext()) {
            iterator.next();
            count++;
        }

        assertThat(count).isEqualTo(numberOfBooks);
    }
}
