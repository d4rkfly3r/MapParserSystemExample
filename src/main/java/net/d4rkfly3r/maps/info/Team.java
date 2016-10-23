package net.d4rkfly3r.maps.info;

public class Team {
    private final String teamID;
    private final String teamName;

    public Team(final String teamID, final String teamName) {
        this.teamID = teamID;
        this.teamName = teamName;
    }

    public String getTeamID() {
        return teamID;
    }

    public String getTeamName() {
        return teamName;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamID='" + teamID + '\'' +
                ", teamName='" + teamName + '\'' +
                '}';
    }
}
