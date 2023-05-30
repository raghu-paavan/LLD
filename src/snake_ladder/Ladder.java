package snake_ladder;

public class Ladder {
    public Cell getStart() {
        return start;
    }

    public Cell getEnd() {
        return end;
    }

    private final Cell start;
    private final Cell end;
    public Ladder(Cell start, Cell end)
    {
        this.start = start;
        this.end = end;
    }
}
