import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by albert on 23/5/2017.
 */
public class RandomizedQueue<Item> implements Iterable<Item>  {

    private Node<Item> startNode = null;
    private int size = 0;

    // construct an empty randomized queue
    public RandomizedQueue() {
    }

    // is the queue empty?
    public boolean isEmpty() {
        return (startNode == null);
    }

    // return the number of items on the queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null)
            throw new UnsupportedOperationException();

        Node<Item> newNode = new Node<>();
        newNode.item = item;

        if (startNode != null) {
            Random rand = new Random();
            int target = rand.nextInt(size());
            int currentPos = 0;

            Node<Item> node = startNode;
            while (currentPos != target) {
                node = node.next;
                currentPos++;
            }
            newNode.next = node.next;
            node.next = newNode;
        } else {
            startNode = newNode;
        }
        size++;
    }

    // remove and return a random item
    public Item dequeue() {
        if (startNode == null) {
            throw new NoSuchElementException();
        }

        Random rand = new Random();
        Item result;
        if (size() == 1) {
            result = startNode.item;
            startNode = null;
        } else {
            int target = rand.nextInt(size());

            if (target == 0) {
                result = startNode.item;
                startNode = startNode.next;
            } else {
                int currentPos = 0;
                Node<Item> lastNode = null;
                Node<Item> currentNode = startNode;
                while (currentPos != target) {
                    lastNode = currentNode;
                    currentNode = currentNode.next;
                    currentPos++;
                }
                lastNode.next = currentNode.next;
                result = currentNode.item;
            }
        }
        size--;
        return result;
    }

    // return (but do not remove) a random item
    public Item sample() {
        if (startNode == null) {
            throw new NoSuchElementException();
        }

        Random rand = new Random();
        int target = rand.nextInt(size());
        int currentPos = 0;
        Node<Item> currentNode = startNode;
        while (currentPos != target) {
            currentNode = currentNode.next;
            currentPos++;
        }
        return currentNode.item;
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new ListIterator(size);
    }

    private void status() {
        Node<Item> current = startNode;
        while (current != null) {
            System.out.print("[" + current.item + "] ");
            current = current.next;
        }
        System.out.println("size: " + size());
    }

    // unit testing (optional)
    public static void main(String[] args) {

        RandomizedQueue<String> queue = new RandomizedQueue<>();
        String s1 = "1";
        String s2 = "2";
        String s3 = "3";
        String s4 = "4";
        String s5 = "5";
        String s6 = "6";

        boolean checking = true;

        if (!queue.isEmpty())
            checking = false;

        if (queue.size() != 0)
            checking = false;

        queue.enqueue(s1);
        queue.enqueue(s2);
        queue.enqueue(s3);
        queue.enqueue(s4);
        queue.enqueue(s5);
        queue.enqueue(s6);

        queue.status();

        for (String s : queue) {
            System.out.println(s);
        }

        for (String s : queue) {
            System.out.println(s);
        }

        String d1 = queue.dequeue();
        String d2 = queue.dequeue();

        queue.status();

        System.out.println(checking);
        System.out.println("dequeue: " + d1 + " " + d2);
    }

    private class Node<Item> {
        private Item item = null;
        private Node<Item> next = null;
    }

    private class ListIterator implements Iterator<Item>
    {
        private List<Integer> remaining;
        Random rand = new Random();

        public ListIterator(int total) {
            remaining = new ArrayList<>();
            for (int i = 0; i < total; i++) {
                remaining.add(i);
            }
        }

        public boolean hasNext() {
            return !remaining.isEmpty();
        }

        public void remove() {
            throw new NoSuchElementException();
        }

        public Item next() {
            if (remaining.isEmpty())
                throw new NoSuchElementException();

            int pos = rand.nextInt(remaining.size());
            Node<Item> node = startNode;
            int current = 0;
            while (current != remaining.get(pos)) {
                node = node.next;
                current++;
            }
            remaining.remove(pos);
            return node.item;
        }
    }
}
