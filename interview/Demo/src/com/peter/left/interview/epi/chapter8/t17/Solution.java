package com.peter.left.interview.epi.chapter8.t17;

import com.peter.left.interview.epi.chapter8.t1.Node;

public class Solution
{
	Node pivot(final Node head, final int value)
	{
		final Node smallerHead = new Node(0);
		final Node equalHead = new Node(0);
		final Node largerHead = new Node(0);
		Node small;
		Node equal;
		Node larger;
		Node o;
		for (small = smallerHead, equal = equalHead, larger = largerHead, o = head;
				o != null; o = o.next)
		{
			if (o.value < value)
			{
				small.next = o;
				small = o;
			}
			else if (o.value == value)
			{
				equal.next = o;
				equal = o;
			}
			else
			{
				larger.next = o;
				larger = o;
			}
		}
		
		larger.next = null;
		equal.next = largerHead.next;
		small.next = equalHead.next;
		return smallerHead.next;
	}
}
