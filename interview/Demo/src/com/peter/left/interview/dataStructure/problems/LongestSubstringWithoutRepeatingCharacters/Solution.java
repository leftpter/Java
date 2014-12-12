package com.peter.left.interview.dataStructure.problems.LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Solution
{
    private Map<Character, Integer> getItemAfter(final Map<Character, Integer> map, final int index)
    {
        final Map<Character, Integer> newMap = new HashMap<>();
        
        for (final Entry<Character, Integer> item : map.entrySet())
        {
            if (item.getValue() > index)
            {
                newMap.put(item.getKey(), item.getValue());
            }
        }
        
        return newMap;
    }
    
    public int lengthOfLongestSubstring(String s)
    {
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i)
        {
            if (map.containsKey(s.charAt(i)))
            {
                map = getItemAfter(map, map.get(s.charAt(i)));
            }
            
            map.put(s.charAt(i), i);
            
            max = Math.max(max, map.size());
        }
        
        return max;
    }
}