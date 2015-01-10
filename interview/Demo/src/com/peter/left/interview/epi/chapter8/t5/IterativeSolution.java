package com.peter.left.interview.epi.chapter8.t5;

import com.peter.left.interview.epi.chapter8.t1.Node;

public class IterativeSolution implements Solution
{

	@Override
	public Node findCycle(Node head)
	{
		Node slow;
		Node fast;
		for (slow = head, fast = head; fast != null && fast.next != null; )
		{
			fast = fast.next;
			fast = fast.next;
			slow = slow.next;
			if (fast == slow)
			{
				break;
			}
		}
		
		if (fast != null && fast.next != null)
		{
			int len = 1;
			for (fast = fast.next; slow != fast; fast = fast.next)
			{
				++len;
			}
			
			fast = head;
			for (int i = 0; i < len; ++i)
			{
				fast = fast.next;
			}
			
			for (slow = head; slow != fast; slow = slow.next)
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

}
