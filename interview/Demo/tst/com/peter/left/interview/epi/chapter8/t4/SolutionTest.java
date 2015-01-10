package com.peter.left.interview.epi.chapter8.t4;

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
		assertThat(solution.reverseAll(null, 3), nullValue());
	}
	
	@Test
	public void testReverse3Last2_itShouldReturn_expected()
	{
		final Node list = buildList(1, 2, 3, 4, 5, 6, 7, 8);
		checkList(solution.reverseAll(list, 3), 3, 2, 1, 6, 5, 4, 7, 8);
	}
	
	@Test
	public void testReverse3Last1_itShouldReturn_expected()
	{
		final Node list = buildList(1, 2, 3, 4, 5, 6, 7);
		checkList(solution.reverseAll(list, 3), 3, 2, 1, 6, 5, 4, 7);
	}
	
	@Test
	public void testReverse3All_itShouldReturn_expected()
	{
		final Node list = buildList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		checkList(solution.reverseAll(list, 3), 3, 2, 1, 6, 5, 4, 9, 8, 7);
	}
	
	@Test
	public void testReverse100_itShouldReturn_expected()
	{
		final Node list = buildList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		checkList(solution.reverseAll(list, 100), 1, 2, 3, 4, 5, 6, 7, 8, 9);
	}
}
