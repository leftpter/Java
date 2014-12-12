package com.peter.left.interview.dataStructure.problem.MinimumWindowSubstring;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Solution
{
    private boolean isWindow(final Map<Character, Integer> result, final Map<Character, Integer> map)
    {
        for (final Entry<Character, Integer> entry : map.entrySet())
        {
            if (!result.containsKey(entry.getKey()) || result.get(entry.getKey()) < entry.getValue())
            {
                return false;
            }
        }
        
        return true;
    }
    
    private int findStart(final int start, final int end, final String S, final Map<Character, Integer> result, final Map<Character, Integer> map)
    {
        int i = start;
        for (; i <= end; ++i)
        {
            final char c = S.charAt(i);
            if (map.containsKey(c))
            {
                if (result.get(c) > map.get(c))
                {
                    result.put(c, result.get(c) - 1);
                }
                else
                {
                    break;
                }
            }
        }
        
        return i;
    }
    
    public String minWindow(String S, String T)
    {
        final Map<Character, Integer> map = new HashMap<>();
        final Map<Character, Integer> result = new HashMap<>();
        
        for (int i = 0; i < T.length(); ++i)
        {
            final char c = T.charAt(i);
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
            result.put(c, 0);
        }
        
        
        String str = "";
        int min = Integer.MAX_VALUE;
        int start = 0;
        
        for (int i = findStart(0, S.length() - 1, S, result, map); i < S.length(); ++i)
        {
            final char c = S.charAt(i);
            if (map.containsKey(c))
            {
                result.put(c, (result.containsKey(c) ? result.get(c) + 1 : 1));
                
                final int newStart = findStart(start, i, S, result, map);
            
                if ((min == Integer.MAX_VALUE || newStart != start) 
                        && isWindow(result, map))
                {
                    if (i - newStart + 1 < min)
                    {
                        min = i - newStart + 1;
                        str = S.substring(newStart, i + 1);
                    }
                    
                    if (min == T.length())
                    {
                        break;
                    }
                }
                
                start = newStart;
            }
        }
        
        return str;
    }
}