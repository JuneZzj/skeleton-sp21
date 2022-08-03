package deque;

import jh61b.junit.In;

public class LinkedListDeque <Item> {

    private class IntNode {
        public Item item;
        public IntNode next;
        public IntNode prev;

        public IntNode(IntNode p, Item i, IntNode n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    private IntNode sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new IntNode(null, null, null);
        size = 0;
    }

    public LinkedListDeque(Item x) {
        sentinel = new IntNode(null, null, null);
        sentinel.next = new IntNode(sentinel, x, sentinel);
        sentinel.prev = sentinel.next;
        size = 1;
    }

    public void addFirst(Item x) {
        sentinel.next = new IntNode(sentinel, x, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    public void addLast(Item x) {
        sentinel.prev = new IntNode(sentinel.prev, x, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size += 1;
    }

    public Item get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        IntNode curr = sentinel.next;
        for (int i = 1; i < index; i++) {
            curr = curr.next;
        }
        return curr.next.item;
    }

    public int size() {
        return size;
    }

    public Item getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return getRecursiveHelper(index, 1, sentinel.next);
    }

    private Item getRecursiveHelper(int index, int curr_index, IntNode currNode) {
        if (curr_index == index) {
            return currNode.item;
        }
        return getRecursiveHelper(index, curr_index + 1, currNode.next);
    }

}
