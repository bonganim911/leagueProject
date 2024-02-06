package leagueRankingApp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TableTest {
    public static final String TEAM_ONE = "TeamA";
    public static final String TEAM_TWO = "TeamB";
    public static final int THREE = 3;
    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final int TWO = 2;
    private Table table;

    @BeforeEach
    void setUp() {
        table = new Table();
    }

    @Test
    void testShouldProcessMatchPointsGivenTeamsAndScores() {
        Match match = new Match(TEAM_ONE, TWO, TEAM_TWO, ONE);
        table.processMatchPoints(match);

        assertEquals(THREE, table.getTeamPoints().get(TEAM_ONE));
        assertEquals(ZERO, table.getTeamPoints().get(TEAM_TWO));
    }

    @Test
    void testShouldDeterminePointsGivenScoresOfTeams() {
        assertEquals(ONE, table.determinePoints(ONE, ONE));
        assertEquals(THREE, table.determinePoints(TWO, ONE));
        assertEquals(ZERO, table.determinePoints(ZERO, THREE));
    }

    @Test
    void testShouldUpdateTeamPointsGivenTeamAndPoints() {
        table.updateTeamPoints(TEAM_ONE, THREE);
        assertEquals(THREE, table.getTeamPoints().get(TEAM_ONE));

        table.updateTeamPoints(TEAM_ONE, ONE);
        assertEquals(4, table.getTeamPoints().get(TEAM_ONE));
    }

    @Test
    void testShouldCalculateRankingOfTeams() {
        table.getTeamPoints().put(TEAM_ONE, 5);
        table.getTeamPoints().put(TEAM_TWO, THREE);
        String teamThree = "TeamC";
        table.getTeamPoints().put(teamThree, 7);

        List<Map.Entry<String, Integer>> ranking = table.calculateRanking();

        assertEquals(teamThree, ranking.get(0).getKey());
        assertEquals(7, ranking.get(0).getValue());
        assertEquals(TEAM_ONE, ranking.get(1).getKey());
        assertEquals(5, ranking.get(1).getValue());
        assertEquals(TEAM_TWO, ranking.get(TWO).getKey());
        assertEquals(THREE, ranking.get(TWO).getValue());
    }
}
