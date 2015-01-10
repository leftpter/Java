package com.peter.left.interview.epi.chapter14.t7;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;


public class SolutionTest
{
	private Solution solution = new Solution();
	@Test
    public void test2separate_itShould_returnExpect()
    {
		final Interval a[] = {new Interval(1, false, 2, true), new Interval(0, true, 1, false), };
		
        assertThat(solution.union(a), equalTo(a));
    }
	
	@Test
    public void test2Overlapping_itShould_returnExpect()
    {
		final Interval a[] = {new Interval(0, true, 1, true), new Interval(1, false, 2, true)};
		final Interval b[] = {new Interval(0, true, 2, true)};
		
        assertThat(solution.union(a), equalTo(b));
    }
	
	@Test
    public void test2Overlapping2_itShould_returnExpect()
    {
		final Interval a[] = {new Interval(0, true, 100, true), new Interval(1, false, 2, true)};
		final Interval b[] = {new Interval(0, true, 2, true)};
		
        assertThat(solution.union(a), equalTo(b));
    }
}
