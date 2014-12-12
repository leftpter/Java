package com.peter.left.interview.dataStructure.problems.CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    
    private List<List<Integer>> combinationSum(final int[] candidates, final int start, final int end, final int target)
    {
        final List<List<Integer>> result = new ArrayList<>();
        if (target == 0)
        {
            return Collections.singletonList(Collections.<Integer>emptyList());
        }
        if (start < end && candidates[start] <= target)
        {
            {
                for (int i = start; i < end && candidates[i] <= target; ++i)
                {
                    for (int j = 1; j <= (target / candidates[i]); ++j)
                    {
                        final List<List<Integer>> temp = combinationSum(candidates, i + 1, end, target - j * candidates[i]);
                        for (final List<Integer> list : temp)
                        {
                            final List<Integer> item = new ArrayList<>();
                            for (int k = 0; k < j; ++k)
                            {
                                item.add(candidates[i]);
                            }
                            
                            item.addAll(list);
                            result.add(item);
                        }
                    }
                }
            }
        }
        
        return result;
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        Arrays.sort(candidates);
       
       return combinationSum(candidates, 0, candidates.length, target);
    }
}
