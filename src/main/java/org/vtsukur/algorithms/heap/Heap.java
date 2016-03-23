package org.vtsukur.algorithms.heap;

/**
 * @author volodymyr.tsukur
 */
@SuppressWarnings("unchecked")
public final class Heap<T extends Comparable<T>> {

    private static final Object[] EMPTY_ARRAY = new Object[0];

    public static final int CAPACITY_EXTENSION_BUFFER = 10;

    private Object[] array = EMPTY_ARRAY;

    private int size;

    public void add(final T el) {
        ensureSize(size + 1);
        array[size] = el;
        int i = size;
        if (i > 0) {
            int parentIndex = parentIndex(i);
            while (at(parentIndex).compareTo(el) > 0) {
                swap(parentIndex, i);
                i = parentIndex;
            }
        }
        size++;
    }

    private void ensureSize(final int i) {
        if (array.length < i) {
            final Object[] cpy = newArray(i);
            if (array.length > 0) {
                System.arraycopy(array, 0, cpy, 0, array.length);
            }
            array = cpy;
        }
    }

    private Object[] newArray(final int i) {
        return new Object[(i / CAPACITY_EXTENSION_BUFFER + 1) * CAPACITY_EXTENSION_BUFFER];
    }

    public T popMinimum() {
        if (size == 0) {
            throw new RuntimeException("Heap is empty");
        }
        final T minimum = at(0);

        int i = 0;
        while (i < size - 1) {
            final int left = leftIndex(i);
            final int right = rightIndex(i);
            if (left > size - 1 || right > size - 1) {
                break;
            }
            if (at(left).compareTo(at(right)) < 0) {
                array[i] = array[left];
                i = left;
            } else {
                array[i] = array[right];
                i = right;
            }
        }
        swap(i, size - 1);

        array[--size] = null;

        return minimum;
    }

    private T at(final int i) {
        return (T) array[i];
    }

    private int leftIndex(final int i) {
        return i * 2 + 1;
    }

    private int rightIndex(final int i) {
        return (i + 1) * 2;
    }

    private int parentIndex(final int i) {
        return (i == 0) ? -1 : ((i - 1) / 2);
    }

    private void swap(final int i, final int j) {
        final Object temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
