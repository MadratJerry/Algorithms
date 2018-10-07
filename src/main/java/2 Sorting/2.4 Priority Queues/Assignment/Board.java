import java.util.LinkedList;

public class Board {
    private int[][] blocks;

    public Board(int[][] blocks) {
        this.blocks = blocks.clone();
        for (int i = 0; i < blocks.length; i++)
            this.blocks[i] = blocks[i].clone();
    }

    public int dimension() {
        return blocks.length;
    }

    public int hamming() {
        int count = -1;
        for (int i = 0; i < dimension(); i++)
            for (int j = 0; j < dimension(); j++)
                if (i * dimension() + j + 1 != blocks[i][j]) count++;
        return count;
    }

    public int manhattan() {
        int sum = 0;
        for (int i = 0; i < dimension(); i++)
            for (int j = 0; j < dimension(); j++)
                sum += blocks[i][j] == 0 ? 0 :
                        Math.abs(i - (blocks[i][j] - 1) / dimension()) +
                                Math.abs(j - (blocks[i][j] - 1) % dimension());
        return sum;
    }

    public boolean isGoal() {
        for (int i = 0; i < dimension(); i++)
            for (int j = 0; j < dimension(); j++)
                if (blocks[i][j] != 0 && blocks[i][j] != i * dimension() + j + 1) return false;
        return true;
    }

    public Board twin() {
        for (int i = 0; i < dimension(); i++)
            for (int j = 0; j < dimension() - 1; j++)
                if (blocks[i][j] > 0 && blocks[i][j + 1] > 0)
                    return swap(i, j, i, j + 1);
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Board) || ((Board) obj).blocks.length != blocks.length) return false;

        for (int i = 0; i < dimension(); i++)
            for (int j = 0; j < dimension(); j++)
                if (blocks[i][j] != ((Board) obj).blocks[i][j]) return false;

        return true;
    }

    public Iterable<Board> neighbors() {
        LinkedList<Board> boards = new LinkedList<>();

        int row = 0, column = 0;
        for (int i = 0; i < dimension(); i++)
            for (int j = 0; j < dimension(); j++)
                if (blocks[i][j] == 0) {
                    row = i;
                    column = j;
                    break;
                }

        if (row > 0) boards.add(swap(row, column, row - 1, column));
        if (row < dimension() - 1) boards.add(swap(row, column, row + 1, column));
        if (column > 0) boards.add(swap(row, column, row, column - 1));
        if (column < dimension() - 1) boards.add(swap(row, column, row, column + 1));

        return boards;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        str.append(dimension()).append("\n");
        for (int i = 0; i < dimension(); i++) {
            for (int j = 0; j < dimension(); j++)
                str.append(String.format("%2d ", blocks[i][j]));
            str.append("\n");
        }

        return str.toString();
    }

    private Board swap(int r1, int c1, int r2, int c2) {
        Board newBoard = new Board(blocks);

        int temp = newBoard.blocks[r1][c1];
        newBoard.blocks[r1][c1] = newBoard.blocks[r2][c2];
        newBoard.blocks[r2][c2] = temp;

        return newBoard;
    }
}
