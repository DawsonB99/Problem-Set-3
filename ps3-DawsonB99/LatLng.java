/**    
 * Small data structure representing a
 * latitude-longitude pair.  It has the added benefit
 * of being able to compute its distance to another
 * LatLng object.
 *
 * @author Jim Teresco
 * @version Fall 2019
 */
public class LatLng 
{
    /** latitude */
    private double lat;
    
    /** longitude */
    private double lng;

    /**
     * Construct a new LatLng with the given coordinates.
     *
     * @param lat The latitude.
     * @param lng The longitude.
     */
    public LatLng(double lat, double lng) 
    {
        this.lat = lat;
        this.lng = lng;
    }

    /**
     * Get the latitude of this LatLng.
     * 
     * @return The latitude.
     */
    public double getLat() 
    {
        return lat;
    }

    /**
     * Get the longitude of this LatLng.
     * 
     * @return The longitude.
     */
    public double getLng() 
    {
        return lng;
    }

    /**
     * Compute the distance in miles from this LatLng to another.
     *
     * @param other Another LatLng.
     * @return The distance in miles from this LatLng to other.
     */
    public double distanceTo(LatLng other) 
    {
        /** radius of the Earth in statute miles */
        final double EARTH_RADIUS = 3963.1;

        // Did we get the same point?
        if (equals(other)) return 0.0;

        // coordinates in radians
        double rlat1 = Math.toRadians(lat);
        double rlng1 = Math.toRadians(lng);
        double rlat2 = Math.toRadians(other.lat);
        double rlng2 = Math.toRadians(other.lng);

        return Math.acos(Math.cos(rlat1)*Math.cos(rlng1)*Math.cos(rlat2)*Math.cos(rlng2) +
            Math.cos(rlat1)*Math.sin(rlng1)*Math.cos(rlat2)*Math.sin(rlng2) +
            Math.sin(rlat1)*Math.sin(rlat2)) * EARTH_RADIUS;
    }

    /**
     * Compare another LatLng with this for equality, subject to the
     * specified tolerance.
     *
     * @param o The other LatLng.
     * @return Whether the two lat/lng pairs should be considered equal.
     */
    public boolean equals(Object obj) 
    {
        final double TOLERANCE = 0.00001;
        LatLng other = (LatLng) obj;

        return ((Math.abs(other.lat-lat) < TOLERANCE) &&
            (Math.abs(other.lng-lng) < TOLERANCE));
    }

    /**
     * Return The latitude and longitude in a nicely-formatted pair.
     *
     * @return The latitude and longitude in a nicely-formatted pair.
     */
    @Override
    public String toString() 
    {
        return "(" + lat + "," + lng + ")";
    }
}

