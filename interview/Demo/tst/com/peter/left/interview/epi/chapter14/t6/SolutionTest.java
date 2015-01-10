package com.peter.left.interview.epi.chapter14.t6;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.peter.left.interview.epi.chapter14.t5.Interval;


public class SolutionTest
{
	private Solution solution = new Solution();
	@Test
    public void testEnd_itShould_returnExpect()
    {
		final Interval a[] = {new Interval(0, 1), new Interval(2, 3),
    			new Interval(4, 5), new Interval(6, 7), new Interval(8, 9)};
		final Interval result[] = {new Interval(0, 1), new Interval(2, 3),
    			new Interval(4, 5), new Interval(6, 7), new Interval(8, 9), new Interval(10, 19)};
		
        assertThat(solution.add(a, new Interval(10, 19)), equalTo(result));
    }
	
	@Test
    public void testHead_itShould_returnExpect()
    {
		final Interval a[] = {new Interval(0, 1), new Interval(2, 3),
    			new Interval(4, 5), new Interval(6, 7), new Interval(8, 9)};
		final Interval result[] = {new Interval(-2, -1), new Interval(0, 1), new Interval(2, 3),
    			new Interval(4, 5), new Interval(6, 7), new Interval(8, 9)};
		
        assertThat(solution.add(a, new Interval(-2, -1)), equalTo(result));
    }
	
	@Test
    public void testWhole_itShould_returnExpect()
    {
		final Interval a[] = {new Interval(0, 1), new Interval(2, 3),
    			new Interval(4, 5), new Interval(6, 7), new Interval(8, 9)};
		final Interval result[] = {new Interval(0, 9)};
		
        assertThat(solution.add(a, new Interval(0, 8)), equalTo(result));
    }
	
	@Test
    public void testWhole2_itShould_returnExpect()
    {
		final Interval a[] = {new Interval(0, 1), new Interval(2, 3),
    			new Interval(4, 5), new Interval(6, 7), new Interval(8, 9)};
		final Interval result[] = {new Interval(-1, 9)};
		
        assertThat(solution.add(a, new Interval(-1, 8)), equalTo(result));
    }
	
	@Test
    public void testWhole3_itShould_returnExpect()
    {
		final Interval a[] = {new Interval(0, 1), new Interval(2, 3),
    			new Interval(4, 5), new Interval(6, 7), new Interval(8, 9)};
		final Interval result[] = {new Interval(0, 9)};
		
        assertThat(solution.add(a, new Interval(1, 8)), equalTo(result));
    }
	
	@Test
    public void testPart_itShould_returnExpect()
    {
		final Interval a[] = {new Interval(0, 1),
    			new Interval(4, 5), new Interval(6, 7), new Interval(8, 9)};
		final Interval result[] = {new Interval(0, 1), new Interval(2, 9)};
		
        assertThat(solution.add(a, new Interval(2, 8)), equalTo(result));
    }
	
	@Test
    public void testPart2_itShould_returnExpect()
    {
		final Interval a[] = {new Interval(0, 1),
    			new Interval(4, 5), new Interval(6, 7), new Interval(8, 9)};
		final Interval result[] = {new Interval(0, 1), new Interval(4, 7), new Interval(8, 9)};
		
        assertThat(solution.add(a, new Interval(5, 6)), equalTo(result));
    }
}
