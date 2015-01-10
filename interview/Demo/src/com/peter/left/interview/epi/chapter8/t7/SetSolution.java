package com.peter.left.interview.epi.chapter8.t7;

import java.util.HashSet;
import java.util.Set;

import com.peter.left.interview.epi.chapter8.t1.Node;

public class SetSolution implements Solution
{

	@Override
	public Node findOverlapping(final Node head1, final Node head2) {
		final Set<Node> first = new HashSet<>();
		first.add(null);
		Node o;
		for (o = head1; first.add(o); o = o.next)
		{
			
		}
		
		final Set<Node> second = new HashSet<>();
		for (o = head2; !first.contains(o) && second.add(o); o = o.next)
		{
			
		}
		
		return first.contains(o) ? o : null;
	}

}
