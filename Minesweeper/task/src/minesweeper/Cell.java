package minesweeper;

public class Cell {
    private boolean explored = false;
    private boolean mine = false;
    private int minesAround = 0;
    private boolean marked = false;

    public boolean isExplored() {
        return explored;
    }

    public void setExplored() {
        this.explored = true;
    }

    public boolean isMine() {
        return mine;
    }

    public void setMine(boolean mine) {
        this.mine = mine;
    }

    public int getMinesAround() {
        return minesAround;
    }

    public void setMinesAround(int minesAround) {
        this.minesAround = minesAround;
    }

    public boolean isMarked() {
        return marked;
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }
}
