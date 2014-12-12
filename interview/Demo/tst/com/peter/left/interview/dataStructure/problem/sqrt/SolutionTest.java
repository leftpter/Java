package com.peter.left.interview.dataStructure.problem.sqrt;

import static org.hamcrest.Matchers.*;

import static org.junit.Assert.*;
import org.junit.*;

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
        assertThat(solution.sqrt(2147395599), equalTo(46339));
    }
    
    @Test
    public void test1()
    {
        assertThat(solution.sqrt(2147483647), equalTo(46340));
    }
}
