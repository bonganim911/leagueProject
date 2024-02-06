package leagueRankingApp;

public class Match {
    private String teamOne;
    private int scoreOfTeamOne;
    private String teamTwo;
    private int scoreOfTeamTwo;

    public Match(String teamOne, int scoreOfTeamOne, String teamTwo, int score2) {
        this.teamOne = teamOne;
        this.scoreOfTeamOne = scoreOfTeamOne;
        this.teamTwo = teamTwo;
        this.scoreOfTeamTwo = score2;
    }

    public String getTeamOne() {
        return teamOne;
    }

    public int getScoreOfTeamOne() {
        return scoreOfTeamOne;
    }

    public String getTeamTwo() {
        return teamTwo;
    }

    public int getScoreOfTeamTwo() {
        return scoreOfTeamTwo;
    }


}
