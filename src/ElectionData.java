import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
class ElectionData {
    private HashMap<String, Votes> ballot = new HashMap<String, Votes>();
    private Scanner keyboard = new Scanner(System.in);

    ElectionData() {
    }

    /**
     * Prints out the candidates currently on the ballot
     */
    public void printBallot() {
        System.out.println("The candidates are ");
        for (Map.Entry<String, Votes> entry : ballot.entrySet()) {
            System.out.println(entry.getKey());
        }
    }

    /**
     * Processes a vote for a first, second, and third choice candidiate
     * @param firstVote the first choice candidate
     * @param secondVote the second choice candidate
     * @param thirdVote the third choice candidate
     * @throws DuplicateVotesException if any of the choices are the same
     * @throws UnknownCandidateException if any of the candidates are not on the ballot
     */
    public void processVote(String firstVote, String secondVote, String thirdVote)
            throws DuplicateVotesException, UnknownCandidateException {
        if(!ballot.containsKey(firstVote)) {
            throw new UnknownCandidateException(firstVote);
        }
        else if(firstVote.equals(secondVote)){
            throw new DuplicateVotesException(firstVote);
        }
        else{
            ballot.get(firstVote).addVote(1);
        }

        if(!ballot.containsKey(secondVote)) {
            throw new UnknownCandidateException(secondVote);
        }
        else if(secondVote.equals(thirdVote)){
            throw new DuplicateVotesException(secondVote);
        }
        else{
            ballot.get(secondVote).addVote(2);
        }

        if(!ballot.containsKey(thirdVote)){
            throw new UnknownCandidateException(thirdVote);
        }
        else if(firstVote.equals(thirdVote)){
            throw new DuplicateVotesException(thirdVote);
        }
        else{
            ballot.get(thirdVote).addVote(3);
        }

    }

    /**
     * @param name the candidate to be added to the ballot
     * @throws CandidateExistsException if the candidate already exists on the ballot
     */
    public void addCandidate(String name) throws CandidateExistsException{
        if(ballot.containsKey(name)){
            throw new CandidateExistsException(name);
        }
        else {
            this.ballot.put(name, new Votes(0, 0, 0));
        }
    }

    /**
     * Finds the candidate that had over 50% of the first choice votes, if any.
     * @return the candidate who had over 50% or "runoff required" if none won over 50%
     */
    public String findWinnerMostFirstVotes(){
        String firstWinner = "Runoff required";

        int totalVotes = 0;

        for(Map.Entry<String, Votes> element : ballot.entrySet()){
            Votes votes = element.getValue();
            totalVotes += votes.countVotes(1);
        }

        for(Map.Entry<String, Votes> element: ballot.entrySet()){
            String name = element.getKey();
            Votes vote = element.getValue();

            if(vote.countVotes(1) > .5* totalVotes){
                return name;
            }
        }
        return firstWinner;
    }

    /**
     * Finds the candidate with the most vote points from an election, 3 pts for each first choice vote,
     * 2 for each second choice vote, and 1 for each third choice vote
     * @return the name of the candidate who received the most points
     */
    public String findWinnerMostPoints(){
        String currentWinner = "";
        int currentWinningScore = 0;
        for(Map.Entry<String, Votes> element: ballot.entrySet()){
            String name = element.getKey();
            Votes votes = element.getValue();

            if(currentWinningScore <= votes.totalVotePoints()){
                 currentWinner = name;
                 currentWinningScore = votes.totalVotePoints();
            }
        }
        return currentWinner;
    }


}