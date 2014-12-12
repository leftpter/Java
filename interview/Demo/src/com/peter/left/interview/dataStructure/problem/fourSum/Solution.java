package com.peter.left.interview.dataStructure.problem.fourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution
{
    public List<List<Integer>> fourSum(int[] num, int target)
    {
        final List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(num);
        
        for (int i = 0; i < num.length - 3; )
        {
            for (int j = i + 1; j < num.length - 2; )
            {
                int left = j + 1;
                int right = num.length - 1;
                
                while (left < right)
                {
                    final int sum = num[i] + num[j] + num[left] + num[right];
                    boolean leftChanged = true;
                    boolean rightChanged = true;
                    if (sum == target)
                    {
                        final List<Integer> list = new ArrayList<>();
                        list.add(num[i]);
                        list.add(num[j]);
                        list.add(num[left++]);
                        list.add(num[right--]);
                        
                        result.add(list);
                    }
                    else if (sum < target)
                    {
                        ++left;
                        rightChanged = false;
                    }
                    else
                    {
                        --right;
                        leftChanged = false;
                    }
                    
                     while (leftChanged && left < right && num[left] == num[left - 1])
                    {
                        ++left;
                    }
                    
                    while (rightChanged && left < right && num[right] == num[right + 1])
                    {
                        --right;
                    }
                }
                
                ++j;
                while (j < num.length - 2 && num[j] == num[j - 1])
                {
                    ++j;
                }
            }
            
            ++i;
            while (i < num.length - 3 && num[i] == num[i - 1])
            {
                ++i;
            }
        }
        
        return result;
    }
}