/**
 * EUnknown Candidate exception
 * @author Gabe Demanche & Chris Chow
 */
public class UnknownCandidateException extends Exception {
    private String unknownCandidate;

    public UnknownCandidateException(String name){
        this.unknownCandidate = name;
    }

    /**
     * getter for the candidate who caused the exception to be thrown
     * @return the name of the candidate
     */
    public String getUnknownCandidate(){
        return this.unknownCandidate;
    }

}
