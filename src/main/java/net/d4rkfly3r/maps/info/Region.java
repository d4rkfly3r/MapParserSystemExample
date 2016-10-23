package net.d4rkfly3r.maps.info;

import java.util.ArrayList;
import java.util.List;

public class Region {

    private final List<Point> points;
    private final String weight;

    public Region(final String weight) {
        this.weight = weight;
        this.points = new ArrayList<>();

    }

    public void addPoint(final Point point) {
        this.points.add(point);
    }

    public List<Point> getPoints() {
        return this.points;
    }

    public String getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Region{" +
                "points=" + points +
                ", weight='" + weight + '\'' +
                '}';
    }
}
