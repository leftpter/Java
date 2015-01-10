package com.peter.left.interview.epi.chapter15.t5;

import com.peter.left.interview.epi.chapter15.t1.Node;

public class Solution
{
	Node getLCA(final Node root, final Node o1, final Node o2)
	{
		Node lca;
		for (lca = root; lca != null; )
		{
			Node r1 = (o1.value < lca.value) ? 
					lca.left :
					(o1.value > lca.value ? lca.right : lca);
			Node r2 = (o2.value < lca.value) ?
					lca.left :
					(o2.value > lca.value ? lca.right : lca);
			
			if (r1 == r2 && r1 != null)
			{
				lca = r1;
			}
			else
			{
				break;
			}
		}
		
		return lca;
	}
}
