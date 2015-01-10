package com.peter.left.interview.epi.chapter8.t16;

import static org.hamcrest.Matchers.equalTo;
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
	
	private Node findNode(final int value, final Node head)
	{
		Node o;
		for (o = head; o != null && o.value != value; o = o.next)
		{
			
		}
		
		return o;
	}
	
	@Test
	public void testSingleList_itShouldReturn_expected()
	{
		final Node head = new Node(0);
		head.next = head;
		assertThat(solution.getMedian(head), equalTo(0));
	}
	
	@Test
	public void testEvenStartMiddleList_itShouldReturn_expected()
	{
		final Node head = buildList(0, 1, 2, 4, 5, 6);
		findNode(6, head).next = head;
		assertThat(solution.getMedian(findNode(4, head)), equalTo(3));
	}
	
	@Test
	public void testEvenStartHeadList_itShouldReturn_expected()
	{
		final Node head = buildList(0, 1, 2, 4, 5, 6);
		findNode(6, head).next = head;
		assertThat(solution.getMedian(head), equalTo(3));
	}
	
	@Test
	public void testEvenStartTailList_itShouldReturn_expected()
	{
		final Node head = buildList(0, 1, 2, 4, 5, 6);
		findNode(6, head).next = head;
		assertThat(solution.getMedian(findNode(6, head)), equalTo(3));
	}
	
	@Test
	public void testOddStartMiddleList_itShouldReturn_expected()
	{
		final Node head = buildList(0, 1, 3, 4, 5);
		findNode(5, head).next = head;
		assertThat(solution.getMedian(findNode(4, head)), equalTo(3));
	}
	
	@Test
	public void testOddStartHeadList_itShouldReturn_expected()
	{
		final Node head = buildList(0, 1, 3, 4, 5);
		findNode(5, head).next = head;
		assertThat(solution.getMedian(head), equalTo(3));
	}
	
	@Test
	public void testOddStartTailList_itShouldReturn_expected()
	{
		final Node head = buildList(0, 1, 3, 4, 5);
		findNode(5, head).next = head;
		assertThat(solution.getMedian(findNode(5, head)), equalTo(3));
	}
}
