package ru.parog.section_10_patterns;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InnoLoggingListProxyTest {
    private InnoLoggingListProxy<Integer> innoLoggingListProxy;

    @BeforeEach
    void setUp() {
        innoLoggingListProxy = new InnoLoggingListProxy<>(new ArrayList<>());
    }

    @Test
    void shouldIncrementAddCountWhenUsingAddAll() {
        int addOperationCounter = innoLoggingListProxy.getAddCount();
        assertEquals(0, addOperationCounter);

        innoLoggingListProxy.add(1);
        innoLoggingListProxy.add(3);

        assertEquals(addOperationCounter + 2, innoLoggingListProxy.getAddCount());
    }

    @Test
    void shouldIncrementAddCountWhenAddingCollection() {
        innoLoggingListProxy.addAll(Arrays.asList(1, 2, 3));

        assertEquals(3, innoLoggingListProxy.getAddCount());
        assertEquals(3, innoLoggingListProxy.size());
    }

    @Test
    void shouldDelegateAddToOriginalList() {
        List<Integer> base = new ArrayList<>();
        innoLoggingListProxy = new InnoLoggingListProxy<>(base);

        innoLoggingListProxy.add(1);

        assertEquals(1, innoLoggingListProxy.getAddCount());
        assertEquals(1, base.size());
        assertTrue(base.contains(1));
    }
}
