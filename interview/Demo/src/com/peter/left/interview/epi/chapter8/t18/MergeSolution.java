package com.peter.left.interview.epi.chapter8.t18;

import com.peter.left.interview.epi.chapter8.t1.Node;

public class MergeSolution
{
	private Node current;
	private final Node newHead = new Node(0);
	
	private Node mergeSort(final Node head, int len)
	{
		if (1 == len)
		{
			final Node previous = current;
			current = current.next;
			previous.next = null;
			return previous;
		}
		else if (0 == len)
		{
			return null;
		}
		final Node leftHead = mergeSort(current, len / 2);
		final Node rightHead = mergeSort(current, len - len / 2);
		
		newHead.next = null;
		Node o;
		Node left;
		Node right;
		int l = 0;
		int r = 0;
		for (o = newHead, left = leftHead, right = rightHead;
				l < len / 2 && r < len - len / 2;
				o = o.next)
		{
			if (left.value <= right.value)
			{
				o.next = left;
				left = left.next;
				++l;
			}
			else
			{
				o.next = right;
				right = right.next;
				++r;
			}
		}
		
		o.next = (l < len / 2) ? left : right;
		return newHead.next;
	}
	Node sort(final Node head)
	{
		if (head != null && head.next != null)
		{
			int len = 0;
			for (Node o = head; o != null; o = o.next)
			{
				++len;
			}
			
			current = head;
			
			return mergeSort(head, len);
		}
		else
		{
			return head;
		}
	}
}
