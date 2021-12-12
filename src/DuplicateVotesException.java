public class DuplicateVotesException extends Exception {
    private String multiVoteCandidate;

    public DuplicateVotesException(String name){
        this.multiVoteCandidate = name;
    }

    /**
     * getter for the candidate who caused the exception to be thrown
     * @return the name of the candidate
     */
    public String getMultiVoteCandidate(){
        return this.multiVoteCandidate;
    }
}
