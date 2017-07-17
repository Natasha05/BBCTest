import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class CountMeUp{

    // multi-threading field
    private static final ForkJoinPool threadPool = new ForkJoinPool();

    // essential fields
    private int candidates;

    // calculations from random user creation.
    private int totalvotes;
    private int[] candidateVotes;
    private int[] candidateVotesUpdated;

    // misc fields.
    public Random rand = new Random();

    /**
     * Class constructor which takes an input amount of candidates.
     * Initialises all collections without adding any element to them.
     * Call generateUsers to add generate users - may it be a fixed amount
     * (by setting min to the same value than max) or a random amount of users.
     * @param candidatesIn
     */
    public CountMeUp(int candidatesIn){

     totalvotes = 0;
     candidates = candidatesIn;
     candidateVotes = new int[candidates];
     candidateVotesUpdated = new int[candidates];
    }

    private int randomNumberBetweenRange(Random random, int min, int max){
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public void generateUsers( Random rand, int min, int max){
        // generates a random amount of users.
        //intialises allUsers, totalvotes and candidateVotes.

        int randomnumberofusers = randomNumberBetweenRange(rand,min,max);

        for(int i = 0; i < randomnumberofusers ; ++i){
            User user = new User(rand,candidates);
            totalvotes += user.vote.length;
            for(int j = 0; j < user.vote.length; ++j){
                ++candidateVotes[user.vote[j]-1];
                if(j<4){
                    ++candidateVotesUpdated[user.vote[j]-1];
                }
            }
        }
    }

    public void printPartition(){
        // prints percentages before removing non-valid votes.

        System.out.println("total votes: " + totalvotes);

        System.out.println("| candidate          | percentage |");
        for(int i = 0; i < candidateVotes.length ;++i){

            System.out.println(" | candidate-"+(i+1)+"         |" + ((double)candidateVotes[i]/(double)totalvotes)*100 + "|");
        }
        System.out.println();

    }

    public void printNumberOfVotesPerCandidate(){
        // updates and prints number of votes after removing non-valid votes.

        System.out.println("total votes: " + totalvotes);

        System.out.println("| candidate          |    count     |");
        for(int i = 0; i < candidateVotesUpdated.length ;++i){
            System.out.println(" | candidate-"+(i+1)+"         |" + candidateVotesUpdated[i] + "|");
        }
        System.out.println();
    }
}