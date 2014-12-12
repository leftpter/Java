package com.peter.left.interview.epi.chapter14.t1;

import java.util.Arrays;

public class BinarySolution implements Solution
{
    private int binarySearch(final int[] values, final int start, final int end, final int value)
    {
        int left;
        int right;
        for (left = start, right = end; left <= right; )
        {
            final int middle = (left + right) / 2;
            if (values[middle] == value)
            {
                return middle;
            }
            else if (values[middle] > value)
            {
                right = middle - 1;
            }
            else
            {
                left = middle + 1;
            }
        }
        
        return -(right + 1) - 1;
    }
    public int[] intersection(final int[] a, final int[] b)
    {
        int[] result = {};
        int num = 0;
        if (null != a && a.length != 0 && b != null && b.length != 0)
        {
            result = new int [Math.min(a.length, b.length)];
            final int[] t1 = (a.length <= b.length) ? a : b;
            final int[] t2 = (t1 == a) ? b : a;
            
            int start = 0;
            for (final int value : t1)
            {
               // final int index = binarySearch(t2, start, t2.length - 1, value);
                final int index = Arrays.binarySearch(t2, start, t2.length, value);
                if (index >= 0)
                {
                    result[num++] = value;
                    start = index + 1;
                }
                else
                {
                    start = -(index + 1);
                }
            }
        }
        
        return Arrays.copyOf(result, num);
    }
}
