import edu.princeton.cs.algs4.StdOut;
import sun.jvm.hotspot.opto.Block;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Board {
    private static final int SPACE = 0;
    private int[][] blocks;

    // construct a board from an n-by-n array of blocks
    // (where blocks[i][j] = block in row i, column j)
    public Board(int[][] blocks) {
        if (blocks == null
                || blocks.length == 0
                || blocks.length != blocks[0].length) {
            throw new IllegalArgumentException();
        }

        this.blocks = clone(blocks);
    }

    // board dimension n
    public int dimension() {
        return this.blocks.length;
    }

    // number of blocks out of place
    public int hamming() {
        //TODO
        return 0;
    }

    // sum of Manhattan distances between blocks and goal
    public int manhattan() {
        //TODO
        return 0;
    }

    // is this board the goal board?
    public boolean isGoal() {
        for (int i=0; i<blocks.length; i++) {
            for (int j=0; j<blocks[i].length; j++) {
                if (blocks[i][j] != (i+1) * 10 + (j+1)
                        && i != blocks.length-1
                        && j != blocks.length-1) {
                    return false;
                }
            }
        }
        return true;
    }

    // a board that is obtained by exchanging any pair of blocks
    public Board twin() {
        return null;
    }

    // does this board equal y?
    public boolean equals(Object y) {
        //TODO
        return false;
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        //get the space position
        int x = blocks.length;
        int y = blocks.length;
        List<Board> list = new ArrayList<>();

        for (int i=0; i<blocks.length; i++) {
            for (int j=0; j<blocks[i].length; j++) {
                if (blocks[i][j] == SPACE) {
                    x = i;
                    y = j;
                    break;
                }
            }
        }

        if (x + 1 < blocks.length) {
            int[][] newBlocks = clone(blocks);
            newBlocks[x][y] = newBlocks[x+1][y];
            newBlocks[x+1][y] = SPACE;
            list.add(new Board(newBlocks));
        }
        if (x - 1 >= 0) {
            int[][] newBlocks = clone(blocks);
            newBlocks[x][y] = newBlocks[x-1][y];
            newBlocks[x-1][y] = SPACE;
            list.add(new Board(newBlocks));
        }
        if (y + 1 < blocks.length) {
            int[][] newBlocks = clone(blocks);
            newBlocks[x][y] = newBlocks[x][y+1];
            newBlocks[x][y+1] = SPACE;
            list.add(new Board(newBlocks));
        }
        if (y - 1 >= 0) {
            int[][] newBlocks = clone(blocks);
            newBlocks[x][y] = newBlocks[x][y-1];
            newBlocks[x][y-1] = SPACE;
            list.add(new Board(newBlocks));
        }

        return list;
    }

    private int[][] clone(int[][] blocks) {
        int[][] result = new int[blocks.length][blocks.length];

        for (int i=0; i<blocks.length; i++) {
            for (int j=0; j<blocks[i].length; j++) {
                result[i][j] = blocks[i][j];
            }
        }
        return result;
    }

    // string representation of this board (in the output format specified below)
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(blocks.length + "\n");

        for (int[] i : blocks) {

            for (int j : i) {
                sb.append(" " + j);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    // unit tests (not graded)
    public static void main(String[] args) {
        int[][] blocks = {{1,3,2}, {4,0,6},{5,7,8}};

        Board n = new Board(blocks);
        StdOut.println(n);
        StdOut.println(n.neighbors());

        int[][] blocks2 = {{1,0,2}, {4,3,6},{5,7,8}};

        Board n2 = new Board(blocks2);
        StdOut.println(n2);
        StdOut.println(n2.neighbors());

    }
}
