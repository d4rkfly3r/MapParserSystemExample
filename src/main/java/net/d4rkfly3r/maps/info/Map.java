package net.d4rkfly3r.maps.info;

import java.util.ArrayList;
import java.util.List;

public class Map implements InfoHolder {
    private final String id;
    private final String name;
    private final String type;
    private final String assetPack;

    private final List<Author> authors;
    private final List<Team> teams;
    private final List<Zone> zones;
    private final List<Game> games;
    private final List<Spawns> spawns;

    public Map(final String id, final String name, final String type, final String assetPack) {
        this.id = id.trim();
        this.name = name.trim();
        this.type = type.trim();
        this.assetPack = assetPack.trim();

        this.authors = new ArrayList<>();
        this.teams = new ArrayList<>();
        this.zones = new ArrayList<>();
        this.games = new ArrayList<>();
        this.spawns = new ArrayList<>();
    }

    public void addAuthor(final Author author) {
        this.authors.add(author);
    }

    @Override
    public void addTeam(final Team team) {
        this.teams.add(team);
    }

    @Override
    public void addZone(final Zone zone) {
        this.zones.add(zone);
    }

    public void addGame(final Game game) {
        this.games.add(game);
    }

    @Override
    public void addSpawns(final Spawns spawns) {
        this.spawns.add(spawns);
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getAssetPack() {
        return assetPack;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    @Override
    public List<Team> getTeams() {
        return teams;
    }

    @Override
    public List<Zone> getZones() {
        return zones;
    }

    @Override
    public List<Spawns> getSpawns() {
        return this.spawns;
    }

    public List<Game> getGames() {
        return games;
    }

    @Override
    public String toString() {
        return "Map{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", assetPack='" + assetPack + '\'' +
                ", authors=" + authors +
                ", teams=" + teams +
                ", zones=" + zones +
                ", games=" + games +
                ", spawns=" + spawns +
                '}';
    }
}
