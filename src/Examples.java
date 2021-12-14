import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Examples Class
 * @author Gabe Demanche and Chris Chow
 */
public class Examples {
    ElectionData Election1 () {

        ElectionData ED1 = new ElectionData();

        // put candidates on the ballot
        try {
            ED1.addCandidate("gompei");
            ED1.addCandidate("husky");
            ED1.addCandidate("ziggy");
        } catch (Exception e) {}
        // cast votes
        try {
            ED1.processVote("gompei", "husky", "ziggy");
            ED1.processVote("ziggy", "gompei", "husky");
            ED1.processVote("husky", "ziggy", "gompei");

        } catch (Exception e) {}
        return(ED1);
    }
    ElectionData Election2 () {

        ElectionData ED2 = new ElectionData();

        // put candidates on the ballot
        try {
            ED2.addCandidate("gompei");
            ED2.addCandidate("husky");
            ED2.addCandidate("ziggy");
        } catch (Exception e) {}
        // cast votes
        try {
            ED2.processVote("gompei", "husky", "ziggy");
            ED2.processVote("ziggy", "gompei", "husky");
            ED2.processVote("husky", "ziggy", "gompei");
            ED2.processVote("husky", "ziggy", "gompei");

        } catch (Exception e) {}
        return(ED2);
    }
    ElectionData Election3 () {

        ElectionData ED3 = new ElectionData();

        // put candidates on the ballot
        try {

            ED3.addCandidate("husky");
            ED3.addCandidate("ziggy");
            ED3.addCandidate("gompei");

        } catch (Exception e) {}
        // cast votes
        try {
            ED3.processVote("ziggy", "husky", "gompei");
            ED3.processVote("husky", "ziggy", "gompei");
            ED3.processVote("husky", "ziggy", "gompei");
            ED3.processVote("husky", "ziggy", "gompei");

        } catch (Exception e) {}
        return(ED3);
    }
    ElectionData Election4 () {

        ElectionData ED4 = new ElectionData();

        // put candidates on the ballot
        try {
            ED4.addCandidate("gompei");
            ED4.addCandidate("husky");
            ED4.addCandidate("ziggy");
        } catch (Exception e) {}
        // cast votes
        try {
            ED4.processVote("ziggy", "husky", "gompei");
            ED4.processVote("ziggy", "husky", "gompei");
            ED4.processVote("husky", "ziggy", "gompei");
            ED4.processVote("husky", "ziggy", "gompei");

        } catch (Exception e) {}
        return(ED4);
    }
    ElectionData emptyElection () {

        ElectionData empty_ED = new ElectionData();
        return(empty_ED);
    }

    Votes v = new Votes(3,2,1);
    Votes v1 = new Votes(0,0,0);
    //test countVotes
    //0
    @Test
    public void zeroCountVotes(){
        assertEquals(v.countVotes(0),0);
    }
    // 1
    @Test
    public void oneCountVotes(){
        assertEquals(v.countVotes(1),3);
    }
    // 2
    @Test
    public void twoCountVotes(){
        assertEquals(v.countVotes(2),2);
    }
    // 3
    @Test
    public void threeCountVotes(){
        assertEquals(v.countVotes(3),1);
    }

    //totalVotes
    //invalid
    @Test
    public void zeroTotalVotes(){
        assertEquals(v1.totalVotePoints(),0);
    }
    //valid
    @Test
    public void totalVotes(){
        assertEquals(v.totalVotePoints(),14);
    }

    //findWinnerMostFirstVotes
    //empty election
    @Test
    public void emptyMostFirst () {
        assertEquals ("Runoff required", emptyElection().findWinnerMostFirstVotes());
    }
    //no one over 50%
    @Test
    public void noneOver50MostFirst () {
        assertEquals ("Runoff required", Election1().findWinnerMostFirstVotes());
    }
    //one at 50%
    @Test
    public void at50MostFirst () {
        assertEquals ("Runoff required", Election2().findWinnerMostFirstVotes());
    }
    //two at 50%
    @Test
    public void twoAt50MostFirst () {
        assertEquals ("Runoff required", Election4().findWinnerMostFirstVotes());
    }
    //one over 50%
    @Test
    public void over50MostFirst () {
        assertEquals ("husky", Election3().findWinnerMostFirstVotes());
    }

    //findWinnerMostPoints
    //empty election
    @Test
    public void emptyMostPoints (){
        assertEquals("", emptyElection().findWinnerMostPoints());
    }
    //one winner
    @Test
    public void oneMostPoints (){
        assertEquals("husky", Election3().findWinnerMostPoints());
    }
    //tie ***fixed
    @Test
    public void tieMostPoints (){
        assertEquals("husky", Election4().findWinnerMostPoints());
    }
    // test CandidateExistsException
    @Test(expected = CandidateExistsException.class)
    public void testCandidateExistsException() throws CandidateExistsException{
        Election1().addCandidate("gompei");
    }
    /*
    //tests DuplicateVotesException
    @Test(expected = DuplicateVotesException.class)
    public void testDuplicateVoteException() throws DuplicateVotesException{
        Election1().processVote("gompei","gompei","husky");
    }
    //tests UnknownCandidateException
    @Test(expected = UnknownCandidateException.class)
    public void testUnknownCandidateException() throws UnknownCandidateException {
        Election1().processVote("bob", "husky", "gompei");
    }

     */
}
