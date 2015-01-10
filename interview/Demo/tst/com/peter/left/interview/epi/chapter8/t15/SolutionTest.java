package com.peter.left.interview.epi.chapter8.t15;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import com.peter.left.interview.epi.chapter8.t1.Node;


public class SolutionTest
{
	private Solution solution = new Solution();
	
	private Node buildList(final int ...values)
	{
		final Node head = new Node(0);
		Node o = head;
		for (final int value : values)
		{
			o.next = new Node(value);
			o = o.next;
		}
		return head.next;
	}
	
	@Test
	public void testEmptyList_itS0houldReturn_true()
	{
		assertThat(solution.isPalindrome(null), equalTo(true));	
	}
	
	@Test
	public void testSingleList_itS0houldReturn_true()
	{
		assertThat(solution.isPalindrome(new Node(0)), equalTo(true));	
	}
	
	@Test
	public void testEvenPalindromeList_itS0houldReturn_true()
	{
		assertThat(solution.isPalindrome(buildList(0, 1, 2, 3, 3, 2, 1, 0)), equalTo(true));	
	}
	
	@Test
	public void testOddPalindromeList_itS0houldReturn_true()
	{
		assertThat(solution.isPalindrome(buildList(0, 1, 2, 3, 2, 1, 0)), equalTo(true));	
	}
	
	@Test
	public void testNoneEvenPalindromeList_itS0houldReturn_false()
	{
		assertThat(solution.isPalindrome(buildList(0, 1, 2, 3, 4, 2, 1, 0)), equalTo(false));	
	}
	
	@Test
	public void testNoneOddPalindromeList_itS0houldReturn_false()
	{
		assertThat(solution.isPalindrome(buildList(0, 1, 2, 3, 4, 1, 0)), equalTo(false));	
	}
}
