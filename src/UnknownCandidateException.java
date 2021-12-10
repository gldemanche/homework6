public class UnknownCandidateException extends Exception {
    private String unknownCandidate;

    public UnknownCandidateException(String name){
        this.unknownCandidate = name;
    }

    //getter
    public String getUnknownCandidate(){
        return this.unknownCandidate;
    }

}
