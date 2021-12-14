/**
 * Votes Class
 * @author Gabe Demanche & Chris Chow
 */
public class Votes {
    private int firstVotes;
    private int secondVotes;
    private int thirdVotes;
    public Votes(int firstVotes, int secondVotes, int thirdVotes){
        this.firstVotes = firstVotes;
        this.secondVotes = secondVotes;
        this.thirdVotes = thirdVotes;

    }

    /**
     * setter for adding votes
     * @param voteNum either firstVote (1), secondVote (2), or thirdVote (3)
     */
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

    /**
     * getter for counting votes
     * @param voteNum either firstVote (1), secondVote (2), or thirdVote (3)
     * @return the number of votes received for the given vote number
     */
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

    /**
     * totals the points received with 3 for firstVotes, 2 for secondVotes, and 1 for third Votes
     * @return the number of points received
     */
    public int totalVotePoints(){
        return((this.firstVotes * 3) +
                (this.secondVotes * 2) +
                (this.thirdVotes));
    }

}
