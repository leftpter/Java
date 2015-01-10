package com.peter.left.interview.epi.chapter15.t15;

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
	
	
	@Test
    public void testAllSame_itShould_returnTrue()
    {
        assertThat(solution.checkOrder(buildTree("3", "1", "4"), 4, 4, 4), equalTo(true));
    }
	
	@Test
    public void testMAtTop_itShould_returnTrue()
    {
        assertThat(solution.checkOrder(buildTree("3", "1", "4"), 3, 1, 3), equalTo(true));
    }
	
	@Test
    public void testMAtBottom_itShould_returnTrue()
    {
        assertThat(solution.checkOrder(buildTree("3", "1", "4"), 3, 1, 1), equalTo(true));
    }
	
	@Test
    public void testMAtMiddle_itShould_returnTrue()
    {
        assertThat(solution.checkOrder(buildTree("3", "1", "4", "#", "2"), 3, 2, 1), equalTo(true));
    }
	
	@Test
    public void testMAtTop_itShould_returnFalse()
    {
        assertThat(solution.checkOrder(buildTree("3", "1", "4"), 3, 5, 3), equalTo(false));
    }
	
	@Test
    public void testMAtBottom_itShould_returnFalse()
    {
        assertThat(solution.checkOrder(buildTree("3", "1", "4"), 4, 1, 1), equalTo(false));
    }
	
	@Test
    public void testMAtMiddle_itShould_returnFalse()
    {
        assertThat(solution.checkOrder(buildTree("3", "1", "4", "#", "2"), 4, 2, 1), equalTo(false));
    }
}
