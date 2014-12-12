package com.peter.left.interview.epi.array3;

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
        assertThat(solution.multiply("-111", "9"), equalTo("-999"));
    }
    
    @Test
    public void test2()
    {
        assertThat(solution.multiply("-111", "19"), equalTo("-2109"));
    }
    
    @Test
    public void test3()
    {
        assertThat(solution.multiply("-111", "-19"), equalTo("2109"));
    }
    
    @Test
    public void test4()
    {
        assertThat(solution.multiply("-193707721", "-761838257287"), equalTo("147573952589676412927"));
    }
    
    @Test
    public void test5()
    {
        assertThat(solution.multiply("-193707721", "-100"), equalTo("19370772100"));
    }
}
