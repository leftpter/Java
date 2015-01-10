package com.peter.left.interview.epi.chapter8.t5;

import java.util.HashSet;
import java.util.Set;

import com.peter.left.interview.epi.chapter8.t1.Node;

public class SetSolution implements Solution
{
	@Override
	public Node findCycle(Node head) {
		final Set<Node> set = new HashSet<>(); 
		Node o;
		for (o = head; o != null && set.add(o); o = o.next)
		{
		}
		
		return o;
	}
}
