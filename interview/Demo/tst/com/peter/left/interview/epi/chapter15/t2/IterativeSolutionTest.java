package com.peter.left.interview.epi.chapter15.t2;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

import com.peter.left.interview.epi.chapter15.t1.Node;


public class IterativeSolutionTest
{
	private IterativeSolution solution = new IterativeSolution();
	private Node root = buildTree("108", "108", "285", "-10", "108", "243", "285", 
			"-14", "2", "#", "#", "#", "#", "#", "401");
	
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
    public void testSear108_itShould_returnTrue()
    {
        assertThat(solution.search(root, 108), equalTo(root.left));
    }
	
	@Test
    public void testSear285_itShould_returnTrue()
    {
        assertThat(solution.search(root, 285), equalTo(root.right));
    }
	
	@Test
    public void testSear143_itShould_returnTrue()
    {
        assertThat(solution.search(root, 143), nullValue());
    }
}
