import java.io.File;
import java.util.Scanner;

/**
Replace this comment with something meaningful, and add your name
to the author tag.

@author Jim Teresco, Dawson Bridger and Mike Scanlon
 */

public class WaypointBest {

    public static void usage() {
        System.err.println("Usage: java WaypointBest tmgfile n, n must be > 0");
        System.exit(1);
    }

    /**
    Load the waypoints from a .tmg file and report the waypoint extremes
    using BestOf structures.

    @param args[0] the TMG filename
    @param args[1] the number of "best of" entries to track in each category
     */
    public static void main(String args[]) {

        if (args.length != 2) {
            usage();
        }

        try {
            int k = Integer.parseInt(args[1]);
            // create a BestOf to hold winners by each criterion
            BestOfArrayList bestKN = new BestOfArrayList(k,new WaypointComparableN());
            BestOfArrayList bestKS = new BestOfArrayList(k,new WaypointComparableS());
            BestOfArrayList bestKE = new BestOfArrayList(k,new WaypointComparableE());
            BestOfArrayList bestKW = new BestOfArrayList(k,new WaypointComparableW());
            BestOfArrayList bestDest = new BestOfArrayList(k,new WaypointDestComparator());

            // read through the file
            Scanner tmgfile = new Scanner(new File(args[0]));
            // skip over header line
            tmgfile.nextLine();
            int nV, nE;
            nV = tmgfile.nextInt();
            nE = tmgfile.nextInt();
            tmgfile.nextLine();
            for (int i = 0; i < nV; i++) {
                String line = tmgfile.nextLine();
                String[] parts = line.split(" ");
                // uncomment when your Waypoint class is ready
                Waypoint w = new Waypoint(parts[0], Double.parseDouble(parts[1]), Double.parseDouble(parts[2]));

                // add each waypoint to each BestOf
                bestKN.add(w);
                bestKS.add(w);
                bestKE.add(w);
                bestKW.add(w);
                bestDest.add(w);
            }
            tmgfile.close();

            // report the winners
            System.out.println("Top " + k + " Waypoints, North:\n" + bestKN.toString() + "\n");
            System.out.println("Top " + k + " Waypoints, South:\n" + bestKS.toString() + "\n");
            System.out.println("Top " + k + " Waypoints, East:\n" + bestKE.toString() + "\n");
            System.out.println("Top " + k + " Waypoints, West:\n" + bestKW.toString() + "\n");
            System.out.println("Top " + k + " Waypoints, Destination:\n" + bestDest.toString());

        }
        catch (Exception e) {
            System.err.println(e);
            System.exit(1);
        }
    }
}
