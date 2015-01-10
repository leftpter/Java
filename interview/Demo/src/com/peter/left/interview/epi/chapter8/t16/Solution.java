package com.peter.left.interview.epi.chapter8.t16;

import com.peter.left.interview.epi.chapter8.t1.Node;

public class Solution
{
	int getMedian(final Node node)
	{
		Node o;
		for (o = node; 
				o.value <= o.next.value && o.next != node;
				o = o.next)
		{
			
		}
		
		final Node head = o.next;
		int len = 1;
		for (o = head; o.next != head; o = o.next)
		{
			++len;
		}
		
		final int median = (len % 2 == 1) ? len / 2 : len / 2 - 1;
		
		o = head;
		for (int i = 0; i < median; ++i)
		{
			o = o.next;
		}
		
		return (len % 2 == 1) ? o.value : (o.value + o.next.value) / 2;
	}
}
