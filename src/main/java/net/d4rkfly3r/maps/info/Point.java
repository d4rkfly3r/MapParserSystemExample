package net.d4rkfly3r.maps.info;

public class Point {

    private final String x;
    private final String y;
    private final String z;
    private final String r;
    private final String w;

    public Point(final String x, final String y, final String z) {
        this(x, y, z, "\0");
    }

    public Point(final String x, final String y, final String z, final String r) {
        this(x, y, z, r, "\0");
    }

    public Point(final String x, final String y, final String z, final String r, final String w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.r = r;
        this.w = w;
    }

    public String getX() {
        return x;
    }

    public String getY() {
        return y;
    }

    public String getZ() {
        return z;
    }

    public String getR() {
        return r;
    }

    public String getW() {
        return w;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x='" + x + '\'' +
                ", y='" + y + '\'' +
                ", z='" + z + '\'' +
                ", r='" + r + '\'' +
                ", w='" + w + '\'' +
                '}';
    }
}
