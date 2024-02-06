package leagueRankingApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Table {
    private Map<String, Integer> teamPoints;

    public Table() {
        this.teamPoints = new HashMap<>();
    }

    public void processMatchPoints(Match match) {
        updatePoints(match.getTeamOne(), match.getScoreOfTeamOne(), match.getTeamTwo(), match.getScoreOfTeamTwo());
    }

    private void updatePoints(String team1, int score1, String team2, int score2) {
        updateTeamPoints(team1, determinePoints(score1, score2));
        updateTeamPoints(team2, determinePoints(score2, score1));
    }

    public int determinePoints(int score1, int score2) {
        return score1 == score2 ? MatchResult.DRAW.getPoints() : (score1 > score2 ? MatchResult.WIN.getPoints() : MatchResult.LOSS.getPoints());
    }

    public void updateTeamPoints(String team, int points) {
        teamPoints.put(team, teamPoints.getOrDefault(team, 0) + points);
    }

    public List<Map.Entry<String, Integer>> calculateRanking() {
        List<Map.Entry<String, Integer>> sortedTeams = new ArrayList<>(teamPoints.entrySet());
        sortedTeams.sort((a, b) -> {
            if (b.getValue().equals(a.getValue())) {
                return a.getKey().compareTo(b.getKey());
            }
            return b.getValue().compareTo(a.getValue());
        });

        return sortedTeams;
    }

    public Map<String, Integer> getTeamPoints() {
        return teamPoints;
    }
}
