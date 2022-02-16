
/**
 * Takes in a value and generates a SyracuseSearch of all the values leading up to that value,
 * then prints out the Largest Sequence, the value that generated that sequence, the largest
 * value found in any sequence, the value that generated it, and that value's position in the sequence.
 *
 * @author Dawson Bridger Michael Scanlon
 * @version Spring 2020
 */
public class SyracuseSearch
{
    /**
    Main method to use Syracuse Search.

    @param args[0] starting number
     */
    public static void main(String args[])
    {
        long n;
        int k;
        long longestRun = 1;
        long currentRun = 1;
        long largestN = 0;
        long value = 0;
        long nextValue = 0;
        long valueN = 0;
        long valuePosition = 0;

        n = Long.parseLong(args[0]);
        k = Integer.parseInt(args[1]);
        
        BestOfArrayListComparables topK = new BestOfArrayListComparables(k);
        BestOfArrayListComparables topKSequences = new BestOfArrayListComparables(k);

        for(int i = 1;i <= n;i++)
        {
            java.util.Iterator<Long> iter = new SyracuseGenerator(i);
            while (iter.hasNext()) {
                nextValue = iter.next();
                topK.add(nextValue);
                if(nextValue > value)
                {
                    value = nextValue;
                    valueN = i;
                    valuePosition = currentRun;
                }
                currentRun++;
            }
            topKSequences.add(currentRun);
            if(longestRun < currentRun)
            {
                longestRun = currentRun;
                largestN = i;
            }
            currentRun = 1;
        }

        java.util.Iterator<Long> iter = new SyracuseGenerator(largestN);
        System.out.println("N that generated Longest Sequence: " + largestN + "\n");
        

        System.out.println("Largest Value Found: " + value + "\n");
        System.out.println("The N that Generated it: " + valueN + "\n");
        System.out.println("The Value's Position in the Sequence: " + valuePosition + "\n");
        
        System.out.println("Top " + k + ": \n" + topK.toString() + "\n");
        System.out.println("Top " + k + " Sequences: \n" + topKSequences.toString());
    }
}

