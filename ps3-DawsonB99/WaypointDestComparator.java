import java.util.Comparator;
/**
 * Write a description of class WaypointDestComparator here.
 *
 * @author Dawson Bridger and Mike Scanlon
 * @version Spring 2020
 */
public class WaypointDestComparator implements Comparator<Waypoint>
{
     public int compare(Waypoint a, Waypoint b)
     {
         return a.getDest().length() - b.getDest().length();
     }
}
