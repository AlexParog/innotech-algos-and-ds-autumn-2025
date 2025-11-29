package ru.parog.section_11_patters_2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BookCollectionTest {
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
     * Новая коллекция должна быть пустой
     */
    @Test
    void newCollectionShouldBeEmpty() {
        assertThat(collection.isEmpty()).isTrue();
        assertThat(collection.getSize()).isZero();
    }

    /**
     * Добавление книги увеличивает размер коллекции
     */
    @Test
    void addingBookShouldIncreaseSize() {
        collection.add(book1);

        assertThat(collection.getSize()).isEqualTo(1);
        assertThat(collection.isEmpty()).isFalse();
    }

    /**
     * Можно добавить несколько книг
     */
    @Test
    void canAddMultipleBooks() {
        collection.add(book1);
        collection.add(book2);
        collection.add(book3);

        assertThat(collection.getSize()).isEqualTo(3);
    }

    /**
     * Добавление null книги выбрасывает исключение
     */
    @Test
    void addingNullBookShouldThrowException() {
        assertThatThrownBy(() -> collection.add(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("не может быть null");
    }

    /**
     * Коллекция автоматически расширяется при превышении вместимости
     */
    @Test
    void collectionShouldExpandAutomatically() {
        // Добавляем больше элементов, чем начальная вместимость (10)
        for (int i = 0; i < 15; i++) {
            collection.add(new Book("Книга " + i, "Автор " + i));
        }

        assertThat(collection.getSize()).isEqualTo(15);
    }

    /**
     * Итератор не равен null
     */
    @Test
    void iteratorShouldNotBeNull() {
        collection.add(book1);

        InnoIterator<Book> iterator = collection.iterator();

        assertThat(iterator).isNotNull();
    }

    /**
     * Можно создать несколько независимых итераторов
     */
    @Test
    void canCreateMultipleIterators() {
        collection.add(book1);
        collection.add(book2);

        InnoIterator<Book> iterator1 = collection.iterator();
        InnoIterator<Book> iterator2 = collection.iterator();

        assertThat(iterator1).isNotNull();
        assertThat(iterator2).isNotNull();
        assertThat(iterator1).isNotSameAs(iterator2);
    }
}
