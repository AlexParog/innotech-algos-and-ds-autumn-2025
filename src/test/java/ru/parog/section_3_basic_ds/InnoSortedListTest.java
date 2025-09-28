package ru.parog.section_3_basic_ds;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InnoSortedListTest {

    @Test
    void testAddAndOrder() {
        SimpleInnoSortedList<Integer> sisl = new SimpleInnoSortedList<>();
        assertTrue(sisl.add(1));
        assertTrue(sisl.add(2));
        assertTrue(sisl.add(3));
        assertFalse(sisl.add(3));
        assertEquals(3, sisl.size());
        assertEquals(1, sisl.get(0));
        assertEquals(2, sisl.get(1));
        assertEquals(3, sisl.get(2));
    }

    @Test
    void testDuplicatePrevented() {
        SimpleInnoSortedList<Integer> sisl = new SimpleInnoSortedList<>();
        assertTrue(sisl.add(3));
        assertFalse(sisl.add(3));
    }

    @Test
    void testContainsAndIndexOf() {
        SimpleInnoSortedList<String> sisl = new SimpleInnoSortedList<>();
        assertTrue(sisl.isEmpty());

        sisl.add("1");
        sisl.add("2");
        assertFalse(sisl.isEmpty());

        assertTrue(sisl.contains("2"));
        assertEquals(0, sisl.indexOf("1"));
        assertEquals(-1, sisl.indexOf("4"));
    }

    @Test
    void testRemoveAndBounds() {
        SimpleInnoSortedList<Integer> sisl = new SimpleInnoSortedList<>();
        sisl.add(1);
        sisl.add(2);
        sisl.add(3);
        assertEquals(2, sisl.removeAt(1));
        assertEquals(2, sisl.size());
        assertThrows(IndexOutOfBoundsException.class, () -> sisl.get(5));
        assertThrows(IndexOutOfBoundsException.class, () -> sisl.removeAt(-1));
    }

    @Test
    void testComparatorOrdering() {
        SimpleInnoSortedList<String> sisl = new SimpleInnoSortedList<>();

        sisl.add("bsd");
        sisl.add("asd");
        sisl.add("ztr");
        sisl.add("ddd");

        assertEquals("asd", sisl.get(0));
        assertEquals("bsd", sisl.get(1));
        assertEquals("ddd", sisl.get(2));
        assertEquals("ztr", sisl.get(3));
    }

    @Test
    void testNullNotAllowed() {
        SimpleInnoSortedList<Integer> list = new SimpleInnoSortedList<>();
        assertThrows(NullPointerException.class, () -> list.add(null));
    }

    @Test
    void testIncomparableClassOrdering() {
        SimpleInnoSortedList<IncomparableClass> sisl = new SimpleInnoSortedList<>();

        sisl.add(new IncomparableClass());

        assertThrows(ClassCastException.class, () -> sisl.add(new IncomparableClass()));
    }

    @Test
    void testComparableClassOrdering() {
        SimpleInnoSortedList<Employee> sisl = new SimpleInnoSortedList<>();

        Employee employee11 = new Employee(11);
        sisl.add(employee11);
        Employee employee12 = new Employee(12);
        sisl.add(employee12);
        Employee employee13 = new Employee(13);
        sisl.add(employee13);

        assertEquals(employee11, sisl.get(0));
        assertEquals(employee12, sisl.get(1));
        assertEquals(employee13, sisl.get(2));
    }

    @Test
    void testUseComparatorForOrdering() {
        SimpleInnoSortedList<Human> sisl = new SimpleInnoSortedList<>(new HumanComparator());

        Human badHuman = new Human(-1);
        sisl.add(badHuman);

        Human goodHuman = new Human(10);
        sisl.add(goodHuman);

        assertEquals(badHuman, sisl.get(0));
        assertEquals(goodHuman, sisl.get(1));
    }
}
