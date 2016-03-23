package org.vtsukur.algorithms.symbol_table;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openjdk.jmh.annotations.Setup;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author volodymyr.tsukur
 */
@RunWith(Parameterized.class)
public class SymbolTableTest {

    private final SymbolTable<String, Integer> strategy;

    public SymbolTableTest(final SymbolTable<String, Integer> strategy) {
        this.strategy = strategy;
    }

    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object[]> strategies() {
        return Arrays.asList(new Object[][]{
                { new SinglyLinkedListSymbolTable() }
        });
    }

    @Setup
    public void clear() {
        strategy.clear();
    }

    @Test
    public void put_with_positive_get_and_contains() {
        strategy.put("is", 1);
        assertEquals(strategy.get("is"), Integer.valueOf(1));
        assertTrue(strategy.contains("is"));
        assertFalse(strategy.isEmpty());
        assertEquals(strategy.size(), 1);
    }

    @Test
    public void put_null_value_is_the_same_as_delete() {
        strategy.put("is", 1);
        assertEquals(strategy.get("is"), Integer.valueOf(1));

        strategy.put("is", null);
        assertEquals(strategy.get("is"), null);
        assertFalse(strategy.contains("is"));

        strategy.put("truly", 2);
        assertEquals(strategy.get("truly"), Integer.valueOf(2));

        strategy.delete("truly");
        assertEquals(strategy.get("truly"), null);
        assertFalse(strategy.contains("truly"));
    }

    @Test
    public void empty_case() {
        assertTrue(strategy.isEmpty());
        assertEquals(strategy.size(), 0);
    }

}
