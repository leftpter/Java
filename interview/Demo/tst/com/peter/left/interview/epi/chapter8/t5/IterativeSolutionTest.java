package com.peter.left.interview.epi.chapter8.t5;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.peter.left.interview.epi.chapter8.t1.Node;


public class IterativeSolutionTest
{
	private Solution solution = new IterativeSolution();
	
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
	
	private Node buildCycleList(final int start, final int ...values)
	{
		final Node head = new Node(0);
		Node o = head;
		Node first = null;
		for (final int value : values)
		{
			o.next = new Node(value);
			o = o.next;
			
			if (value == start)
			{
				first = o;
			}
		}
		
		o.next = first;
		return head.next;
	}
	
	private Node findNode(final int value, final Node head)
	{
		Node o;
		for (o = head; o != null && o.value != value; o = o.next)
		{
			
		}
		
		return o;
	}
	
	@Test
	public void testEmptyList_itShouldReturn_expected()
	{
		assertThat(solution.findCycle(null), nullValue());
	}
	
	@Test
	public void testNoCycleList_itShouldReturn_expected()
	{
		final Node list = buildList(1, 2, 3, 4, 5, 6, 7);
		assertThat(solution.findCycle(list), nullValue());
	}
	
	@Test
	public void testCycleStartFromLast_itShouldReturn_expected()
	{
		final Node list = buildCycleList(8, 1, 2, 3, 4, 5, 6, 7, 8);
		assertThat(solution.findCycle(list), equalTo(findNode(8, list)));
	}
	
	@Test
	public void testCycleStartFromMiddle_itShouldReturn_expected()
	{
		final Node list = buildCycleList(5, 1, 2, 3, 4, 5, 6, 7, 8);
		assertThat(solution.findCycle(list), equalTo(findNode(5, list)));
	}
}
