package leagueRankingApp;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {
        // Trade-off: Made League Class to call matches.txt file for input data instead of it to be called here on Main.
        URL resourceUrl = Main.class.getResource("/matches.txt");
        String filePath = new File(resourceUrl.getFile()).getAbsolutePath();


        League league = new League(filePath);
        league.generateFixtureOutput();
    }
}