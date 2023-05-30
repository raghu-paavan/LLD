package snake_ladder;

public class Snake {


    final Cell start;
    final Cell end;

    public Cell getStart() {
        return start;
    }

    public Cell getEnd() {
        return end;
    }

    public Snake(Cell start, Cell end)
    {
        this.start = start;
        this.end = end;
    }


}
