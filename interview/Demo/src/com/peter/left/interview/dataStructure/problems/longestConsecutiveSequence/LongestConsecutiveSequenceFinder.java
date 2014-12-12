package com.peter.left.interview.dataStructure.problems.longestConsecutiveSequence;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import lombok.ToString;

public class LongestConsecutiveSequenceFinder
{
    @ToString
    private static class Sequence
    {
        private int start;
        private int end;
        
        Sequence(final int start, final int end)
        {
            this.start = start;
            this.end = end;
        }
    }
    
    
    public int find(final int[] elements)
    {
        final Map<Integer, Sequence> heads = new HashMap<>();
        final Map<Integer, Sequence> tails = new HashMap<>();
        final Set<Integer> visited = new HashSet<>();
        int max = 0;
        for (final int value : elements)
        {
            if (visited.contains(value))
            {
                continue;
            }
            
            visited.add(value);
            if (heads.containsKey(value) && tails.containsKey(value))
            {
                final Sequence left = tails.remove(value);
                final Sequence right = heads.remove(value);
                left.end = right.end;
                tails.put(left.end, left);
                heads.put(left.start, left);
                max = Math.max(max, left.end - left.start - 1);
            }
            else if (heads.containsKey(value))
            {
                final Sequence item = heads.remove(value);
                --item.start;
                heads.put(item.start, item);
                max = Math.max(max, item.end - item.start - 1);
            }
            else if (tails.containsKey(value))
            {
                final Sequence item = tails.remove(value);
                ++item.end;
                tails.put(item.end, item);
                max = Math.max(max, item.end - item.start - 1);
            }
            else
            {
                final Sequence item = new Sequence(value - 1, value + 1);
                heads.put(item.start, item);
                tails.put(item.end, item);
                
                max = Math.max(max, 1);
            }
        }
        
        return max;
    }
}