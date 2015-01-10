package com.peter.left.interview.epi.chapter15.t1;

import java.util.LinkedList;
import java.util.Queue;

public class IterativeSolution
{
	private static class Data
	{
		final Node o;
		final long down;
		final long up;
		
		Data(final Node o, final long down, final long up)
		{
			this.o = o;
			this.down = down;
			this.up = up;
		}
	}
	boolean isBST(final Node root)
	{
		if (root == null)
		{
			return true;
		}
		else
		{
			final Queue<Data> queue = new LinkedList<>();
			queue.add(new Data(root, (long)Integer.MIN_VALUE - 1, (long) Integer.MAX_VALUE + 1));
			while (!queue.isEmpty())
			{
				final Data data = queue.poll();
				if (data.o != null)
				{
					if (data.down < data.o.value && data.o.value < data.up)
					{
						queue.add(new Data(data.o.left, data.down, data.o.value));
						queue.add(new Data(data.o.right, data.o.value, data.up));
					}
					else
					{
						return false;
					}
				}
			}
			
			return true;
		}
	}
}
