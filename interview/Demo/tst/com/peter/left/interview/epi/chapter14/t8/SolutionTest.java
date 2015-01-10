package com.peter.left.interview.epi.chapter14.t8;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;



public class SolutionTest
{
	private Solution solution = new Solution();
	@Test
    public void test2separate_itShould_returnExpect()
    {
		final Interval a[] = {new Interval(1, 2), new Interval(3, 4), };
		final int b[] = {2, 4};
        assertThat(solution.findMinSet(a), equalTo(b));
    }
	
	@Test
    public void test2Intersection_itShould_returnExpect()
    {
		final Interval a[] = {new Interval(1, 2), new Interval(2, 4), };
		final int b[] = {2};
        assertThat(solution.findMinSet(a), equalTo(b));
    }
	
	@Test
    public void test4Intersection_itShould_returnExpect()
    {
		final Interval a[] = {new Interval(1, 2), new Interval(1, 1),
				new Interval(1, 100), new Interval(1, 10)};
		final int b[] = {1};
        assertThat(solution.findMinSet(a), equalTo(b));
    }
	
	@Test
    public void test2SeparateIntersection_itShould_returnExpect()
    {
		final Interval a[] = {new Interval(1, 2), new Interval(1, 1),
				new Interval(2, 100), new Interval(3, 10)};
		final int b[] = {1, 10};
        assertThat(solution.findMinSet(a), equalTo(b));
    }
}
