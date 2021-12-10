import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
class ElectionData {
    private HashMap<String, Votes> ballot = new HashMap<String, Votes>();
    private Scanner keyboard = new Scanner(System.in);

    ElectionData() {
        this.ballot.put("Gompei", new Votes(0,0,0));
        this.ballot.put("Husky", new Votes(0,0,0));
        this.ballot.put("Julez", new Votes(0, 0, 0));

    }




    public void printBallot() {
        System.out.println("The candidates are ");
        for (Map.Entry<String, Votes> entry : ballot.entrySet()) {
            System.out.println(entry.getKey());
        }
    }

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

    public void addCandidate(String name) throws CandidateExistsException{
        if(ballot.containsKey(name)){
            throw new CandidateExistsException(name);
        }
        else {
            this.ballot.put(name, new Votes(0, 0, 0));
        }
    }

    public String findWinnerMostFirstVotes(){
        String firstWinner = "Runoff required";

        int totalVotes = 0;

        for(Map.Entry<String, Votes> element : ballot.entrySet()){
            Votes votes = element.getValue();
            totalVotes =+ votes.countVotes(1);
        }

        for(Map.Entry<String, Votes> element: ballot.entrySet()){
            String name = element.getKey();
            Votes vote = element.getValue();

            if(vote.countVotes(1) >= .5* totalVotes){
                return name;
            }
        }
        return firstWinner;
    }

    public String findWinnerMostPoints(){
        String currentWinner = "";
        int currentWinningScore = 0;
        for(Map.Entry<String, Votes> element: ballot.entrySet()){
            String name = element.getKey();
            Votes votes = element.getValue();

            if(currentWinningScore <= votes.totalVotePoints()){
                 currentWinner = name;
            }
        }
        return currentWinner;
    }


}