package org.vtsukur.algorithms.sorting;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.invoke.MethodHandles.lookup;

/**
 * @author volodymyr.tsukur
 */
@State(Scope.Benchmark)
public class SortingBenchmark {

    private static final int SIZE = 1_000_000;

    private static final Random RANDOM = new Random();

    private static final RecursiveMergeSort RECURSIVE_MERGE_SORT = new RecursiveMergeSort();

    @Benchmark
    public void benchmarkRecursiveMergeSort() {
        RECURSIVE_MERGE_SORT.sort(generateArrayOfNRandomItems());
    }

    @Benchmark
    public void benchmarkJavaArraysSort() {
        Arrays.sort(generateArrayOfNRandomItems());
    }

    private static Integer[] generateArrayOfNRandomItems() {
        final List<Integer> generated = IntStream.generate(RANDOM::nextInt)
                .limit(SIZE)
                .mapToObj(Integer::valueOf)
                .collect(Collectors.toList());
        return generated.toArray(new Integer[generated.size()]);
    }

    public static void main(final String[] args) throws RunnerException {
        new Runner(options()).run();
    }

    private static Options options() {
        return new OptionsBuilder()
                .include(thisClassName())
                .forks(1)
                .threads(1)
                .timeUnit(TimeUnit.MILLISECONDS)
                .mode(Mode.AverageTime)
                .warmupIterations(10)
                .measurementIterations(10)
                .build();
    }

    private static String thisClassName() {
        return lookup().lookupClass().getSimpleName();
    }

}
