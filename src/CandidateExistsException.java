public class CandidateExistsException extends Exception{
    private String existsCandidate;
    public CandidateExistsException(String name){
        this.existsCandidate = name;
    }

    //getter

    public String getCanidateThatAlreadyExists(){
        return this.existsCandidate;
    }
}
