package snake_ladder;
import java.util.Random;
public class Dice {
    public int getNumber_of_faces() {
        return number_of_faces;
    }

    public void setNumber_of_faces(int number_of_faces) {
        this.number_of_faces = number_of_faces;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    private int number_of_faces;
    private Random random;
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
