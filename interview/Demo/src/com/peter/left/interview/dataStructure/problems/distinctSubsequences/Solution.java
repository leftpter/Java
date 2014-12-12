package com.peter.left.interview.dataStructure.problems.distinctSubsequences;

public class Solution {
    public int numDistinct(String S, String T)
    {
        final int[][] results = new int[T.length()+1][S.length()+1];
        for (int i = 0; i < S.length(); ++i)
        {
            results[0][i] = 1;
        }
        
        for (int i = 0; i < S.length(); ++i)
        {
            for (int j = 0; j < T.length(); ++j)
            {
                if (S.charAt(i) == T.charAt(j))
                {
                    results[j + 1][i + 1] = results[j][i] + results[j + 1][i];
                }
                else
                {
                    results[j + 1][i + 1] = results[j + 1][i];
                }
            }
        }
        
        return results[T.length()][S.length()];
    }
}