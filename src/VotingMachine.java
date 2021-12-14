import java.util.Scanner;

/**
 *  Voting Machine Class
 *  @author Gabe Demanche & Chris Chow
 */
public class VotingMachine {
    private Scanner keyboard = new Scanner(System.in);
    private ElectionData election;

    public VotingMachine(ElectionData election){
        this.election = election;
    }


    /**
     * allows the user to write in a candidate
     * @param name the name of the candidate to be written in
     * @throws CandidateExistsException if the candidate is already on the ballot
     */
    public void addWriteIn(String name) throws CandidateExistsException {
        election.addCandidate(name);
        System.out.println("Candidate was added successfully");
    }


    /**
     * helper function to see if the user wants to add the candidate that threw and exception
     * @param x the unknown candidate exception thrown
     */
    public void doYouWantToAdd(UnknownCandidateException x) {
        String answer = keyboard.next();
        if (answer.toLowerCase().equals("y")) {
            try {
                addWriteIn(x.getUnknownCandidate());
            } catch (CandidateExistsException r) {
                System.out.println("Candidate already" + r.getCanidateThatAlreadyExists() + " exists");
            }
        }
        screen();
    }

    /**
     * Helper function to process votes and catch possible exceptions
     * @param firstCandidate the first choice vote
     * @param secondCandidate the second choice vote
     * @param thirdCandidate the third choice vote
     */
    public void helperProcessVote(String firstCandidate, String secondCandidate, String thirdCandidate) {
        try {
            election.processVote(firstCandidate, secondCandidate, thirdCandidate);

            System.out.println("You voted for " + firstCandidate);
            System.out.println("You voted for " + secondCandidate);
            System.out.println("You voted for " + thirdCandidate);
        } catch (UnknownCandidateException t) {
            System.out.println("Unknown Canidate");
            System.out.println("Would you like to add " + t.getUnknownCandidate() + " as a candidate?");
            doYouWantToAdd(t);
        } catch (DuplicateVotesException e) {
            System.out.println("You can not vot for " + e.getMultiVoteCandidate() + " twice.");
            screen();

        }
    }

    /**
     *Allows the user to vote for candidates by promoting them on the screen to enter their candidate choices
     */
    public void screen(){
            this.election.printBallot();
            System.out.println("Who do you want to vote for first");
            String firstCandidate = keyboard.next();
            System.out.println("Who do you want to vote for second");
            String secondCandidate = keyboard.next();
            System.out.println("Who do you want to vote for third");
            String thirdCandidate = keyboard.next();
            helperProcessVote(firstCandidate, secondCandidate, thirdCandidate);
    }


    /**
     * main to test and run program
     * @param args
     * @throws CandidateExistsException if add write in throws
     */
    public static void main(String[] args) throws CandidateExistsException {
        ElectionData data = new ElectionData();
        VotingMachine voteDay = new VotingMachine(data);
        voteDay.addWriteIn("Julez");
        voteDay.addWriteIn("Me");
        voteDay.addWriteIn("Leo");

        voteDay.screen();
    }

}

