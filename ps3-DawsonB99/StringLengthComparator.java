import java.util.Comparator;
/**
   A Comparator that orders String values by length.

   @author Jim Teresco
   @version Spring 2020
*/

public class StringLengthComparator implements Comparator<String> {

    /**
       Compare two String values by length.  Returns a negative value
       if the first is shorter than the second, 0 if they are the same
       lengths, and a positive value if the first is longer than the
       second.

       @param a the first String
       @param b the second String

       @return a negative value if a is shorter than b, 0 if they are
       the same lengths, and a positive value if a is longer than b
    */
    public int compare(String a, String b) {

	return a.length() - b.length();
    }
}