package com.peter.left.interview.dataStructure.problems.candy;

public class SimpleMinCandyCalculator implements MinCandyCalculator
{
    private static enum Status
    {
        UP,
        DOWN,
        NONE
    };
    
    private int calculateMinCandy(final int[] values)
    {
        assert null != values : "value must not be null";
        
        int preTop = -1;
        Status status = Status.NONE;
        int current = 1;
        int total = current;
        
        for (int i = 1; i < values.length; ++i)
        {
            if (values[i] > values[i - 1])
            {
                if (Status.DOWN == status)
                {
                    assert 0 <= preTop && preTop < i - 1 : 
                        String.format("preTop must be[0, %d); is %d", i - 1, preTop);
                    
                    total -= (i - 1 - preTop) * (current - 1);
                    current = 1;
                }
                status = Status.UP;
                ++current;
            }
            else if (values[i] < values[i - 1])
            {
                if (Status.UP == status)
                {
                    preTop = i - 1;
                }
                
                status = Status.DOWN;
                --current;
            }
            
            total += current;
        }
        
        if (Status.DOWN == status)
        {
            total -= (values.length - 1 - preTop) * (current - 1);
        }
        
        return total;
    }
    @Override
    public int calculate(final int[] values)
    {
        final int result;
        
        if (null != values)
        {
            result = calculateMinCandy(values);
        }
        else
        {
            result = 0;
        }
        
        return result;
    }
}
