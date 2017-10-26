import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by albert on 22/5/2017.
 */
public class Deque<Item> implements Iterable<Item>  {

    private Node<Item> startNode = null;
    private Node<Item> lastNode = null;
    private int size = 0;

    // construct an empty deque
    public Deque() {
    }

    // is the deque empty?
    public boolean isEmpty() {
        return (startNode == null);
    }

    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null)
            throw new NullPointerException();

        if (startNode == null) {
            startNode = new Node<>();
            lastNode = startNode;
        } else {
            Node<Item> temp = startNode;
            startNode = new Node<>();
            startNode.next = temp;
            temp.last = startNode;
        }
        startNode.item = item;
        size++;
    }

    // add the item to the end
    public void addLast(Item item) {
        if (item == null)
            throw new NullPointerException();

        if (lastNode == null) {
            lastNode = new Node<>();
            startNode = lastNode;
        } else {
            Node<Item> temp = lastNode;
            lastNode = new Node<>();
            lastNode.last = temp;
            temp.next = lastNode;
        }
        lastNode.item = item;
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        Item result;
        if (startNode != null) {
            result = startNode.item;
            if (startNode != lastNode) {
                startNode.next.last = null;
                startNode = startNode.next;
            } else {
                startNode = null;
                lastNode = null;
            }
        } else {
            throw new NoSuchElementException();
        }
        size--;
        return result;
    }

    public Item removeLast() {
        Item result;
        if (lastNode != null) {
            result = lastNode.item;
            if (startNode != lastNode) {
                lastNode.last.next = null;
                lastNode = lastNode.last;
            } else {
                startNode = null;
                lastNode = null;
            }
        } else {
            throw new NoSuchElementException();
        }
        size--;
        return result;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private void status() {
        Node<Item> current = startNode;
        while (current != null) {
            System.out.print("[" + current.item + "] ");
            current = current.next;
        }
        System.out.println("size: " + size());
    }

    public static void main(String[] args) {
        Deque<String> deque = new Deque<>();
        String s1 = "1";
        String s2 = "2";
        String s3 = "3";
        String s4 = "4";
        String s5 = "5";

        boolean checking = true;

        if (!deque.isEmpty())
            checking = false;

        deque.addFirst(s1);
        deque.status();
        if (deque.isEmpty())
            checking = false;

        if (deque.size() != 1)
            checking = false;

        deque.addLast(s2);
        deque.status();

        if (deque.isEmpty())
            checking = false;

        if (deque.size() != 2)
            checking = false;

        deque.addFirst(s3);
        deque.status();

        deque.addFirst(s4);
        deque.status();

        deque.addLast(s5);
        deque.status();

        if (deque.size() != 5)
            checking = false;

        System.out.println(deque.removeFirst());
        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());
        System.out.println(deque.removeFirst());
        System.out.println(deque.removeFirst());
        deque.status();

        if (deque.size() != 0)
            checking = false;

        System.out.println(checking);
    }

    private class Node<Item> {
        private Item item = null;
        private Node<Item> next = null;
        private Node<Item> last = null;
    }

    private class ListIterator implements Iterator<Item>
    {
        private Node<Item> current = startNode;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (current == null)
                throw new NoSuchElementException();
            Item result = current.item;
            current = current.next;
            return result;
        }
    }
}
