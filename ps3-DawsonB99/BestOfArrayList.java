import java.util.Comparator;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * Takes an Array List of datatypes with size restrictions and orders them based off given Comparator.
 *
 * @author Dawson Bridger and Mike Scanlon
 * @version Spring 2020
 */

public class BestOfArrayList<E> implements BestOf<E> 
{
    private int occupied;
    private Comparator<E> compare;
    ArrayList<E> bestList;
    private int size;

    public BestOfArrayList(int k,Comparator<E> a)
    {
        bestList = new ArrayList<E>(k);
        occupied = k;
        size = 0;
        compare = a;
    }

    public BestOfArrayList(Comparator<E> a)
    {
        bestList = new ArrayList<E>(10);
        occupied = 10;
        size = 0;
        compare = a;
    }

    /**
     * 
    Add a new element to the BestOf.

    @param item the element to add
     */
    @Override
    public void add(E item)
    {
        if(size() == 0)
        {
            bestList.add(item);
            size++;
        }
        else if(size() < occupied)
        {
            for(int i = size();i > 0;i--)
            {
                if(compare.compare(item,bestList.get(i - 1)) < 0)
                {
                    bestList.add(i,item);
                    size++;
                    return;
                }
            }
            bestList.add(0,item);
            size++;
        }
        else
        {
            if(compare.compare(item,bestList.get(size() - 1)) < 0)
            {
                return;
            }
            for(int i = occupied - 2;i > 0;i--)
            {
                if(compare.compare(item,bestList.get(i - 1)) < 0)
                {
                    bestList.remove(size() - 1);
                    bestList.add(i,item);
                    return;
                }
            }
            bestList.remove(size() - 1);
            bestList.add(0,item);
        }
    }

    /**
    Return the number of elements currently stored in the structure.

    @return the number of elements currently stored in the structure
     */
    @Override
    public int size()
    {
        return size;
    }

    /**
    Clear the contents of the structure.
     */
    @Override
    public void clear()
    {
        for(int i = 0;i < occupied;i++)
        {
            bestList.set(i,null);
        }
    }

    @Override
    public Iterator iterator()
    {
        return bestList.iterator();
    }

    @Override
    public String toString()
    {
        Iterator iter = bestList.iterator();
        StringBuffer print = new StringBuffer();
        int i = 1;
        while(iter.hasNext())
        {
            print.append(i + ": " + iter.next() + " ");
            i++;
        }
        return print.toString();
    }

    public static void main(String args[])
    {
        BestOfArrayListComparables test1 = new BestOfArrayListComparables(5);
        test1.add(10);
        test1.add(20);
        test1.add(5);
        test1.add(9);
        test1.add(16);
        test1.add(40);
        test1.add(4);
        
        System.out.println("Testing BestOf implementation with Integers using Natural Order Comparator.\n"); 
        System.out.println("Expected:\n 1: 40 2: 20 3: 16 4: 10 5: 9");
        System.out.println("Actual:\n " + test1.toString() + "\n");
        
        BestOfArrayList test2 = new BestOfArrayList(7, new StringLengthComparator());
        test2.add("Computer");
        test2.add("science");
        test2.add("is");
        test2.add("so");
        test2.add("much");
        test2.add("fun");
        test2.add("it's");
        test2.add("completely");
        test2.add("unbelievable");
        test2.add("have");
        test2.add("fun!");
        
        System.out.println("Testing BestOf implementation with Strings using a custom Comparator.\n");
        System.out.println("Expected:\n 1: unbelievable 2: completely 3: Computer 4: science 5: fun! 6: much 7: it's");
        System.out.println("Actual:\n " + test2.toString() + "\n");
        
        BestOfArrayListComparables test3 = new BestOfArrayListComparables();
        test3.add(20.1);
        test3.add(51.7);
        test3.add(1.2);
        test3.add(11.3);
        test3.add(45.0);
        test3.add(100.5);
        test3.add(7842.124);
        test3.add(512.021);
        test3.add(147.265);
        test3.add(147.264);
        test3.add(127.45);
        test3.add(201.2);
        
        System.out.println("Testing BestOf implementation with Doubles using Natural Order Comparator.\n");
        System.out.println("Expected:\n 1: 7842.124 2: 512.021 3: 201.2 4: 147.265 5: 147.264 6: 127.45 7: 100.5 8: 51.7 9: 45.0 10: 20.1");
        System.out.println("Actual:\n " + test3.toString() + "\n");
    }
}
