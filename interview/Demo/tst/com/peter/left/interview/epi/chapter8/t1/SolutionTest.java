package com.peter.left.interview.epi.chapter8.t1;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

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
		assertThat(solution.merge(null, null), nullValue());
	}
	
	@Test
	public void testOneNullArray_itShouldReturn_OtherArray()
	{
		final Node list = buildList(1, 2, 3, 4, 5, 6, 7, 8);
		checkList(solution.merge(list, null), 1, 2, 3, 4, 5, 6, 7, 8);
		checkList(solution.merge(null, list), 1, 2, 3, 4, 5, 6, 7, 8);
	}
	
	@Test
	public void testOneAfterOther_itShouldReturn_expected()
	{
		final Node list1 = buildList(1, 2, 3, 4, 5, 6, 7, 8);
		final Node list2 = buildList(0);
		checkList(solution.merge(list1, list2), 0, 1, 2, 3, 4, 5, 6, 7, 8);
	}
	
	@Test
	public void testDuplicated_itShouldReturn_expected()
	{
		final Node list1 = buildList(1, 2, 3, 4, 5, 6, 7, 8);
		final Node list2 = buildList(1, 2, 3, 4, 5, 6, 7, 8);
		checkList(solution.merge(list1, list2), 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8);
	}
	
	@Test
	public void testTwoNormal_itShouldReturn_expected()
	{
		final Node list1 = buildList(1, 3, 5, 7);
		final Node list2 = buildList(2, 4, 6, 8);
		checkList(solution.merge(list1, list2), 1, 2, 3, 4, 5, 6, 7, 8);
	}
}
