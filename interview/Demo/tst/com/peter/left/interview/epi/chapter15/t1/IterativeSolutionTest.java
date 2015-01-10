package com.peter.left.interview.epi.chapter15.t1;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;


public class IterativeSolutionTest
{
	private IterativeSolution solution = new IterativeSolution();
	
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
	
	@Test
    public void testEmptyTreee_itShould_returnTrue()
    {
        assertThat(solution.isBST(null), equalTo(true));
    }
	
	@Test
    public void testSingleTree_itShould_returnTrue()
    {
        assertThat(solution.isBST(new Node(0)), equalTo(true));
    }
	
	@Test
    public void testBSTTree_itShould_returnTrue()
    {
        assertThat(solution.isBST(buildTree("19", "7", "43", "3", "11", "23", "47")), equalTo(true));
    }
	
	@Test
    public void testNoneBSTTree_itShould_returnfalse()
    {
        assertThat(solution.isBST(buildTree("19", "7", "43", "8", "11", "23", "47")), equalTo(false));
    }
}
