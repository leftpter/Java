package com.peter.left.interview.epi.rectIntersect;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;
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
        assertThat(solution.intersect(new Rect(1, 1, 1, 1), new Rect(0, 0, 2, 2)), 
                equalTo(new Rect(1, 1, 1, 1)));
    }
    
    @Test
    public void test2()
    {
        assertThat(solution.intersect(new Rect(0, 0, 2, 2), new Rect(1, 1, 1, 1)), 
                equalTo(new Rect(1, 1, 1, 1)));
    }
    
    @Test
    public void test3()
    {
        assertThat(solution.intersect(new Rect(1, 1, 1, 1), new Rect(0, 0, 2, 1)), 
                nullValue());
    }
    
    @Test
    public void test4()
    {
        assertThat(solution.intersect(new Rect(1, 1, 1, 1), new Rect(1, 2, 1, 1)), 
                nullValue());
    }
    
    @Test
    public void test5()
    {
        assertThat(solution.intersect(new Rect(1, 1, 1, 1), new Rect(2, 1, 1, 1)), 
                nullValue());
    }
    
    @Test
    public void test6()
    {
        assertThat(solution.intersect(new Rect(0, 0, 2, 2), new Rect(1, 1, 1, 1)), 
                equalTo(new Rect(1, 1, 1, 1)));
    }
    
    @Test
    public void test7()
    {
        assertThat(solution.intersect(new Rect(0, 0, 2, 2), new Rect(1, 1, 2, 2)), 
                equalTo(new Rect(1, 1, 1, 1)));
    }
    
    @Test
    public void test8()
    {
        assertThat(solution.intersect(new Rect(0, 0, 2, 2), new Rect(-1, -1, 2, 2)), 
                equalTo(new Rect(0, 0, 1, 1)));
    }
}
