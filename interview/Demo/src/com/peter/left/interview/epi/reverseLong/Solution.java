package com.peter.left.interview.epi.reverseLong;

public class Solution
{
    public long reverse(final long value)
    {
        long result = 0;
        
        for (int i = 0; i < Long.SIZE; ++i)
        {
            result <<= 1;
            result += value >> i & 1;
        }
        
        return result;
    }
}
