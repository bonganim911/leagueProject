package leagueRankingApp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatchResultTest {
    @Test
    void testGetPoints_WIN() {
        assertEquals(3, MatchResult.WIN.getPoints());
    }

    @Test
    void testGetPoints_DRAW() {
        assertEquals(1, MatchResult.DRAW.getPoints());
    }

    @Test
    void testGetPoints_LOSS() {
        assertEquals(0, MatchResult.LOSS.getPoints());
    }
}
