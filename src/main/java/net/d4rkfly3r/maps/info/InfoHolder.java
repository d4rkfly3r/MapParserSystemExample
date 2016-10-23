package net.d4rkfly3r.maps.info;

import java.util.List;

public interface InfoHolder {
    void addTeam(final Team team);

    void addZone(final Zone zone);

    void addSpawns(final Spawns spawns);

    String getId();

    String getName();

    List<Team> getTeams();

    List<Zone> getZones();

    List<Spawns> getSpawns();
}
