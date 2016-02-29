package org.vtsukur.algorithms.list;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static java.lang.invoke.MethodHandles.lookup;

/**
 * @author volodymyr.tsukur
 */
@State(Scope.Benchmark)
public class ListsBenchmark {

    private static final int MAX = 100_000;

    private final ArrayList<Integer> arrayList = new ArrayList<>();

    private final LinkedList<Integer> linkedList = new LinkedList<>();

    @Setup
    public void setup() {
        fillUp(arrayList);
        fillUp(linkedList);
    }

    private static void fillUp(final List<Integer> list) {
        IntStream.range(0, MAX).forEach(list::add);
    }

    @Benchmark
    public void benchmarkArrayList() {
        iterateAddRemove(arrayList);
    }

    @Benchmark
    public void benchmarkLinkedList() {
        iterateAddRemove(linkedList);
    }

    private static void iterateAddRemove(final List<Integer> list) {
        int j = 0;
        for (final ListIterator<Integer> i = list.listIterator(); i.hasNext(); ) {
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
                .warmupIterations(20)
                .measurementIterations(20)
                .build();
    }

    private static String thisClassName() {
        return lookup().lookupClass().getSimpleName();
    }

}
