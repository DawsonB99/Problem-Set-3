import java.util.Comparator;
/**
 * Write a description of class WaypointComparableN here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WaypointComparableN implements Comparator<Waypoint>
{
    public int compare(Waypoint a, Waypoint b)
    {
        double length = a.getLat() - b.getLat();
        return (int)length;
    }
}
