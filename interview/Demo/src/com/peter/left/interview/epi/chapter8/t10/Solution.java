package com.peter.left.interview.epi.chapter8.t10;

import com.peter.left.interview.epi.chapter8.t1.Node;

public class Solution
{
	void removeDuplicated(final Node head)
	{
		for (Node item = head; item != null; item = item.next)
		{
			Node next;
			for (next = item.next;
					next != null && next.value == item.value;
					next = next.next)
			{
				
			}
			
			item.next = next;
		}
	}
}
