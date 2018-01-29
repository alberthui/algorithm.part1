public class Board {
    private int dimension;

    // construct a board from an n-by-n array of blocks
    // (where blocks[i][j] = block in row i, column j)
    public Board(int[][] blocks) {

    }

    // board dimension n
    public int dimension() {
        return this.dimension;
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
        //TODO
        return false;
    }

    // a board that is obtained by exchanging any pair of blocks
    public Board twin() {

    }

    // does this board equal y?
    public boolean equals(Object y) {
        //TODO
        return false;
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {

    }

    // string representation of this board (in the output format specified below)
    public String toString() {

    }

    // unit tests (not graded)
    public static void main(String[] args) {

    }
}