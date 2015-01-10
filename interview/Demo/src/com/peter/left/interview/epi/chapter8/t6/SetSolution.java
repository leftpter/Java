package com.peter.left.interview.epi.chapter8.t6;

import java.util.HashSet;
import java.util.Set;

import com.peter.left.interview.epi.chapter8.t1.Node;

public class SetSolution implements Solution
{

	@Override
	public Node findOverlapping(final Node head1, final Node head2)
	{
		final Set<Node> set = new HashSet<>();
		for (Node o1 = head1, o2 = head2; o1 != null || o2 != null;
				o1 = (o1 == null ? null : o1.next), o2 = (o2 == null) ? null : o2.next)
		{
			if (o1 != null && !set.add(o1))
			{
				return o1;
			}
			else if (o2 != null && !set.add(o2))
			{
				return o2;
			}
		}
		
		return null;
	}
	
}
