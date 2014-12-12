package com.peter.left.interview.dataStructure.problem.sqrt;

import java.util.Arrays;

public class Solution
{
    public int sqrt(int x)
    {
        if (x == 0)
        {
            return 0;
        }
        else if (x == 1)
        {
            return 1;
        }
        
        int left = 0;
        int right = 1 << (Integer.SIZE / 2);
        final long target = x;
        
        while (left <= right)
        {
            final int middle = (left + right) / 2;
            final long value = (long) middle * middle;
            
            if (value < target)
            {
                left = middle + 1;
            }
            else if (value > target)
            {
                right = middle - 1;
            }
            else
            {
                return middle;
            }
        }
       
        return right;
    }
}
