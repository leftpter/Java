package com.peter.left.interview.epi.chapter15.t3;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

import com.peter.left.interview.epi.chapter15.t1.Node;

public class RecursiveSolutionTest
{
	private RecursiveSolution solution = new RecursiveSolution();
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
        assertThat(solution.geteSuccessor(root, 100), nullValue());
    }
	
	@Test
    public void test19_itShould_returnExpect()
    {
        assertThat(solution.geteSuccessor(root, 19), equalTo(root.right.left));
    }
	
	@Test
    public void test2_itShould_returnExpect()
    {
        assertThat(solution.geteSuccessor(root, 2), equalTo(root.left.left));
    }
	
	@Test
    public void test53_itShould_returnExpect()
    {
        assertThat(solution.geteSuccessor(root, 53), nullValue());
    }
	
	@Test
    public void test17_itShould_returnExpect()
    {
        assertThat(solution.geteSuccessor(root, 17), equalTo(root));
    }
}
