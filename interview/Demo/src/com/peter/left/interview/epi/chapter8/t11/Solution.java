package com.peter.left.interview.epi.chapter8.t11;

import com.peter.left.interview.epi.chapter8.t1.Node;

public class Solution
{
	Node rightShift(final Node head, final int num)
	{
		final Node newHead = new Node(0);
		newHead.next = head;
		
		if (num != 0 && head != null && head.next != null)
		{
			int len = 0;
			Node end;
			for (end = newHead; end.next != null; end = end.next)
			{
				++len;
			}
			
			final int value = (num < 0) ? (num % len + len) : (num % len);
			
			if (value != 0)
			{
				Node tail = newHead;
				for (int i = 0; i < len - value; ++i)
				{
					tail = tail.next;
				}
				
				newHead.next = tail.next;
				tail.next = null;
				end.next = head;
			}
		}
		
		return newHead.next;
	}
}
