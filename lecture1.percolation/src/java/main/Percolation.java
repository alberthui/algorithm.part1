import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
	private WeightedQuickUnionUF connectedSites;
	private boolean[][] site;
	private int size;
    private int top = 0;
    private int bottom;
    private int openedSite = 0;
	private static boolean BLOCKED = false;
	private static boolean OPENED = true;
	
	// create n-by-n grid, with all sites blocked
	public Percolation(int n)  {
		site = new boolean[n][n];
		connectedSites = new WeightedQuickUnionUF(n*n + 2);
		size = n;
		bottom = n * n + 1;
		
		for (int i=0; i<n; i++) 
			for (int j=0; j<n; j++)
				site[i][j] = BLOCKED;
	}
	
	private int xyTo1D(int row, int col) {
		return size * (row - 1) + col;
	}
	
	 // open site (row, col) if it is not open already
	public void open(int row, int col) {
		if (site[row-1][col-1] == BLOCKED) {
			site[row-1][col-1] = OPENED;
			openedSite++;
		}
		
        if (row == 1) {
        	connectedSites.union(xyTo1D(row, col), top);
        }
        if (row == size) {
        	connectedSites.union(xyTo1D(row, col), bottom);
        }

        if (col > 1 && isOpen(row, col - 1)) {
        	connectedSites.union(xyTo1D(row, col), xyTo1D(row, col - 1));
        }
        if (col < size && isOpen(row, col + 1)) {
        	connectedSites.union(xyTo1D(row, col), xyTo1D(row, col + 1));
        }
        if (row > 1 && isOpen(row - 1, col)) {
        	connectedSites.union(xyTo1D(row, col), xyTo1D(row - 1, col));
        }
        if (row < size && isOpen(row + 1, col)) {
        	connectedSites.union(xyTo1D(row, col), xyTo1D(row + 1, col));
        }
	}
	
	// is site (row, col) open?
	public boolean isOpen(int row, int col) {
		return site[row-1][col-1];
	}
	
	// is site (row, col) full?
	public boolean isFull(int row, int col) {
        if (0 < row && row <= size && 0 < col && col <= size) {
            return connectedSites.connected(top, xyTo1D(row , col));
        } else {
            throw new IndexOutOfBoundsException();
        }
	}
	
	// number of open sites
	public int numberOfOpenSites() {
		return openedSite; 
	}
	
	// does the system percolate?
	public boolean percolates() {
		return connectedSites.connected(top, bottom);
	}
	
	// test client (optional)
	public static void main(String[] args) {
		
	}
}
