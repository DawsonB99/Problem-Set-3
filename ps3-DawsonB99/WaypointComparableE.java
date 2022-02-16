import java.util.Comparator;
/**
 * Write a description of class WaypointComparableE here.
 *
 * @author Dawson Bridger and Mike Scanlon
 * @version Spring 2020
 */
public class WaypointComparableE implements Comparator<Waypoint>
{
    public int compare(Waypoint a, Waypoint b)
    {
        double length = a.getLng() - b.getLng();
        return (int)length;
    }
}