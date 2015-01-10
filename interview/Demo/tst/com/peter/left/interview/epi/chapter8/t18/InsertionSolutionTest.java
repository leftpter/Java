package com.peter.left.interview.epi.chapter8.t18;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.peter.left.interview.epi.chapter8.t1.Node;

public class InsertionSolutionTest
{
	private InsertionSolution solution = new InsertionSolution();
	
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
		assertThat(solution.sort(null), nullValue());
	}
	
	@Test
	public void testSingleList_itS0houldKeep_same()
	{
		checkList(solution.sort(new Node(9)), 9);
	}
	
	@Test
	public void testSortedList_itS0houldKeep_same()
	{
		checkList(solution.sort(buildList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)),
				0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
	}
	
	@Test
	public void testReversedList_itS0houldKeep_same()
	{
		checkList(solution.sort(buildList(9, 8, 7, 6, 5, 4, 3, 2, 1, 0)),
				0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
	}
	
	@Test
	public void testDuplicatedItemsList_itS0houldKeep_same()
	{
		checkList(solution.sort(buildList(0, 2, 3, 3, 2, 0, 2, 3, 0)),
				0, 0, 0, 2, 2, 2, 3, 3, 3);
	}
}
