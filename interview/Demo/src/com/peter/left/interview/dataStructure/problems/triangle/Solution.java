package com.peter.left.interview.dataStructure.problems.triangle;

import java.util.List;

public class Solution {
    private int minValue(final List<List<Integer>> triangle, final int x, final int y, final int[] preMinValues)
    {
        return Math.min(preMinValues[y], preMinValues[y + 1]);
    }
    
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.isEmpty())
        {
            return 0;
        }
        else if (triangle.size() == 1)
        {
            return triangle.get(0).get(0);
        }
        else
        {
            int[] preMinValues = new int[triangle.get(triangle.size() - 1).size()];
            int[] minValues = new int[1];
            
            for (int i = 0; i < triangle.get(triangle.size() - 1).size(); ++i)
            {
                preMinValues[i] = triangle.get(triangle.size() - 1).get(i);
            }
            
            for (int i = triangle.size() - 2; i >= 0; --i)
            {
                minValues = new int[triangle.get(i).size()];
                for (int j = 0; j < triangle.get(i).size(); ++j)
                {
                    minValues[j] = minValue(triangle, i, j, preMinValues) + triangle.get(i).get(j);
                }
                
                preMinValues = minValues;
            }
            
            return minValues[0];
        }
    }
}
