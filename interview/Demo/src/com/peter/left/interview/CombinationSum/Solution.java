package com.peter.left.interview.CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Solution
{
    public List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        final Map<Integer, List<List<Integer>>> results = new HashMap<>();
        results.put(0, Collections.singletonList(Collections.<Integer>emptyList()));
        Arrays.sort(candidates);
        for (int i = 0; i < candidates.length; ++i)
        {
            final Map<Integer, List<List<Integer>>> temp = new HashMap<>(results);
            for (final Entry<Integer, List<List<Integer>>> entry : temp.entrySet())
            {
                for (int j = 1; j <= (target - entry.getKey()) / candidates[i]; ++j)
                {
                    final int key = entry.getKey() + j * candidates[i];
                    if (!results.containsKey(key))
                    {
                        results.put(key, new ArrayList<List<Integer>>());
                    }
                    final List<List<Integer>> result = results.get(key);
                    
                    for (final List<Integer> item : entry.getValue())
                    {
                        final List<Integer> list = new ArrayList<>(item);
                        
                        for (int k = 0; k < j; ++k)
                        {
                            list.add(candidates[i]);
                        }
                        
                        result.add(list);
                    }
                }
            }
        }
        
        return (results.containsKey(target) ? results.get(target) : Collections.<List<Integer>>emptyList());
    }
}
