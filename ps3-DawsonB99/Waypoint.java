
/**
 * Write a description of class Waypoint here.
 *
 * @author Dawson Bridger and Mike Scanlon
 * @version Spring 2020
 */
public class Waypoint extends LatLng
{
    private String dest;
    
    public Waypoint(String a, Double lat, Double lng)
    {
        super(lat,lng);
        dest = a;
    }
    
    public String getDest()
    {
        return dest;
    }
    
    public double getLat()
    {
        return super.getLat();
    }
    
    public double getLng()
    {
        return super.getLng();
    }
}
