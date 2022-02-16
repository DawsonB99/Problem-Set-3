import java.util.Comparator;
/**
 * Write a description of class BestOfArrayListComparables here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BestOfArrayListComparables<E extends Comparable>
extends BestOfArrayList<E> {
    public BestOfArrayListComparables(int k) {
        super(k, Comparator.naturalOrder());
    }

    public BestOfArrayListComparables() {
        this(10);
    }

}
