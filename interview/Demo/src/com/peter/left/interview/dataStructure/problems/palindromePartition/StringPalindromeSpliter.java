package com.peter.left.interview.dataStructure.problems.palindromePartition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringPalindromeSpliter
{
    private boolean isPalindrome(final String s, final int start, final int end)
    {
        if (start <= end)
        {
            for (int left = start, right = end; left < right; ++left, --right)
            {
                if (s.charAt(left) != s.charAt(right))
                {
                    return false;
                }
            }
            
            return true;
        }
        
        return false;
    }
    
    public List<List<String>> split(final String s)
    {
        List<List<List<String>>> strs = new ArrayList<>();
        
        strs.add(Collections.singletonList(Collections.emptyList()));

        for (int i = 1; i <= s.length(); ++i)
        {
            List<List<String>> strs_list = new ArrayList<>();
            
            for (int j = 0; j < i; ++j)
            {
                if (isPalindrome(s, j, i - 1))
                {
                    for (final List<String> list : strs.get(j))
                    {
                        final List<String> item = new ArrayList<>(list);
                        item.add(s.substring(j, i));
                        
                        strs_list.add(item);
                    }
                }
            }
            
            strs.add(strs_list);
        }
        
        return strs.get(strs.size() - 1);
    }
}