package com.peter.left.interview.epi.chapter8.t6;

import com.peter.left.interview.epi.chapter8.t1.Node;

public class IterativeSolution implements Solution
{
	public Node findOverlapping(final Node head1, final Node head2)
	{
		if (head1 == null || head2 == null)
		{
			return null;
		}
		
		Node end1;
		int len1 = 1;
		for (end1 = head1; end1.next != null; end1 = end1.next)
		{
			++len1;
		}
		
		Node end2;
		int len2 = 1;
		for (end2 = head2; end2.next != null; end2 = end2.next)
		{
			++len2;
		}
		
		if (end1 == end2)
		{
			final Node longer = (len1 > len2) ? head1 : head2;
			final Node shorter = (longer == head1) ? head2 : head1;
			
			Node o1 = longer;
			for (int i = 0; i < Math.abs(len1 - len2); ++i)
			{
				o1 = o1.next;
			}
			
			for (Node o2 = shorter; o1 != o2; o1 = o1.next, o2 = o2.next)
			{
				
			}
			return o1;
		}
		else
		{
			return null;
		}
	}
}
