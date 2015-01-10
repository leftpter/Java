package com.peter.left.interview.epi.chapter8.t13;

import com.peter.left.interview.epi.chapter8.t1.Node;

public class Solution
{
	void zipMerge(final Node head)
	{
		if (null != head && null != head.next)
		{
			final Node leftHead = new Node(0);
			leftHead.next = head;
			Node slow;
			Node fast;
			
			for (slow = leftHead, fast = leftHead;
					fast != null && fast.next != null; slow = slow.next)
			{
				fast = fast.next;
				fast = fast.next;
			}
			
			final Node rightHead = new Node(0);
			
			for (Node o = slow.next; o != null; )
			{
				final Node next = o.next;
				o.next = rightHead.next;
				rightHead.next = o;
				o = next;
			}
			
			slow.next = null;
			
			final Node newHead = new Node(0);
			Node o = newHead;
			Node left = leftHead.next;
			for (Node right = rightHead.next;
					left != null && right != null;
					o = o.next, right = right.next)
			{
				o.next = left;
				left = left.next;
				o = o.next;
				o.next = right;
			}
			
			o.next = left;
		}
	}
}
