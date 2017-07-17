public class MainClass{

    public static void main (String [] args){

        CountMeUp countMeUp = new CountMeUp(5);

        //never forget to initialise the user list!
        countMeUp.generateUsers(countMeUp.rand,3000000,3000000);

        countMeUp.printPartition();
        countMeUp.printNumberOfVotesPerCandidate();

        /*
        //the non-random constructor does not require an additional method to populate the list
        int[] distribution = new int[5];
        distribution[0] = 5;
        distribution[1] = 10;
        distribution[2] = 20;
        distribution[3] = 25;
        distribution[4] = 40;
        for(int i = 0; i<distribution.length; ++i){
            System.out.println(distribution[i]);
        }
        CountMeUp countMeUp = new CountMeUp(10000000,distribution,5);
        countMeUp.printPartition();
        countMeUp.printNumberOfVotesPerCandidate();*/
    }

}