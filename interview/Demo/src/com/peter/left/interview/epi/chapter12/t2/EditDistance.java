package com.peter.left.interview.epi.chapter12.t2;

public class EditDistance 
{
 // D(a[0 .. n], b[0 .. m] ) = D(a[0 ... n-1], b[0 .. m-1]). a[n] == b[m]
    // D(a[0 .. n], b[0 .. m] ) = 1 + min(D(a[0 .. n - 1], b[0 .. m-1]), D(a[0 .. n], b[0 .. m-1]), D(a[0 .. n-1], b[0, m])
    public int minDistance(String word1, String word2)
    {
        final String longer = (word1.length() >= word2.length()) ? word1 : word2;
        final String shorter = (longer == word1) ? word2 : word1;
        
        if (shorter.length() > 0)
        {
            int[] previous = new int[longer.length()];
            for (int i = 0; i < previous.length; ++i)
            {
                if (shorter.charAt(0) == longer.charAt(i))
                {
                    previous[i] = i;
                }
                else
                {
                    previous[i] = (i > 0 ? previous[i - 1] : 0) + 1;
                }
            }
            
            for (int i = 1; i < shorter.length(); ++i)
            {
                final int[] current = new int[previous.length];
                current[0] = (shorter.charAt(i) == longer.charAt(0)) ? i : (previous[0] + 1);
                for (int j = 1; j < current.length; ++j)
                {
                    if (shorter.charAt(i) == longer.charAt(j))
                    {
                        current[j] = previous[j - 1];
                    }
                    else
                    {
                        current[j] = Math.min(previous[j - 1], previous[j]);
                        current[j] = Math.min(current[j], current[j - 1]);
                        
                        ++current[j];
                    }
                }
                
                previous = current;
            }
            
            return previous[previous.length - 1];
        }
        else
        {
            return longer.length();
        }
    }
}
