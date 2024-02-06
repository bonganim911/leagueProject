package leagueRankingApp;

public enum MatchResult {
    WIN(3),
    DRAW(1),
    LOSS(0);

    private final int points;

    MatchResult(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }
}
