package com.peter.left.interview.epi.chapter14.t1;

import java.util.Arrays;

public class LinearSolution implements Solution
{
    public int[] intersection(final int[] a, final int[] b)
    {
        int[] result = {};
        int num = 0;
        if (null != a && a.length != 0 && b != null && b.length != 0)
        {
            result = new int [Math.min(a.length, b.length)];
            final int[] t1 = (a[0] <= b[0]) ? a : b;
            final int[] t2 = (t1 == a) ? b : a;
            
            if (t1[t1.length - 1] >= t2[0])
            {
                for (int i = 0, j = 0; i < t1.length && j < t2.length; )
                {
                    if (t1[i] == t2[j])
                    {
                        result[num++] = t1[i++];
                        ++j;
                    }
                    else if (t1[i] > t2[j])
                    {
                        ++j;
                    }
                    else
                    {
                        ++i;
                    }
                }
            }
        }
        
        return Arrays.copyOf(result, num);
    }
}
