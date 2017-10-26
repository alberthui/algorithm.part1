import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by albert on 29/5/2017.
 */
public class Permutation {
    public static void main(String[] args) {
        int totalNo = Integer.parseInt(args[0]);
        String input;
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            input = in.nextLine();  // Scanner has functions to read ints, longs, strings, chars, etc.
        }

        StringTokenizer st = new StringTokenizer(input);
        RandomizedQueue<String> queue = new RandomizedQueue<>();
        while (st.hasMoreTokens()) {
            queue.enqueue(st.nextToken());
        }

        for (int i = 0; i < totalNo; i++) {
            System.out.println(queue.dequeue());
        }

    }
}
