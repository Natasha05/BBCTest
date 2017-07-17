import java.util.ArrayList;
import java.util.Random;

public class User{

    public int[] vote;

    /**
     * Class constructor of User
     */
    public User(Random rand, int candidates){
        int temp = randomNumberBetweenRange(rand,1,10);
        vote = new int[temp];

        // the number of votes is set randomly between 1 and 10;
        for(int i = 0; i<temp;++i){

            // the candidate for which the user is voting is randomly set as well.
            vote[i] = randomNumberBetweenRange(rand,1,candidates);
        }
    }

    public User(Random rand, int numberofvotes, int candidates){
        vote = new int[numberofvotes];

        // the number of votes is set randomly between 1 and 10;
        for(int i = 0; i<numberofvotes;++i){

            // the candidate for which the user is voting is randomly set as well.
            vote[i] = randomNumberBetweenRange(rand,1,candidates);
        }
    }

    private int randomNumberBetweenRange(Random random, int min, int max){
        int randomNum = random.nextInt((max - min) + 1) + min;
        return randomNum;
    }

}
