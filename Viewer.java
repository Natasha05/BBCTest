import java.util.Random;

public class Viewer{

    public int[] vote;

    /**
     * constructor of Viewer
     */
    public Viewer(Random rand, int candidates){
        int temp = randomNumberRange(rand,1,10);
        vote = new int[temp];

        // number of votes set randomly
        for(int i = 0; i<temp;++i){

        	// the candidate vote set randomly
            vote[i] = randomNumberRange(rand,1,candidates);
        }
    }

    public Viewer(Random rand, int numberofvotes, int candidates){
        vote = new int[numberofvotes];

        // number of votes set randomly
        for(int i = 0; i<numberofvotes;++i){

            // the candidate vote set randomly
            vote[i] = randomNumberRange(rand,1,candidates);
        }
    }

    private int randomNumberRange(Random random, int min, int max){
        int randomNum = random.nextInt((max - min) + 1) + min;
        return randomNum;
    }

}
