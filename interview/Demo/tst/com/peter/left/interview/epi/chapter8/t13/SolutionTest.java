package com.peter.left.interview.epi.chapter8.t13;

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
		solution.zipMerge(null);	
	}
	
	@Test
	public void testSingleList_itS0houldKeep_same()
	{
		final Node head = new Node(0);
		solution.zipMerge(head);
		checkList(head, 0);
	}
	
	@Test
	public void test2ElementsList_itS0houldKeep_same()
	{
		final Node head = buildList(0, 1);
		solution.zipMerge(head);
		checkList(head, 0, 1);
	}
	
	@Test
	public void testOddElementsList_itS0houldReturn_expected()
	{
		final Node head = buildList(0, 1, 2, 3, 4, 5, 6);
		solution.zipMerge(head);
		checkList(head, 0, 6, 1, 5, 2, 4, 3);
	}
	
	@Test
	public void testEvenElementsList_itS0houldReturn_expected()
	{
		final Node head = buildList(0, 1, 2, 3, 4, 5, 6, 7);
		solution.zipMerge(head);
		checkList(head, 0, 7, 1, 6, 2, 5, 3, 4);
	}
}
