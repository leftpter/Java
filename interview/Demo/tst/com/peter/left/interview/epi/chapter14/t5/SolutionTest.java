package com.peter.left.interview.epi.chapter14.t5;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class SolutionTest
{
	final Solution solution = new Solution();
	
    @Test
    public void testNullArray_itShould_return0()
    {   
        assertThat(solution.findMaxIntersection(null), equalTo(0));
    }
    
    @Test
    public void testEmptyArray_itShould_return0()
    {
    	final Interval a[] = {};
    	
    	assertThat(solution.findMaxIntersection(a), equalTo(0));
    }
    
    @Test
    public void testSingleArray_itShould_return1()
    {
    	final Interval a[] = {new Interval(0, 1)};
    	
    	assertThat(solution.findMaxIntersection(a), equalTo(1));
    }
    
    @Test
    public void testIntersectionTwoElements_itShould_return2()
    {
    	final Interval a[] = {new Interval(0, 2), new Interval(1, 2)};
    	
    	assertThat(solution.findMaxIntersection(a), equalTo(2));
    }
    
    @Test
    public void testNoneIntersectionTwoElements_itShould_return1()
    {
    	final Interval a[] = {new Interval(0, 2), new Interval(2, 3)};
    	
    	assertThat(solution.findMaxIntersection(a), equalTo(1));
    }
    
    @Test
    public void testAllIntersectionMultipleElements_itShould_returnArrayLength()
    {
    	final Interval a[] = {new Interval(0, 100), new Interval(2, 3),
    			new Interval(3, 4), new Interval(5, 6), new Interval(7, 8)};
    	
    	assertThat(solution.findMaxIntersection(a), equalTo(a.length));
    }
    
    @Test
    public void testAllSameMultipleElements_itShould_returnArrayLength()
    {
    	final Interval a[] = {new Interval(0, 1), new Interval(0, 1),
    			new Interval(0, 1), new Interval(0, 1), new Interval(0, 1),
    			new Interval(0, 1), new Interval(0, 1), new Interval(0, 1)};
    	
    	assertThat(solution.findMaxIntersection(a), equalTo(a.length));
    }
    
    @Test
    public void testAllNoneIntervalElements_itShould_return1()
    {
    	final Interval a[] = {new Interval(0, 1), new Interval(1, 2),
    			new Interval(4, 5), new Interval(3, 4), new Interval(2, 3),
    			new Interval(8, 9), new Interval(5, 6), new Interval(6, 7)};
    	
    	assertThat(solution.findMaxIntersection(a), equalTo(1));
    }
    
    @Test
    public void test2IntersectionElements_itShould_return2()
    {
    	final Interval a[] = {new Interval(0, 1), new Interval(0, 2),
    			new Interval(4, 5), new Interval(3, 4), new Interval(2, 3),
    			new Interval(8, 9), new Interval(5, 6), new Interval(6, 7)};
    	
    	assertThat(solution.findMaxIntersection(a), equalTo(2));
    }
    
    @Test
    public void test2IntersectionWithStartingElements_itShould_return2()
    {
    	final Interval a[] = {new Interval(0, 1), new Interval(0, 4),
    			new Interval(4, 5), new Interval(3, 4), new Interval(2, 3),
    			new Interval(8, 9), new Interval(5, 6), new Interval(6, 7)};
    	
    	assertThat(solution.findMaxIntersection(a), equalTo(4));
    }
    
    @Test
    public void test7IntersectionWithStartingElements_itShould_return7()
    {
    	final Interval a[] = {new Interval(0, 1), new Interval(4, 4),
    			new Interval(4, 5), new Interval(4, 4), new Interval(4, 5),
    			new Interval(4, 9), new Interval(4, 6), new Interval(4, 7)};
    	
    	assertThat(solution.findMaxIntersection(a), equalTo(7));
    }
    
    @Test
    public void test7IntersectionWithStartingElements2_itShould_return7()
    {
    	final Interval a[] = {new Interval(100, 111), new Interval(4, 4),
    			new Interval(4, 5), new Interval(4, 4), new Interval(4, 5),
    			new Interval(4, 9), new Interval(4, 6), new Interval(4, 7)};
    	
    	assertThat(solution.findMaxIntersection(a), equalTo(7));
    }
    
    @Test
    public void test3IntersectionElements2_itShould_return3()
    {
    	final Interval a[] = {new Interval(1, 3), new Interval(2, 4),
    			new Interval(3, 5)};
    	
    	assertThat(solution.findMaxIntersection(a), equalTo(2));
    }
}
