package Assignment_1.peggame;

public class Move {
    private Location from;
    private Location to;

    public Move(Location from, Location to) {
        this.from = from;
        this.to = to;
    }

    public Location getFrom() {
        return from;
    }

    public Location getTo() {
        return to;
    }

    @Override
    public String toString() {
        return "Peg Moved from " + from + " to " + to;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Move)) {
            return false;
        }
        Move other = (Move) o;
        return from.equals(other.from) && to.equals(other.to);
    }
}
