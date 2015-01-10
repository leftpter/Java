package com.peter.left.interview.epi.chapter15.t12;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

import com.peter.left.interview.epi.chapter15.t1.Node;

public class SolutionTest
{
	private Solution solution = new Solution();
		
	private Node buildTree(final String ...values)
	{
		if (values.length > 0)
		{
			final Node head = new Node(Integer.valueOf(values[0]));
			final Queue<Node> queue = new LinkedList<>();
			queue.add(head);
			for (int i = 1; !queue.isEmpty() && i < values.length; i += 2)
			{
				final Node o = queue.poll();
				if (!values[i].equals("#"))
				{
					o.left = new Node(Integer.valueOf(values[i]));
					queue.add(o.left);
				}
				
				if (!values[i + 1].equals("#"))
				{
					o.right = new Node(Integer.valueOf(values[i + 1]));
					queue.add(o.right);
				}
			}
			
			return head;
		}
		else
		{
			return null;
		}
	}
	
	private void checkDoubleList(final Node head, final int... values)
	{
		Node o;
		int i = 0;
		for (o = head; o != null; o = o.right, ++i)
		{
			assertThat(o.value, equalTo(values[i]));
			if (o.right == null)
			{
				break;
			}
		}
		
		for (; o != null; o = o.left, --i)
		{
			assertThat(o.value, equalTo(values[i]));
		}
	}
	
	@Test
    public void testSingleTree_itShould_returnNull()
    {
		final String[] result = {"1", "#", "#"};
		checkDoubleList(solution.convert(buildTree(result)), 1);
    }
	
	@Test
    public void testSingleLeftTree_itShould_returnExpect()
    {
		final String[] result = {"2", "1", "#", "#", "#"};
		checkDoubleList(solution.convert(buildTree(result)), 1, 2);
    }
	
	@Test
    public void testSingleRightTree_itShould_returnExpect()
    {
		final String[] result = {"1", "#", "2", "#", "#"};
		checkDoubleList(solution.convert(buildTree(result)), 1, 2);
    }
	
	@Test
    public void testLargeTree_itShould_returnExpect()
    {
		final String[] result = {"19", "7", "43", "3", "11", "23", "47",
				"2", "5", "#", "17", "#", "37", "#", "53", "#", "#", "#", "#",
				"13", "#", "29", "#", "#", "#", "#", "#", "#", "#"};
		checkDoubleList(solution.convert(buildTree(result)), 2, 3, 5, 7, 11, 13, 17, 19,
				23, 29, 37, 43, 47, 53);
    }
}
