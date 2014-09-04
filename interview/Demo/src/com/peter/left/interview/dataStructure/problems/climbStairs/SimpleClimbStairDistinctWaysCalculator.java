package com.peter.left.interview.dataStructure.problems.climbStairs;

import org.apache.commons.lang3.Validate;

public class SimpleClimbStairDistinctWaysCalculator implements ClimbStairDistinctWaysCalculator
{
    private long calculateMultiple(final int n)
    {
        assert n >= 0 : String.format("n must not be nagative; is %d", n);
        long total = 1;
        
        for (int i = 1; i <= n; ++i)
        {
            total *= i;
        }
        
        return total;
    }
    private long calculateComination(final int posNum, final int itemNum)
    {
        assert posNum >= itemNum : String.format("posNum must be larger than itemNum; is %d, %d",
                posNum, itemNum);
        
        return (itemNum == 0 || posNum == itemNum) ? 1 : calculateMultiple(posNum) / calculateMultiple(itemNum) / calculateMultiple(posNum - itemNum);
    }
    
    private long calculateAllPossibleComination(final int count1, final int count2)
    {
        assert count1 >= 0 : String.format("count1 must be positive; is %d", count1);
        assert count2 >= 0 : String.format("count2 must be positive; is %d", count2);
        
        long total = 0;
        if (count1 >= count2)
        {
            for (int i = 1; i <= count2; ++i)
            {
                total += calculateComination(count1 + 1, count2);
            }
        }
        else
        {
            for (int i = 1; i <= count1; ++i)
            {
                total += calculateComination(count2 + 1, count1);
            }
        }
        
        return total;
    }
    
    @Override
    public long calculate(final int n)
    {
        Validate.isTrue(n >= 0, "n must not be negative; is %d", n);
        
        final long total;
        
        switch (n)
        {
        case 0:
            total = 0;
            break;
            
        case 1:
            total = 1;
            break;
            
        default:
            {
                int steps = 1 + ((n % 2 == 0) ? 1 : 0);
                for (int i = 1; i * 2 < n; ++i)
                {
                    steps += calculateAllPossibleComination(i, n - i * 2);
                }
                
                total = steps;
            }
            break;
        }
        
        return total;
    }
}
