package snake_ladder;
import java.util.Random;
public class Dice {
    public int number_of_faces;
    Random random;
    public Dice(int number_of_faces)
    {
        this.number_of_faces = number_of_faces;
        random = new Random();
    }
    public int roll_dice()
    {
        return random.nextInt(6) + 1;
    }
}
