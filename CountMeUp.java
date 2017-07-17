import java.util.Random;

public class CountMeUp{

    //Number of candidates 
    private int candidates;

    // Variables for vote calculation
    private int totalvotes;
    private int[] candidateVotes;
    private int[] candidateVotesUpdated;
    private static final int voteAllowed = 3;

    // Random number generator
    public Random rand = new Random();

    /**
     * Class constructor
     * Input - number of candidates.
     * Initializes all private fields 
     * @param candidatesNumber
     */
    public CountMeUp(int candidatesNumber){

     totalvotes = 0;
     candidates = candidatesNumber;
     candidateVotes = new int[candidates];
     candidateVotesUpdated = new int[candidates];
    }

    private int randomNumberBetweenRange(Random random, int min, int max){
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public void generateUsers( Random rand, int min, int max){
        // generates number of viewers.
        int numberOfViewers = randomNumberBetweenRange(rand,min,max);

        for(int i = 0; i < numberOfViewers ; ++i){
        	Viewer viewer = new Viewer(rand,candidates);
            totalvotes += viewer.vote.length;
            for(int j = 0; j < viewer.vote.length; ++j){
                ++candidateVotes[viewer.vote[j]-1];
                if(j <= voteAllowed){
                    ++candidateVotesUpdated[viewer.vote[j]-1];
                }
            }
        }
    }

    public void printPartition(){
        System.out.println("total votes: " + totalvotes);

        System.out.println("| candidate          | percentage |");
        for(int i = 0; i < candidateVotes.length ;++i){

            System.out.println(" | candidate-"+(i+1)+"         |" + ((double)candidateVotes[i]/(double)totalvotes)*100 + "|");
        }
        System.out.println();

    }

    public void printNumberOfVotesPerCandidate(){
        // update and print number of votes 
        System.out.println("total votes: " + totalvotes);

        System.out.println("| candidate          |    count     |");
        for(int i = 0; i < candidateVotesUpdated.length ;++i){
            System.out.println(" | candidate-"+(i+1)+"         |" + candidateVotesUpdated[i] + "|");
        }
        System.out.println();
    }
}