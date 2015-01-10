package com.peter.left.interview.epi.chapter8.t19;

import com.peter.left.interview.epi.chapter8.t1.Node;

public class Solution
{
	Node add(final Node num1, final Node num2)
	{
		final Node head = new Node(0);
		int ten = 0;
		Node o = head;
		for (Node o1 = num1, o2 = num2; o1 != null || o2 != null;
				o1 = (o1 == null) ? o1 : o1.next, o2 = (o2 == null) ? o2 : o2.next, o = o.next)
		{
			final int value1 = (o1 == null) ? 0 : o1.value;
			final int value2 = (o2 == null) ? 0 : o2.value;
			final int sum = (value1 + value2 + ten);
			o.next = new Node(sum % 10);
			ten = sum / 10;
		}
		
		o.next = (ten > 0) ? new Node(ten) : null;
		return head.next;
	}
}
