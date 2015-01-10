package com.peter.left.interview.epi.chapter15.t14;

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
    public void testEmptyInsertTree_itShould_returnNull()
    {
		final String[] result = {"1", "#", "#"};
        assertThat(toString(solution.insert(null, 1)).toArray(), equalTo(result));
    }
	
	@Test
    public void testSingleLeftTreeInsert_itShould_returnExpect()
    {
		final String[] result = {"3", "2", "#", "1", "#", "#", "#"};
        assertThat(toString(solution.insert(buildTree("3", "2", "#"), 1)).toArray(), equalTo(result));
    }
	
	@Test
    public void testSingleRightTree_itShould_returnExpect()
    {
		final String[] result = {"1", "#", "2", "#", "3", "#", "#"};
		assertThat(toString(solution.insert(buildTree("1", "#", "2"), 3)).toArray(), equalTo(result));
    }
	
	@Test
    public void testSmallTree_itShould_returnExpect()
    {
		final String[] result = {"2", "1", "3", "#", "#", "#", "#"};
		assertThat(toString(solution.insert(buildTree("2", "1", "#"), 3)).toArray(), equalTo(result));
    }
	
	
	@Test
    public void testSingleLeftTreeRemove_itShould_returnExpect()
    {
		final String[] result = {"3", "2", "#", "#", "#"};
        assertThat(toString(solution.remove(buildTree("3", "2", "#", "1", "#"), 1)).toArray(), equalTo(result));
    }
	
	@Test
    public void testSingleRightTreeRemove_itShould_returnExpect()
    {
		final String[] result = {"1", "#", "2", "#", "#"};
		assertThat(toString(solution.remove(buildTree("1", "#", "2", "#", "3"), 3)).toArray(), equalTo(result));
    }
	
	@Test
    public void testSmallTreeRemove_itShould_returnExpect()
    {
		assertThat(toString(solution.remove(buildTree("4", "2", "6", "1", "3", "5", "7"), 4)).toArray(),
				equalTo(toString(buildTree("6", "2", "7", "1", "3", "#", "#", "#", "#", "#", "5")).toArray()));
    }
}
