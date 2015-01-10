package com.peter.left.interview.epi.chapter8.t10;

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
	public void testNoneDupliatedList_itShouldKeep_same()
	{
		final Node head = buildList(1, 2, 3, 4, 5, 6, 7, 8);
		solution.removeDuplicated(head);
		checkList(head, 1, 2, 3, 4, 5, 6, 7, 8);
	}
	
	@Test
	public void testAllDuplidatedList_itShouldReturn_Expected()
	{
		final Node head = buildList(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8);
		solution.removeDuplicated(head);
		checkList(head, 1, 2, 3, 4, 5, 6, 7, 8);
	}
	
	@Test
	public void testHeadDuplidatedList_itShouldReturn_Expected()
	{
		final Node head = buildList(1, 1, 2, 3, 4, 5, 6, 7, 8);
		solution.removeDuplicated(head);
		checkList(head, 1, 2, 3, 4, 5, 6, 7, 8);
	}
	
	@Test
	public void testTailDuplidatedList_itShouldReturn_Expected()
	{
		final Node head = buildList(1, 2, 3, 4, 5, 6, 7, 8, 8);
		solution.removeDuplicated(head);
		checkList(head, 1, 2, 3, 4, 5, 6, 7, 8);
	}
	
	@Test
	public void testMiddleDuplidatedList_itShouldReturn_Expected()
	{
		final Node head = buildList(1, 2, 3, 4, 5, 5, 6, 7, 8);
		solution.removeDuplicated(head);
		checkList(head, 1, 2, 3, 4, 5, 6, 7, 8);
	}
}
