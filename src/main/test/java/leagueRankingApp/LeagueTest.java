package leagueRankingApp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LeagueTest {
    private League league;
    private String FILE_PATH = "test_input.txt";

    @BeforeEach
    void setUp() {
        league = new League(FILE_PATH); // Assuming "test_input.txt" contains test data
    }

    @Test
    void testParseInputToMatches_HappyPath(@TempDir File tempDir) throws IOException {
        File inputFile = new File(tempDir, FILE_PATH);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile))) {
            writer.write("Team A 2, Team B 1\n");
            writer.write("Team C 3, Team D 0\n");
        }

        League league = new League(inputFile.getPath());
        List<Match> parsedMatches = league.parseInputTextToMatches(inputFile.getPath());

        assertEquals(2, parsedMatches.size());
    }

    @Test
    void testParseInputToMatches_UnhappyPath(@TempDir File tempDir) {
        String nonExistentFilePath = new File(tempDir, "non_existent_file.txt").getPath();

        League league = new League(nonExistentFilePath);

        assertThrows(IOException.class, () -> league.parseInputTextToMatches(nonExistentFilePath));
    }

    @Test
    void testShouldReturnTeamFromTrimGivenString() {
        String team = league.getTeamFromTrim("Team A ");
        assertEquals("Team A", team);
    }

    @Test
    void testShouldReturnTeamScoreAsLastCharGivenAString() {
        int score = league.getTeamScoreFromString("Team A 3");
        assertEquals(3, score);
    }

    @Test
    void testShouldParseInputToMatchesGivenMatchesPlayed(@TempDir File tempDir) throws IOException {
        File inputFile = new File(tempDir, FILE_PATH);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile))) {
            writer.write("Team A 2, Team B 1\n");
            writer.write("Team C 3, Team D 0\n");
            writer.write("Team E 3, Team F 1\n");
        }
        League league = new League(inputFile.getPath());
        league.parseInputTextToMatches(inputFile.getPath());
        league.getLeagueMatchesPlayed();
        List<Match> matches = league.getMatches();
        assertEquals(3, matches.size()); // Assuming there are 3 matches in the test input
    }
}
