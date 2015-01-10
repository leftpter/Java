package com.peter.left.interview.epi.chapter8.t12;

import com.peter.left.interview.epi.chapter8.t1.Node;

public class Solution
{
	void evenOddMerge(final Node head)
	{
		final Node evenHead = new Node(0);
		final Node oddHead = new Node(1);
		Node even = evenHead;
		Node odd = oddHead;
		Node o = head;
		for (boolean bEven = true; o != null; o = o.next, bEven = !bEven)
		{
			if (bEven)
			{
				even.next = o;
				even = even.next;
			}
			else
			{
				odd.next = o;
				odd = odd.next;
			}
		}
		
		even.next = oddHead.next;
		odd.next = null;
	}
}
