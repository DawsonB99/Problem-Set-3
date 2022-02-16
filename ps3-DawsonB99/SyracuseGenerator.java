
/**
 * An iterator that creates a sequence of numbers that eventually lead
 * to 1.
 *
 * @author Michael Scanlon Dawson Bridger
 * @version Spring 2020
 */
public class SyracuseGenerator implements java.util.Iterator<Long>
{
    private long number;
    boolean isDone;

    /**
     * Constructor for objects of class SyracuseGenerator
     */
    public SyracuseGenerator(long n)
    {
        number = n;
    }

    /**
     * Return whether the number has reached 1.

       @return whether the number has reached 1.
     */
    @Override
    public boolean hasNext() {
        if(!isDone)
        {
            return true;
        }
        return false;
    }

    /**
     * Return the next number in the sequence.

       @return the next number in the sequence.
     */
    @Override
    public Long next() {
        long current = number;
        if(number == 1)
        {
            isDone = true;
        }
        if(number % 2 == 0)
        {
            number = number / 2;
        }
        else
        {
            number = 3 * number + 1;
        }
        return current;
    }

    /**
       main method to test the SyracuseGenerator.

       @param args[0] starting number
    */
    public static void main(String args[])
    {
        long n = 0;
        
        n = Long.parseLong(args[0]);
        
        java.util.Iterator<Long> iter = new SyracuseGenerator(n);
        while (iter.hasNext()) {
	    System.out.println(iter.next());
	}
    }
}

