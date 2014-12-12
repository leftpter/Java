package com.peter.left.interview.dataStructure.problems.SingleNumber;

import java.util.BitSet;

public class BitsetSingleNumberFinder implements SingleNumberFinder
{
    private BitSet fromInteger(final int value)
    {
        final BitSet set = new BitSet();
        int restValue = value;
        for (int i = 0; restValue != 0; restValue >>>= 1, ++i)
        {
            if ((restValue & 1) != 0)
            {
                set.set(i);
            }
        }
        return set;
    }
    
    private int fromBitSet(final BitSet set)
    {
        int result = 0;
        
        for (int i = 0; i < set.length(); ++i)
        {
            if (set.get(i))
            {
                result |= 1 << i;
            }
        }
        
        return result;
    }

    @Override
    public int find(final int[] numbers)
    {
        final BitSet set = new BitSet();
        
        for (final int number : numbers)
        {
            set.xor(fromInteger(number));
        }
        
        return fromBitSet(set);
    }
}
