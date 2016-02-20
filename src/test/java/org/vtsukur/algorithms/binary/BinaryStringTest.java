package org.vtsukur.algorithms.binary;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author volodymyr.tsukur
 */
public class BinaryStringTest {

    @Test
    public void overly_complicated() {
        assertEquals("0", BinaryStringOverlyComplicatedAlgorithm.of(0));
        assertEquals("1", BinaryStringOverlyComplicatedAlgorithm.of(1));
        assertEquals("110010", BinaryStringOverlyComplicatedAlgorithm.of(50));
    }

    @Test
    public void simple() {
        assertEquals("0", BinaryString.of(0));
        assertEquals("1", BinaryString.of(1));
        assertEquals("110010", BinaryString.of(50));
    }

}
