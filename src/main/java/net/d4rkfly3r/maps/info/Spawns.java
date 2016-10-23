package net.d4rkfly3r.maps.info;

import java.util.ArrayList;
import java.util.List;

public class Spawns {
    private final String spawnTeam;

    private final List<Region> regions;
    private final List<Point> points;

    public Spawns(final String spawnTeam) {
        this.spawnTeam = spawnTeam;

        this.regions = new ArrayList<>();
        this.points = new ArrayList<>();
    }

    public void addRegion(final Region region) {
        this.regions.add(region);
    }

    public void addPoint(final Point point) {
        this.points.add(point);
    }

    public String getSpawnTeam() {
        return spawnTeam;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "Spawns{" +
                "spawnTeam='" + spawnTeam + '\'' +
                ", regions=" + regions +
                ", points=" + points +
                '}';
    }
}
