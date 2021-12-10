import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
class ElectionData {
    private HashMap<String, Votes> Ballot = new HashMap<String, Votes>();
    private Scanner keyboard = new Scanner(System.in);

    ElectionData() {
        this.Ballot.put("Gompei", new Votes(0,0,0));
        this.Ballot.put("Husky", new Votes(0,0,0));
    }

    public void printBallot() {
        System.out.println("The candidates are ");
        for (Map.Entry<String, Votes> entry : Ballot.entrySet()) {
            System.out.println(entry.getKey());
        }
    }

    /*
    public void screen() {
        this.printBallot();
        System.out.println("Who do you want to vote for first");
        String firstCandidate = keyboard.next();
        Ballot.get(firstCandidate).firstVotes++;
        System.out.println("You voted for " + firstCandidate);
        System.out.println("Who do you want to vote for second");
        String secondCandidate = keyboard.next();
        Ballot.get(secondCandidate).secondVotes++;
        System.out.println("You voted for " + secondCandidate);
        System.out.println("Who do you want to vote for third");
        String thirdCandidate = keyboard.next();
        Ballot.get(thirdCandidate).thirdVotes++;
        System.out.println("You voted for " + thirdCandidate);
    }
     */

    public void processVote(String firstVote, String secondVote, String thirdVote)
            throws DuplicateVotesException, UnknownCandidateException {
        if(!Ballot.containsKey(firstVote)) {
            throw new UnknownCandidateException(firstVote);
        }
        else if(firstVote.equals(secondVote)){
            throw new DuplicateVotesException(firstVote);
        }
        else{
            Ballot.get(firstVote).addVote(1);
        }

        if(!Ballot.containsKey(secondVote)) {
            throw new UnknownCandidateException(secondVote);
        }
        else if(secondVote.equals(thirdVote)){
            throw new DuplicateVotesException(secondVote);
        }
        else{
            Ballot.get(secondVote).addVote(2);
        }

        if(!Ballot.containsKey(thirdVote)){
            throw new UnknownCandidateException(thirdVote);
        }
        else if(firstVote.equals(thirdVote)){
            throw new DuplicateVotesException(thirdVote);
        }
        else{
            Ballot.get(thirdVote).addVote(3);
        }

    }

    public void addCandidate(String name) throws CandidateExistsException{
        if(Ballot.containsKey(name)){
            throw new CandidateExistsException(name);
        }
        else {
            this.Ballot.put(name, new Votes(0, 0, 0));
        }
    }

    public String findWinnerMostFirstVotes(){
        String firstWinner = "Runoff required";

        int totalVotes = 0;

        for(Map.Entry element : Ballot.entrySet()){
            Votes votes = (Votes)element.getValue();
            totalVotes =+ votes.countVotes(1);
        }

        for(Map.Entry element: Ballot.entrySet()){
            String name = (String)element.getKey();
            Votes vote = (Votes)element.getValue();

            if(vote.countVotes(1) >= .5* totalVotes){
                return name;
            }
        }
        return firstWinner;
    }

    public String findWinnerMostPoints(){
        String currentWinner = "";
        int currentWinningScore = 0;
        for(Map.Entry element: Ballot.entrySet()){
            String name = (String)element.getKey();
            Votes votes = (Votes)element.getValue();

            if(currentWinningScore <= votes.totalVotePoints()){
                 currentWinner = name;
            }
        }
        return currentWinner;
    }


}