package org.vtsukur.algorithms.symbol_table;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * @author volodymyr.tsukur
 */
@RunWith(Parameterized.class)
public class ComparableBasedSymbolTableTest {

    private final ComparableBasedSymbolTable<String, Integer> strategy;

    public ComparableBasedSymbolTableTest(final ComparableBasedSymbolTable<String, Integer> strategy) {
        this.strategy = strategy;
    }

    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object[]> strategies() {
        return Arrays.asList(new Object[][]{
                { new LinkedListComparableBasedSymbolTable() }
        });
    }

    @Test
    public void test() {
        strategy.put("is", 1);
        assertEquals(strategy.get("is"), Integer.valueOf(1));
    }

}
