package com.peter.left.interview.epi.chapter8.t7;

import com.peter.left.interview.epi.chapter8.t1.Node;

public class IterativeSolution implements Solution
{
	private Node findCycleHead(final Node head)
	{
		Node fast;
		Node slow;
		for (fast = head, slow = head; fast != null && fast.next != null; )
		{
			slow = slow.next;
			fast = fast.next;
			fast = fast.next;
			
			if (slow == fast)
			{
				break;
			}
		}
		
		if (slow == fast)
		{
			int len;
			for (len = 1, fast = fast.next; slow != fast; fast = fast.next)
			{
				++len;
			}
			
			fast = head;
			for (int i = 0; i < len; ++i)
			{
				fast = fast.next;
			}
			
			for (slow = head; fast != slow; slow = slow.next)
			{
				fast = fast.next;
			}
		}
		else
		{
			fast = null;
		}
		
		return fast;
	}
	
	
	private Node findOverlappingBefore(final Node head1, final Node head2, final Node end)
	{
		int len1 = 0;
		for (Node o = head1; o != end; o = o.next)
		{
			++len1;
		}
		
		int len2 = 0;
		for (Node o = head2; o != end; o = o.next)
		{
			++len2;
		}
		
		final Node longer = (len1 > len2) ? head1 : head2;
		final Node shorter = (longer == head1) ? head2 : head1;
		
		Node o1 = longer;
		for (int i = 0; i < Math.abs(len1 - len2); ++i)
		{
			o1 = o1.next;
		}
		
		for (Node o2 = shorter; o1 != o2; o1 = o1.next)
		{
			o2 = o2.next;
		}
		
		return o1;
	}
	
	@Override
	public Node findOverlapping(final Node head1, final Node head2)
	{
		if (head1 == null || head2 == null)
		{
			return null;
		}
		
		final Node c1 = findCycleHead(head1);
		final Node c2 = findCycleHead(head2);
		
		if (c1 == c2)
		{
			if (c1 != null)
			{
				// Overlapping before cycle.
				return findOverlappingBefore(head1, head2, c1);
			}
			else
			{
				// Both without cycle.
				Node end;
				for (end = head1; end.next != null; end = end.next)
				{
					
				}
				
				Node o;
				for (o = head2; o != null && o != end; o = o.next)
				{
					
				}
				
				return (o == null) ? null : findOverlappingBefore(head1, head2, end);
			}
		}
		else
		{
			if (c1 == null || c2 == null)
			{
				return null;
			}
			else
			{
				// Both has cycle.
				Node o;
				// Check whether the cycle is same.
				for (o = c1.next; o != c1 && o != c2; o = o.next)
				{
					
				}
				
				// Cycle is not same, return null, otherwise return c1.
				return (o == c1) ? null : c1;
			}
		}
		
	}
}
