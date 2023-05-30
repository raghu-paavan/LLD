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
            if(players.get(i).getPosition()== board.getCells().size())
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
            if(number + players.get(player_number-1).getPosition() <= board.getCells().size())
            {
                players.get(player_number-1).setPosition( players.get(player_number-1).getPosition() + number);


                //check for snake affect
                for(int i=0;i<board.getSnakes().size();i++)
                {
                    if(board.getSnakes().get(i).start.getNumber() == players.get(player_number-1).getPosition())
                    {
                        players.get(player_number-1).setPosition( board.getSnakes().get(i).end.getNumber());
                        System.out.println(player_number-1 +" is affected by the snake");
                        break;
                    }
                }


                //check for ladder affect
                for(int i=0;i<board.getLadders().size();i++)
                {
                    if(board.getLadders().get(i).getStart().getNumber() == players.get(player_number-1).getPosition())
                    {
                        players.get(player_number-1).setPosition( board.getLadders().get(i).getEnd().getNumber());
                        break;
                    }
                }

            }
        }
        Player p = winner();
        System.out.println("Winner of the game is "+ p.getName());
    }
}
