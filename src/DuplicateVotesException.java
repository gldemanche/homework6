public class DuplicateVotesException extends Exception {
    private String multiVoteCandidate;

    public DuplicateVotesException(String name){
        this.multiVoteCandidate = name;
    }

    //getter
    public String getMultiVoteCandidate(){
        return this.multiVoteCandidate;
    }
}
