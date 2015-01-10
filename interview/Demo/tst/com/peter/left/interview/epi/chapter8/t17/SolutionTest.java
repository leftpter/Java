package com.peter.left.interview.epi.chapter8.t17;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

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
	
	private void checkList(final Node head, final int ...values)
	{
		Node o = head;
		for (final int value : values)
		{
			assertThat(o, notNullValue());
			assertThat(o.value, equalTo(value));
			o = o.next;
		}
		
		assertThat(o, nullValue());
	}
	
	@Test
	public void testEmptyList_itS0houldKeep_same()
	{
		assertThat(solution.pivot(null, 0), nullValue());	
	}
	
	@Test
	public void testSmallSingleList_itS0houldKeep_same()
	{
		checkList(solution.pivot(new Node(-1), 0), -1);
	}
	
	@Test
	public void testEqualSingleList_itS0houldKeep_same()
	{
		checkList(solution.pivot(new Node(0), 0), 0);
	}
	
	@Test
	public void testLargeSingleList_itS0houldKeep_same()
	{
		checkList(solution.pivot(new Node(1), 0), 1);
	}
	
	@Test
	public void testSmallEqualList_itS0houldKeep_same()
	{
		checkList(solution.pivot(buildList(-2, 0, -3, -1, -1), 0),
				-2, -3, -1, -1, 0);
	}
	
	@Test
	public void testEqualLargeSingleList_itS0houldKeep_same()
	{
		checkList(solution.pivot(buildList(2, 10, 0, 10, 1), 0),
				0, 2, 10, 10, 1);
	}
	
	@Test
	public void testSmallLargeSingleList_itS0houldKeep_same()
	{
		checkList(solution.pivot(buildList(2, 10, -1, -20, 1), 0),
				-1, -20, 2, 10, 1);
	}
	
	@Test
	public void testAllSingleList_itS0houldKeep_same()
	{
		checkList(solution.pivot(buildList(0, 2, 10, 0, -1, -20, 1, 0), 0),
				-1, -20, 0, 0, 0, 2, 10, 1);
	}
}
