package com.peter.left.interview.epi.chapter14.t1;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;


public class LinearSolutionTest
{
    final Solution solution = new LinearSolution();
    final int[] empty = {};
    @Test
    public void testNullArray_itShould_returnEmpty()
    {
        final int[] a = {1, 2};
        
        assertThat(solution.intersection(a, null), equalTo(empty));
    }
    
    
    @Test
    public void testEmptyArray_itShould_returnEmpty()
    {
        final int[] a = {};
        final int[] b = {1, 2};
        
        assertThat(solution.intersection(a, b), equalTo(empty));
    }
    
    @Test
    public void testOneArray_itShould_returnTheOne()
    {
        final int[] b = {1, 2};
        
        assertThat(solution.intersection(b, b), equalTo(b));
    }
    
    
    @Test
    public void testtwoArray_itShould_returnIntersection()
    {
        final int[] a = {0, 1};
        final int[] b = {1, 2};
        final int[] result = {1};
        
        assertThat(solution.intersection(a, b), equalTo(result));
    }
    
    @Test
    public void testtwoArray_itShould_returnIntersection2()
    {
        final int[] a = {0, 1, 3, 5, 7, 9};
        final int[] b = {1, 2, 3, 4, 5, 6, 7, 8};
        final int[] result = {1, 3, 5, 7};
        
        assertThat(solution.intersection(a, b), equalTo(result));
    }
    
    @Test
    public void testtwoArray_itShould_returnIntersection3()
    {
        final int[] a = {1, 3, 5, 7, 9};
        final int[] b = {0, 2, 4, 6, 8};
        
        assertThat(solution.intersection(a, b), equalTo(empty));
    }
    
    @Test
    public void testtwoArray_itShould_returnIntersection4()
    {
        final int[] a = {1, 3, 5, 7, 9};
        final int[] b = {-2, -1, 0, 1};
        final int[] result = {1};
        
        assertThat(solution.intersection(a, b), equalTo(result));
    }
}
