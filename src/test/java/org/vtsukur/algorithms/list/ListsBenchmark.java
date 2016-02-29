package org.vtsukur.algorithms.list;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static java.lang.invoke.MethodHandles.lookup;

/**
 * @author volodymyr.tsukur
 */
@State(Scope.Benchmark)
public class ListsBenchmark {

    private static final int MAX = 1_000_000;

    private final ArrayList<Integer> arrayList = new ArrayList<>();

    @Setup
    public void setup() {
        IntStream.range(0, MAX).forEach(arrayList::add);
    }

    @Benchmark
    public void test() {
        int j = 0;
        for (final ListIterator<Integer> i = arrayList.listIterator(); i.hasNext(); ) {
            final Integer value = i.next();
            if (j++ % 10 == 0) {
                i.remove();
                i.add(value);
            }
        }
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
                .warmupIterations(5)
                .measurementIterations(5)
                .build();
    }

    private static String thisClassName() {
        return lookup().lookupClass().getSimpleName();
    }

}
