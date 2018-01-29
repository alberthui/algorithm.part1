import edu.princeton.cs.algs4.StdOut;

public class Board {
    private int[][] blocks;

    // construct a board from an n-by-n array of blocks
    // (where blocks[i][j] = block in row i, column j)
    public Board(int[][] blocks) {
        if (blocks == null
                || blocks.length == 0
                || blocks.length != blocks[0].length) {
            throw new IllegalArgumentException();
        }

        this.blocks = new int[blocks.length][blocks.length];

        for (int i=0; i<blocks.length; i++) {
            for (int j=0; j<blocks[i].length; j++) {
                this.blocks[i][j] = blocks[i][j];
            }
        }
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
        return null;
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

    }
}
