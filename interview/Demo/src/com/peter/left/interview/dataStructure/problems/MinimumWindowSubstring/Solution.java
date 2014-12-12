package com.peter.left.interview.dataStructure.problems.MinimumWindowSubstring;

public class Solution
{
    public String minWindow(String S, String T)
    {
        if (T.equals("") || S.length() < T.length())
        {
            return "";
        }
        
        final int[] chars = new int[128];
        final boolean[] required = new boolean[128];
        int num = 0;
        for (int i = 0; i < T.length(); ++i)
        {
            int index = (int) T.charAt(i);
            if (chars[index] == 0)
            {
                required[index] = true;
                ++num;
            }
            ++chars[index];
        }
        
        int min = Integer.MAX_VALUE;
        String result = "";
        for (int start = 0, i = 0; i < S.length(); ++i)
        {
            int index = (int) S.charAt(i);
            
            if (required[index])
            {
                --chars[index];
                if (chars[index] == 0)
                {
                    --num;
                }
                
                for (; start < i && (!required[S.charAt(start)] || chars[S.charAt(start)] < 0); ++start)
                {
                    ++chars[S.charAt(start)];
                }
                
                if (num == 0 && (i - start + 1) < min)
                {
                    min = i - start + 1;
                    result = S.substring(start, i + 1);
                }
            }
        }
        
        return result;
    }
}
