package com.peter.left.interview.epi.chapter15.t6;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;

import com.peter.left.interview.epi.chapter15.t1.Node;


public class IterativePreorderSolutionTest {
	private IterativePreorderSolution solution = new IterativePreorderSolution();
	private Node root = buildTree("19", "7", "43", "3", "11", "23", "47",
			"2", "5", "#", "17", "#", "37", "#", "53", "#", "#", "#", "#",
			"13", "#", "29", "#");
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
		final int[] preorder = {1};
		final String[] result = {"1", "#", "#"};
        assertThat(toString(solution.construct(preorder)).toArray(), equalTo(result));
    }
	
	@Test
    public void testSingleLeftTree_itShould_returnExpect()
    {
		final int[] preorder = {3, 2, 1};
		final String[] result = {"3", "2", "#", "1", "#", "#", "#"};
        assertThat(toString(solution.construct(preorder)).toArray(), equalTo(result));
    }
	
	@Test
    public void testSingleRightTree_itShould_returnExpect()
    {
		final int[] preorder = {1, 2, 3};
		final String[] result = {"1", "#", "2", "#", "3", "#", "#"};
        assertThat(toString(solution.construct(preorder)).toArray(), equalTo(result));
    }
	
	@Test
    public void testLargeTree_itShould_returnExpect()
    {
		final int[] preorder = {19, 7, 3, 2, 5, 11, 17, 13, 43, 23, 37, 29, 47, 53};
		final String[] result = {"19", "7", "43", "3", "11", "23", "47",
				"2", "5", "#", "17", "#", "37", "#", "53", "#", "#", "#", "#",
				"13", "#", "29", "#", "#", "#", "#", "#", "#", "#"};
        assertThat(toString(solution.construct(preorder)).toArray(), equalTo(result));
    }
}
