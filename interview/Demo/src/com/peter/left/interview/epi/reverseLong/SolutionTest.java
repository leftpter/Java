package com.peter.left.interview.epi.reverseLong;

import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;

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
        assertThat(solution.reverse(1l), equalTo(Long.MIN_VALUE));
    }
    
    @Test
    public void testMaxValue()
    {
        assertThat(solution.reverse(Long.MAX_VALUE), equalTo(0xfffffffffffffffeL));
    }
    
    @Test
    public void test0()
    {
        assertThat(solution.reverse(0l), equalTo(0l));
    }
}
