package com.peter.left.interview.epi.array1;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Collections;

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
        final int[] values = {3, 2, 2, 1};
        final int[] result = {1, 2, 2, 3};
        solution.quickSort(values, 2);
        assertThat(values, equalTo(result));
    }
    
    @Test
    public void test2()
    {
        final int[] values = {3, 2, 2, 2};
        final int[] result = {2, 2, 2, 3};
        solution.quickSort(values, 2);
        assertThat(values, equalTo(result));
    }
    
    @Test
    public void test3()
    {
        final int[] values = {2, 2, 2, 1};
        final int[] result = {1, 2, 2, 2};
        solution.quickSort(values, 2);
        assertThat(values, equalTo(result));
    }
    
    
    @Test
    public void test4()
    {
        final int[] values = {2, 3, 1, 2};
        final int[] result = {1, 2, 2, 3};
        solution.quickSort(values, 2);
        assertThat(values, equalTo(result));
    }
    
    @Test
    public void test5()
    {
        final int[] values = {3, 2, 1, 2};
        final int[] result = {1, 2, 2, 3};
        solution.quickSort(values, 2);
        assertThat(values, equalTo(result));
    }
}
