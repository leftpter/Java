package com.peter.left.interview.epi.chapter8.t9;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.peter.left.interview.epi.chapter8.t1.Node;


public class SolutionTest
{
	final Solution solution = new Solution();
	
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
	public void testEmptyList_itShouldReturn_expected()
	{
		assertThat(solution.remove(null, 2), nullValue());
	}
	
	@Test
	public void RmovesingleList_itShouldReturn_expected()
	{
		assertThat(solution.remove(new Node(1), 1), nullValue());
	}
	
	@Test
	public void RmovesingleErrorList_itShouldReturn_expected()
	{
		checkList(solution.remove(new Node(1), 2), 1);
	}
	
	@Test
	public void RmoveHeadElement_itShouldReturn_expected()
	{
		checkList(solution.remove(buildList(1, 2, 3, 4, 5), 5), 2, 3, 4, 5);
	}
	
	@Test
	public void RmoveTailElement_itShouldReturn_expected()
	{
		checkList(solution.remove(buildList(1, 2, 3, 4, 5), 1), 1, 2, 3, 4);
	}
	
	@Test
	public void RmoveMiddleElement_itShouldReturn_expected()
	{
		checkList(solution.remove(buildList(1, 2, 3, 4, 5), 3), 1, 2, 4, 5);
	}
}
