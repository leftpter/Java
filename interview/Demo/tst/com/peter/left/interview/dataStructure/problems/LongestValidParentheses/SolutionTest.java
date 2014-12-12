package com.peter.left.interview.dataStructure.problems.LongestValidParentheses;

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
    public void test1()
    {
        assertThat(solution.longestValidParentheses(")"), equalTo(2));
    }
}
