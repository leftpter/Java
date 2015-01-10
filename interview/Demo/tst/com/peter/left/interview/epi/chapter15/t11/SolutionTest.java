package com.peter.left.interview.epi.chapter15.t11;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;

import com.peter.left.interview.epi.chapter15.t1.Node;

public class SolutionTest
{
	private Solution solution = new Solution();
	
	private Node buildDoubleList(final int ...values)
	{
		if (values.length > 0)
		{
			final Node head = new Node(values[0]);
			Node prev = head;
			for (int i = 1; i < values.length; ++i)
			{
				final Node current = new Node(values[i]);
				prev.right = current;
				current.left = prev;
				prev = current;
			}
			
			return head;
		}
		else
		{
			return null;
		}
	}
	
	private List<String> toString(final Node root)
	{
		final List<String> result = new ArrayList<>();
		final Queue<Node> queue = new LinkedList<>();
		
		if (root != null)
		{
			queue.offer(root);
			
			while (!queue.isEmpty())
			{
				final Node o = queue.poll();
				if (o != null)
				{
					result.add(String.valueOf(o.value));
					queue.offer(o.left);
					queue.offer(o.right);
				}
				else
				{
					result.add("#");
				}
			}
		}
		
		return result;
	}
	
	@Test
    public void testSingleTree_itShould_returnNull()
    {
		final String[] result = {"1", "#", "#"};
        assertThat(toString(solution.convert(buildDoubleList(1))).toArray(), equalTo(result));
    }
	
	@Test
    public void testSingleLeftTree_itShould_returnExpect()
    {
		final String[] result = {"2", "1", "#", "#", "#"};
        assertThat(toString(solution.convert(buildDoubleList(1, 2))).toArray(), equalTo(result));
    }
	
	@Test
    public void testSingleRightTree_itShould_returnExpect()
    {
		final String[] result = {"3", "2", "#", "#", "#"};
        assertThat(toString(solution.convert(buildDoubleList(2, 3))).toArray(), equalTo(result));
    }
	
	@Test
    public void testLargeTree_itShould_returnExpect()
    {
		final String[] result = {"2", "1", "3", "#", "#", "#", "#"};
        assertThat(toString(solution.convert(buildDoubleList(1, 2, 3))).toArray(), equalTo(result));
    }
}
