package com.peter.left.interview.epi.chapter15.t15;

import java.util.HashSet;
import java.util.Set;

import com.peter.left.interview.epi.chapter15.t1.Node;

public class Solution
{
	boolean checkOrder(final Node root, final int r, final int s, final int m)
	{
		final Set<Integer> ends = new HashSet<>();
		ends.add(r);
		ends.add(s);
		boolean visited = false;
		int dest = m;
		for (Node o = root; o != null && !ends.isEmpty(); o = (dest < o.value) ? o.left : o.right)
		{	
			if (m == o.value)
			{
				// m is either r or s, or we already found one r or s.
				if (ends.contains(m) || ends.size() == 1)
				{
					visited = true;
					for (final int end : ends)
					{
						if (end != m)
						{
							dest = end;
							break;
						}
					}
				}
				else
				{
					break;
				}
			}
			
			ends.remove(o.value);
		}
		
		return visited && ends.isEmpty();
	}
}
