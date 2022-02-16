import java.util.Comparator;
/**
 * Write a description of class WaypointComparableS here.
 *
 * @author Dawson Bridger and Mike Scanlon
 * @version Spring 2020
 */
public class WaypointComparableS implements Comparator<Waypoint>
{
    public int compare(Waypoint a, Waypoint b)
    {
        if(a.getLat() < b.getLat())
        {
            return 1;
        }
        else if(a.getLat() > b.getLat())
        {
            return -1;
        }
        return 0;
    }
}
