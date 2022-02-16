import java.util.Comparator;
/**
 * Write a description of class WaypointComparableW here.
 *
 * @author Dawson Bridger and Mike Scanlon
 * @version Spring 2020
 */
public class WaypointComparableW implements Comparator<Waypoint>
{
    public int compare(Waypoint a, Waypoint b)
    {
        if(a.getLng() < b.getLng())
        {
            return 1;
        }
        else if(a.getLng() > b.getLng())
        {
            return -1;
        }
        return 0;
    }
}