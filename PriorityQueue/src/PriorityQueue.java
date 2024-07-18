import java.util.NoSuchElementException;

public class PriorityQueue<E extends Comparable<E>> {
    private E[] items;
    private int size;


    public PriorityQueue() {
        size = 0;
        items = (E[]) new Comparable[4];
    }

    private boolean lessThan(int x, int y) {
        return items[x].compareTo(items[y]) < 0;
    }

    private void exchange(int x, int y) {
        E tmp = items[x];
        items[x] = items[y];
        items[y] = tmp;
    }

    private void resize(int newSize) {
        E[] tmp = (E[]) new Comparable[newSize];
        for (int i = 1; i <= size; i++) {
            tmp[i] = items[i];
        }
        items = tmp;
    }

    private void swim(int idx) {
        while (idx > 1 && lessThan(idx / 2, idx)) { /* idx/2 is the parent of idx in the heap */
            exchange(idx, idx / 2);
            idx = idx / 2;
        }
    }

    private void sink(int idx) {
        while (idx * 2 <= size) { /* while this node has at least one child (2*idx left child, 2*idx+1 right child) */
            int max = 2 * idx;
            if (2 * idx + 1 <= size && lessThan(2 * idx, 2 * idx + 1)) {
                max = 2 * idx + 1;
            }
            if (!lessThan(idx, max)) {
                break;
            }
            exchange(idx, max);
            idx = max;
        }
    }

    public void insert(E item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }

        if (size == items.length - 1) {
            resize(items.length * 2);
        }

        items[++size] = item;
        swim(size);
    }

    public E pop() {
        if (isEmpty()) throw new NoSuchElementException();

        E item = items[1];
        exchange(1, size);
        items[size] = null; // avoid memory loitering
        size--;
        sink(1);

        if (size > 4 && size == (items.length-1) / 4) {
            resize(items.length / 2);
        }

        return item;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
}
