public class Votes {
    private int firstVotes;
    private int secondVotes;
    private int thirdVotes;
    public Votes(int firstVotes, int secondVotes, int thirdVotes){
        this.firstVotes = firstVotes;
        this.secondVotes = secondVotes;
        this.thirdVotes = thirdVotes;

    }

    public void addVote(int voteNum){
        if(voteNum == 1){
            this.firstVotes++;
        }
        else if(voteNum == 2){
            this.secondVotes++;
        }
        else if(voteNum == 3){
            this.thirdVotes++;
        }
    }

    //getter for votes by number
    public int countVotes(int voteNum){
        if(voteNum == 1){
            return firstVotes;
        }
        else if(voteNum == 2){
            return secondVotes;
        }
        else if(voteNum == 3){
            return thirdVotes;
        }
        else {
            return 0;
        }
    }

    //gets total points scaled
    public int totalVotePoints(){
        return((this.firstVotes * 3) +
                (this.secondVotes * 2) +
                (this.thirdVotes));
    }

}
