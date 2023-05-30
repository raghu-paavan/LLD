package snake_ladder;
import java.util.*;
public class Board {
    List<Snake> snakes;
    List<Ladder> ladders;
    List<Cell> cells;
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
