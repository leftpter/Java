package com.peter.left.interview.epi.chapter8.t3;

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
		assertThat(solution.reverseSubList(null, 0, 100), null);
	}
	
	@Test
	public void testReverseFrom0To100_itShouldReturn_expected()
	{
		final Node list = buildList(1, 2, 3, 4, 5, 6, 7, 8);
		checkList(solution.reverseSubList(list, 0, 100), 8, 7, 6, 5, 4, 3, 2, 1);
	}
	
	@Test
	public void testReverseFrom0To1_itShouldReturn_expected()
	{
		final Node list = buildList(1, 2, 3, 4, 5, 6, 7, 8);
		checkList(solution.reverseSubList(list, 0, 1), 2, 1, 3, 4, 5, 6, 7, 8);
	}
	@Test
	public void testReverseFrom2To5_itShouldReturn_expected()
	{
		final Node list = buildList(1, 2, 3, 4, 5, 6, 7, 8);
		checkList(solution.reverseSubList(list, 2, 5), 1, 2, 6, 5, 4, 3, 7, 8);
	}
	
	@Test
	public void testReverseFrom6To100_itShouldReturn_expected()
	{
		final Node list = buildList(1, 2, 3, 4, 5, 6, 7, 8);
		checkList(solution.reverseSubList(list, 6, 100), 1, 2, 3, 4, 5, 6, 8, 7);
	}
	
	@Test
	public void testReverseFrom7To100_itShouldReturn_expected()
	{
		final Node list = buildList(1, 2, 3, 4, 5, 6, 7, 8);
		checkList(solution.reverseSubList(list, 7, 100), 1, 2, 3, 4, 5, 6, 7, 8);
	}
}
