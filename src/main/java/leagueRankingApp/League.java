package leagueRankingApp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class League {

    private List<Match> matches;
    private Table leagueTable = new Table();
    private String filePath;

    public League(String filePath) {
        this.filePath =  filePath;
        this.matches = new ArrayList<>();
    }

    public void getLeagueMatchesPlayed() throws IOException {
        List<Match> parsedMatches = parseInputTextToMatches(this.filePath);
        this.matches.addAll(parsedMatches);
        updateMatchesPoints(parsedMatches);
    }

    public List<Match> parseInputTextToMatches(String inputText) throws IOException {
        List<Match> parsedMatches = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(inputText))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length == 2) {
                    String team1 = getTeamFromTrim(parts[0]);
                    int score1 = getTeamScoreFromString(parts[0]);
                    String team2 = getTeamFromTrim(parts[1]);
                    int score2 = getTeamScoreFromString(parts[1]);
                    parsedMatches.add(new Match(team1, score1, team2, score2));
                }
            }
        }
        return parsedMatches;
    }

    private void updateMatchesPoints(List<Match> matches) {
        for (Match match : matches) {
            leagueTable.processMatchPoints(match);
        }
    }

    public List<Map.Entry<String, Integer>> getLeagueRanking() {
        return leagueTable.calculateRanking();
    }

    public String getTeamFromTrim(String part) {
        return part.substring(0, part.length() - 1).trim();
    }

    public int getTeamScoreFromString(String part) {
        return Integer.parseInt(String.valueOf(part.charAt(part.length() - 1)));
    }

    public void generateFixtureOutput() throws IOException {
        getLeagueMatchesPlayed();
        int rank = 1;
        for (Map.Entry<String, Integer> entry : getLeagueRanking()) {
            System.out.printf("%d. %s, %d pts\n", rank++, entry.getKey(), entry.getValue());
        }
    }

    public List<Match> getMatches() {
        return matches;
    }
}
