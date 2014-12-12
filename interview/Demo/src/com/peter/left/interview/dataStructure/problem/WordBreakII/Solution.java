package com.peter.left.interview.dataStructure.problem.WordBreakII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution
{
    public List<String> wordBreak(String s, Set<String> dict)
    {
        final Map<Integer, List<String>> result = new HashMap<>();
        final Set<String> fast = new HashSet<>(dict);
        
        for (int i = 1; i <= s.length(); ++i)
        {
            final List<String> item = new ArrayList<>();
            
            if (fast.contains(s.substring(0, i)))
            {
                item.add(s.substring(0, i));
            }
            
            for (int j = 1; j < i; ++j)
            {
                final String tail = s.substring(j, i);
                
                if (fast.contains(tail))
                {
                    for (final String sub : result.get(j))
                    {
                        item.add(sub + " " + tail);
                    }
                }
            }
            
            result.put(i, item);
        }
        
        return result.get(s.length());
    }
}
