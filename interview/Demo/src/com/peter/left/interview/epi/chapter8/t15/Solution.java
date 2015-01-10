package com.peter.left.interview.epi.chapter8.t15;

import com.peter.left.interview.epi.chapter8.t1.Node;

public class Solution
{
	boolean isPalindrome(final Node head)
	{
		if (head != null && head.next != null)
		{
			final Node newHead = new Node(0);
			newHead.next = head;
			
			Node slow = newHead;
			for (Node fast = newHead;
					fast != null && fast.next != null;
					slow = slow.next)
			{
				fast = fast.next;
				fast = fast.next;
			}
			
			Node o = slow.next;
			slow.next = null;
			
			while (o != null)
			{
				final Node next = o.next;
				o.next = slow.next;
				slow.next = o;
				o = next;
			}
			Node right = slow.next;
			for (Node left = head;
					left != null && right != null && left.value == right.value;
					left = left.next, right = right.next)
			{
				
			}
			
			return right == null;
		}
		else
		{
			return true;
		}
	}
}
