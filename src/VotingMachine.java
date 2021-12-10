import com.sun.javafx.geom.Curve;

import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class VotingMachine {
    private Scanner keyboard = new Scanner(System.in);
    private ElectionData election;

    public VotingMachine(ElectionData election){
        this.election = election;
        System.out.println("Candidate was added successfully");
    }


    public void addWriteIn(String name) throws CandidateExistsException {
        election.addCandidate(name);
    }

    public void screen() {
            this.election.printBallot();
            System.out.println("Who do you want to vote for first");
            String firstCandidate = keyboard.next();
            System.out.println("Who do you want to vote for second");
            String secondCandidate = keyboard.next();
            System.out.println("Who do you want to vote for third");
            String thirdCandidate = keyboard.next();

            try {
                election.processVote(firstCandidate, secondCandidate, thirdCandidate);

                System.out.println("You voted for " + firstCandidate);
                System.out.println("You voted for " + secondCandidate);
                System.out.println("You voted for " + thirdCandidate);
            } catch (UnknownCandidateException t) {
                System.out.println("Unknown Canidate");
                System.out.println("Would you like to add " + t.getUnknownCandidate() + " as a candidate?");
                String answer = keyboard.next();
                if (answer.toLowerCase().equals("y")) {
                    try {
                        addWriteIn(t.getUnknownCandidate());
                    } catch (CandidateExistsException r) {
                        System.out.println("Candidate already" + r.getCanidateThatAlreadyExists() +" exists");
                    }
                }
                screen();
            } catch (DuplicateVotesException e) {
                System.out.println("You can not vot for " + e.getMultiVoteCandidate() + " twice.");
                screen();
            }


    }
}
