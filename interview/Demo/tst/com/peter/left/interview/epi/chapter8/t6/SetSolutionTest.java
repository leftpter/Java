package com.peter.left.interview.epi.chapter8.t6;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.peter.left.interview.epi.chapter8.t1.Node;


public class SetSolutionTest {
	private Solution solution = new SetSolution();
	
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
		assertThat(solution.findOverlapping(null, null), nullValue());
	}
	
	@Test
	public void testNoneOverapplingList_itShouldReturn_expected()
	{
		final Node list1 = buildList(1, 2, 3, 4, 5, 6, 7, 8);
		final Node list2 = buildList(1, 2, 3, 4, 5, 6, 7, 8);
		
		assertThat(solution.findOverlapping(list1, list2), nullValue());
	}
	
	@Test
	public void testSubList_itShouldReturn_expected()
	{
		final Node list1 = buildList(1, 2, 3, 4, 5, 6, 7, 8);
		
		assertThat(solution.findOverlapping(list1, findNode(4, list1)), equalTo(findNode(4, list1)));
	}
	
	@Test
	public void testOverapplingAtEnd_itShouldReturn_expected()
	{
		final Node list1 = buildList(1, 2, 3, 4, 5, 6, 7, 8);
		final Node list2 = buildList(1, 2, 3, 4, 5, 6, 7, 8);
		findNode(8, list1).next = findNode(8, list2);
		assertThat(solution.findOverlapping(list1, list2), equalTo(findNode(8, list2)));
	}
	
	@Test
	public void testOverapplingAtMiddle_itShouldReturn_expected()
	{
		final Node list1 = buildList(1, 2, 3, 4, 5, 6, 7, 8);
		final Node list2 = buildList(1, 2, 3, 4);
		findNode(4, list2).next = findNode(5, list1);
		assertThat(solution.findOverlapping(list1, list2), equalTo(findNode(5, list1)));
	}
}
