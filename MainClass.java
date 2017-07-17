public class MainClass{

    public static void main (String [] args){

        CountMeUp countMeUp = new CountMeUp(5);
        countMeUp.generateUsers(countMeUp.rand,3000000,3000000);

        countMeUp.printPartition();
        countMeUp.printNumberOfVotesPerCandidate();
    }

}