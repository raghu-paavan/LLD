package snake_ladder;
import java.util.*;
public class Board {
    public List<Snake> getSnakes() {
        return snakes;
    }

    public void setSnakes(List<Snake> snakes) {
        this.snakes = snakes;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public void setLadders(List<Ladder> ladders) {
        this.ladders = ladders;
    }

    public List<Cell> getCells() {
        return cells;
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }

    private List<Snake> snakes;
    private List<Ladder> ladders;
    private List<Cell> cells;
    public Board(int number_of_cells)
    {
        cells = new ArrayList<>();
        snakes = new ArrayList<>();
        ladders = new ArrayList<>();
        for(int i=1;i<=number_of_cells;i++)
        {
            cells.add(new Cell(i));
        }

        snakes.add(new Snake( cells.get(12), cells.get(3)));
        ladders.add(new Ladder( cells.get(4), cells.get(11)));
    }
}
