public class CandidateExistsException extends Exception{
    private String existsCandidate;
    public CandidateExistsException(String name){
        this.existsCandidate = name;
    }

    /**
     * getter for the candidate who caused the exception to be thrown
     * @return the name of the candidate
     */
    public String getCanidateThatAlreadyExists(){
        return this.existsCandidate;
    }
}
