package net.d4rkfly3r.maps.info;

import java.util.ArrayList;
import java.util.List;

public class Zone {
    private final String zoneID;
    private final String zoneName;

    private final List<Region> regions;

    public Zone(final String zoneID, final String zoneName) {
        this.zoneID = zoneID;
        this.zoneName = zoneName;

        this.regions = new ArrayList<>();
    }

    public void addRegion(final Region region) {
        this.regions.add(region);
    }

    public String getZoneName() {
        return zoneName;
    }

    public String getZoneID() {
        return zoneID;
    }

    public List<Region> getRegions() {
        return regions;
    }

    @Override
    public String toString() {
        return "Zone{" +
                "zoneID='" + zoneID + '\'' +
                ", zoneName='" + zoneName + '\'' +
                ", regions=" + regions +
                '}';
    }
}
