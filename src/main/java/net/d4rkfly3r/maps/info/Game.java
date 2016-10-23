package net.d4rkfly3r.maps.info;

import java.util.ArrayList;
import java.util.List;

public class Game implements InfoHolder {
    private final String gameID;
    private final String gameName;

    private final List<Team> teams;
    private final List<Zone> zones;
    private final List<Spawns> spawns;


    public Game(final String gameID, final String gameName) {
        this.gameID = gameID;
        this.gameName = gameName;

        this.teams = new ArrayList<>();
        this.zones = new ArrayList<>();
        this.spawns = new ArrayList<>();
    }

    public String getGameID() {
        return gameID;
    }

    public String getGameName() {
        return gameName;
    }

    @Override
    public void addTeam(final Team team) {
        this.teams.add(team);
    }

    @Override
    public void addZone(final Zone zone) {
        this.zones.add(zone);
    }

    @Override
    public void addSpawns(final Spawns spawns) {
        this.spawns.add(spawns);
    }

    @Override
    public String getId() {
        return gameID;
    }

    @Override
    public String getName() {
        return gameName;
    }

    @Override
    public List<Team> getTeams() {
        return this.teams;
    }

    @Override
    public List<Zone> getZones() {
        return this.zones;
    }

    @Override
    public List<Spawns> getSpawns() {
        return this.spawns;
    }

    @Override
    public String toString() {
        return "Game{" +
                "gameID='" + gameID + '\'' +
                ", gameName='" + gameName + '\'' +
                ", teams=" + teams +
                ", zones=" + zones +
                ", spawns=" + spawns +
                '}';
    }
}
