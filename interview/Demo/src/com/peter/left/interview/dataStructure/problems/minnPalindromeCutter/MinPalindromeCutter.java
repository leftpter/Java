package com.peter.left.interview.dataStructure.problems.minnPalindromeCutter;

public class MinPalindromeCutter
{
    private boolean isPalindrome(final String s)
    {
        boolean bRet = true;
        for (int left = 0, right = s.length() - 1; left < right; ++left, --right)
        {
            if (s.charAt(left) != s.charAt(right))
            {
                bRet = false;
                break;
            }
        }
        
        return bRet;
    }
    
    public int cut(final String s)
    {
        int minCut;
        if (isPalindrome(s))
        {
            minCut = 0;
        }
        else
        {
            minCut = Integer.MAX_VALUE;
            for (int i = 1; i <= s.length() - 1; ++i)
            {
                final String left = s.substring(0, i);
                if (isPalindrome(left))
                {
                    final int rightCut = cut(s.substring(i));
                    minCut = Math.min(1 + rightCut, minCut);
                }
            }
        }
        
        return minCut;
    }
}
