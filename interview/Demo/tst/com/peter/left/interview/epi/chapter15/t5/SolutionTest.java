package com.peter.left.interview.epi.chapter15.t5;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

import com.peter.left.interview.epi.chapter15.t1.Node;


public class SolutionTest
{
	private Solution solution = new Solution();
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
	
	@Test
    public void testNoneExist_itShould_returnNull()
    {
        assertThat(solution.getLCA(root, root.left.left.left, 
        		root.right.right.right),
        		equalTo(root));
    }
	
	@Test
    public void test0_itShould_returnExpect()
    {
        assertThat(solution.getLCA(root, root.left.left,
        		root.left.right.right.left), equalTo(root.left));
    }
	
	@Test
    public void test2_itShould_returnExpect()
    {
        assertThat(solution.getLCA(root, root.left.left, root.left.left.right),
        		equalTo(root.left.left));
    }
}