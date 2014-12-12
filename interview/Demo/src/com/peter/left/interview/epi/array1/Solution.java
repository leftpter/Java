package com.peter.left.interview.epi.array1;

public class Solution
{
    void quickSort(final int[] values, final int target)
    {
        if (values != null)
        {
            int left = 0;
            int right = values.length - 1;
            int leftEqual = 0;
            int rightEqual = 0;
            
            while(left < right)
            {
                while (left < right && values[left] <= target)
                {
                    if (values[left] == target)
                    {
                        ++leftEqual;
                    }
                    
                    ++left;
                }
                
                while (left < right && values[right] >= target)
                {
                    if (values[right] == target)
                    {
                        ++rightEqual;
                    }
                    
                    --right;
                }
                
                if (left < right)
                {
                    final int temp = values[left];
                    values[left - leftEqual] = values[right];
                    values[right + rightEqual] = temp;
                    ++left;
                    --right;
                    
                    if (left == right && values[left] == target)
                    {
                        ++rightEqual;
                    }
                }
                
                if (left == right)
                {
                    if (values[left] > target)
                    {
                        values[right + rightEqual] = values[left];
                    }
                    else if (values[right] < target)
                    {
                        values[left - leftEqual] = values[right];
                        left++;
                    }
                }
            }
            
            for (int i = 0; i < leftEqual + rightEqual; ++i)
            {
                values[i + left - leftEqual] = target;
            }
        }
    }
}
