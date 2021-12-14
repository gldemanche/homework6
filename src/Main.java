public class Main {
    public static void main(String[] args) throws CandidateExistsException {

        ElectionData data = new ElectionData();
        VotingMachine voteDay = new VotingMachine(data);
        voteDay.addWriteIn("Julez");
        voteDay.addWriteIn("Me");
        voteDay.addWriteIn("Leo");

        voteDay.screen();

        System.out.println(data.findWinnerMostPoints());
    }
}
