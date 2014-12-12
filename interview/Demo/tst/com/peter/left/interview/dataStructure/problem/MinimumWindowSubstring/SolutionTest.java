package com.peter.left.interview.dataStructure.problem.MinimumWindowSubstring;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

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
        assertThat(solution.minWindow("ADOBECODEBANC", "ABC"), equalTo("BANC"));
    }
    
}
