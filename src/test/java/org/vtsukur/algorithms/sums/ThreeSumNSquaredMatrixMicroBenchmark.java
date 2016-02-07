package org.vtsukur.algorithms.sums;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Arrays;
import java.util.stream.IntStream;

import static java.lang.invoke.MethodHandles.lookup;

/**
 * @author volodymyr.tsukur
 */
public class ThreeSumNSquaredMatrixMicroBenchmark {

    private static final int N = 10000;

    private static final int[] SORTED = IntStream.rangeClosed(-N / 2, N / 2 - 1).toArray();

    static {
        Arrays.sort(SORTED);
    }

    @Benchmark
    @BenchmarkMode({Mode.AverageTime})
    public void test() {
        ThreeSumNSquaredMatrix.countSorted(SORTED);
    }

    public static void main(final String[] args) throws RunnerException {
        new Runner(options()).run();
    }

    private static Options options() {
        return new OptionsBuilder().include(lookup().lookupClass().getSimpleName()).forks(1).build();
    }

}
