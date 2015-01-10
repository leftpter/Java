package com.peter.left.interview.epi.chapter8.t19;

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
	public void testTwoEmptyList_itS0houldReturn_null()
	{
		assertThat(solution.add(null, null), nullValue());	
	}
	
	@Test
	public void testOneEmptyList_itS0houldKeep_same()
	{
		checkList(solution.add(null, buildList(0, 1, 2, 3, 4)), 0, 1, 2, 3, 4);
	}
	
	@Test
	public void test1Add9999List_itS0houldKeep_same()
	{
		checkList(solution.add(new Node(1), buildList(9, 9, 9, 9)), 
				0, 0, 0, 0, 1);
	}
	
	@Test
	public void test9999Add9999List_itS0houldKeep_same()
	{
		checkList(solution.add(buildList(9, 9, 9, 9), buildList(9, 9, 9, 9)),
				8, 9, 9, 9, 1);
	}
}
