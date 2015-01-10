package com.peter.left.interview.epi.chapter8.t2;

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
	public void testTwoNullArray_itShouldReturn_Null()
	{
		assertThat(solution.reverse(null), nullValue());
	}
	
	@Test
	public void testOneNullArray_itShouldReturn_OtherArray()
	{
		final Node list = buildList(1, 2, 3, 4, 5, 6, 7, 8);
		checkList(solution.reverse(list), 8, 7, 6, 5, 4, 3, 2, 1);
	}
}
