package deque;

public class ArrayDeque<Item> {
    private Item[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (Item[]) new Object[8];
        size = 0;
        nextFirst = 3;
        nextLast = 4;
    }

    public ArrayDeque(Item x) {
        items[3] = x;
        nextFirst = 2;
        nextLast = 4;
        size = 1;
    }

    public void addFirst(Item x) {
        items[nextFirst] = x;
        nextFirst -= 1;
        size += 1;
        if (nextFirst < 0) {
            resize(size * 2);
        }
    }

    private void resize(int c) {
        Item[] newArray = (Item[]) new Object[c];
        int startPos = Math.abs(c - size) / 2;
        System.arraycopy(items, nextFirst + 1, newArray, startPos, size);
        items = newArray;
        nextFirst = startPos - 1;
        nextLast = startPos + size;
    }
    
    public Item get(int index) {
        if (index < 0 | index >= size) {
            return null;
        }
        int indexPos = nextFirst + 1 + index;
        return items[indexPos];
    }

    public Item removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Item firstToRomove = items[nextFirst + 1];
        items[nextFirst + 1] = null;
        nextFirst += 1;
        size -= 1;
        shrink();
        return firstToRomove;
    }

    public Item removeLast() {
        if(isEmpty()) {
            return null;
        }
        nextLast -= 1;
        Item lastToRemove = items[nextLast];
        items[nextLast] = null;
        size -= 1;
        shrink();
        return lastToRemove;
    }

    private void shrink() {
        if ((size < items.length / 4) && (size > 4)) {
            resize(items.length / 4);
        }
    }
    private boolean isEmpty() {
        if (nextFirst + 1 == nextLast) {
            return true;
        }
        return false;
    }
    public void printDeque() {
        System.out.println();
    }
}
