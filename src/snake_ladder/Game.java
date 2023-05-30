package snake_ladder;

import java.util.ArrayList;
import java.util.List;

public class Game {
    Board board;
    Dice dice;
    List<Player> players;
    int turn;
    Game(int number_of_players)
    {
        players = new ArrayList<>();
        for(int i=0;i<number_of_players;i++)
        {
            players.add(new Player(Integer.toString(i+1)));
        }
        board = new Board(100);
        dice =  new Dice(6);

        turn = 0;
    }

    public int getTurn()
    {
        int temp = turn ;
        turn++;
        turn= turn%(players.size());
        return temp+1;
    }

    public Player winner()
    {
        for(int i=0;i<players.size();i++)
        {
            if(players.get(i).position== board.cells.size())
                return players.get(i);
        }
        return null;
    }

    public void start()
    {
        while(winner()==null)
        {
            int player_number = getTurn();
            int number = dice.roll_dice();
            if(number + players.get(player_number-1).position <= board.cells.size())
            {
                players.get(player_number-1).position = players.get(player_number-1).position + number;

                //check for snake affect
                for(int i=0;i<board.snakes.size();i++)
                {
                    if(board.snakes.get(i).start.number == players.get(player_number-1).position)
                    {
                        players.get(player_number-1).position = board.snakes.get(i).end.number;
                        break;
                    }
                }


                //check for ladder affect
                for(int i=0;i<board.ladders.size();i++)
                {
                    if(board.ladders.get(i).start.number == players.get(player_number-1).position)
                    {
                        players.get(player_number-1).position = board.ladders.get(i).end.number;
                        break;
                    }
                }

            }
        }
        Player p = winner();
        System.out.println("Winner of the game is "+ p.name);
    }
}
