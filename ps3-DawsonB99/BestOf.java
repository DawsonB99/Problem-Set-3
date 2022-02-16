/**
   Interface that defines the public API of the "Best Of" data
   structure that keeps only the "best" values added according to a
   given Comparator.  Values added to the structure that are not among
   the "best" at any given time are discarded.

   Based on Bailey's Java Structures Chapter 11 Lab.

   @author Jim Teresco
   @version Spring 2020
*/

public interface BestOf<E> extends Iterable<E> {

    /**
       Add a new element to the BestOf.
       
       @param item the element to add
    */
    public void add(E item);

    /**
       Return the number of elements currently stored in the structure.

       @return the number of elements currently stored in the structure
    */
    public int size();

    /**
       Clear the contents of the structure.
    */
    public void clear();

}
