package com.peter.left.interview.dataStructure.problems.SubstringwithConcatenationofAllWords;

import org.junit.Before;
import org.junit.Test;


public class SolutionTest
{
    private Solution solution;
    
    @Before
    public void setUp()
    {
        solution = new Solution();
    }
    
    @Test
    public void test()
    {
        final String[] words = {"a","a"};
        solution.findSubstring("aaa", words);
    }
}
