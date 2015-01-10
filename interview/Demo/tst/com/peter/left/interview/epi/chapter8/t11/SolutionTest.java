package com.peter.left.interview.epi.chapter8.t11;

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
	public void testShiftList_itS0houldKeep_same()
	{
		checkList(solution.rightShift(buildList(0, 1, 2, 3), 0), 0, 1, 2, 3);
	}
	
	@Test
	public void testShiftCycleList_itS0houldKeep_same()
	{
		checkList(solution.rightShift(buildList(0, 1, 2, 3), 4 * 200), 0, 1, 2, 3);
	}
	
	@Test
	public void testShift1CycleList_itS0houldReturn_expected()
	{
		checkList(solution.rightShift(buildList(0, 1, 2, 3), 4 * 200 + 1), 3, 0, 1, 2);
	}
	
	@Test
	public void testShift2CycleList_itS0houldReturn_expected()
	{
		checkList(solution.rightShift(buildList(0, 1, 2, 3), 4 * 200 + 2), 2, 3, 0, 1);
	}
	
	@Test
	public void testShift3CycleList_itS0houldReturn_expected()
	{
		checkList(solution.rightShift(buildList(0, 1, 2, 3), 4 * 200 + 3), 1, 2, 3, 0);
	}
	
	@Test
	public void testShift_1CycleList_itS0houldReturn_expected()
	{
		checkList(solution.rightShift(buildList(0, 1, 2, 3), -4 * 200 - 1), 1, 2, 3, 0);
	}
	
	@Test
	public void testShift_2CycleList_itS0houldReturn_expected()
	{
		checkList(solution.rightShift(buildList(0, 1, 2, 3), -4 * 200 - 2), 2, 3, 0, 1);
	}
	
	@Test
	public void testShift_3CycleList_itS0houldReturn_expected()
	{
		checkList(solution.rightShift(buildList(0, 1, 2, 3), -4 * 200 - 3), 3, 0, 1, 2);
	}
}
