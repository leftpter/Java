package com.peter.left.interview.epi.chapter15.t7;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class SolutionTest
{
	private Solution solution = new Solution();
	@Test
    public void testSingleArrays_itShould_returnExpect()
    {
		final int[] a = {0};
		final int[] b = {1};
		final int[] c = {2};
		final int[] result = {0, 1, 2};
        assertThat(solution.minDistance(a, b, c), equalTo(result));
    }
	
	@Test
    public void testHasEqualElement_itShould_returnExpect()
    {
		final int[] a = {-100, -90, -80, -70, -60, -50, -40, -30, -20, -10, 0};
		final int[] b = {0};
		final int[] c = {0, 1, 2, 3, 4, 5, 6, 7};
		final int[] result = {0, 0, 0};
        assertThat(solution.minDistance(a, b, c), equalTo(result));
    }
	
	@Test
    public void testHasEqualElement2_itShould_returnExpect()
    {
		final int[] a = {-100, -90, -80, -70, -60, -50, -40, -30, -20, -10, 0};
		final int[] b = {-10, -8, -7, -5, -4, 0, 1, 2, 3, 4};
		final int[] c = {0, 1, 2, 3, 4, 5, 6, 7};
		final int[] result = {0, 0, 0};
        assertThat(solution.minDistance(a, b, c), equalTo(result));
    }
	
	@Test
    public void testNotHasEqualElement2_itShould_returnExpect()
    {
		final int[] a = {-100, -90, -80, -70, -60, -50, -40, -30, -20, -10, -1};
		final int[] b = {-10, -8, -7, -5, -4, 0, 2, 3, 4};
		final int[] c = {1, 12, 13, 14, 15, 16, 17};
		final int[] result = {-1, 0, 1};
        assertThat(solution.minDistance(a, b, c), equalTo(result));
    }
}
