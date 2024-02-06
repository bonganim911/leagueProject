package leagueRankingApp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatchTest {

    public static final String TEAM_ONE = "TeamA";
    public static final String TEAM_TWO = "TeamB";
    public static final int TWO = 2;
    public static final int ONE = 1;

    @Test
    void testShouldReturnTeamOne() {
        Match match = new Match(TEAM_ONE, TWO, TEAM_TWO, ONE);
        assertEquals(TEAM_ONE, match.getTeamOne());
    }

    @Test
    void testShouldReturnScoreOfTeamOne() {
        Match match = new Match(TEAM_ONE, TWO, TEAM_TWO, ONE);
        assertEquals(TWO, match.getScoreOfTeamOne());
    }

    @Test
    void testShouldReturnTeamTwo() {
        Match match = new Match(TEAM_ONE, TWO, TEAM_TWO, ONE);
        assertEquals(TEAM_TWO, match.getTeamTwo());
    }

    @Test
    void testShouldReturnScoreOfTeamTwo() {
        Match match = new Match(TEAM_ONE, TWO, TEAM_TWO, ONE);
        assertEquals(ONE, match.getScoreOfTeamTwo());
    }
}
