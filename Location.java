package Assignment_1.peggame;

public class Location {
    private int row;
    private int col;
    
    public Location(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public String toString() {
        return "Location: ( " + row + "," + col + " )";
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Location)) {
            return false;
        }
        Location other = (Location) obj;
        return row == other.row && col == other.col;
    }
}
