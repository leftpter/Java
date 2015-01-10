package com.peter.left.interview.epi.chapter15.t7;

public class Solution
{
	private int minOne(final int a, final int b, final int c)
	{
		if (a <= b && a <= c)
		{
			return 0;
		}
		else if (b <= a && b <= c)
		{
			return 1;
		}
		else
		{
			return 2;
		}
	}
	
	private int max(final int a, final int b, final int c)
	{
		return Math.max(a, Math.max(b, c));
	}
	
	int[] minDistance(final int[] a, final int[] b, final int[] c)
	{
		if (null != a && a.length > 0 &&
				null != b && b.length > 0 &&
				null != c && c.length > 0)
		{
			final int[] result = new int[3];
			final int[][] input = {a, b, c};
			
			final int[] i = {0, 0, 0};
			int dis = Integer.MAX_VALUE;
			while (i[0] < a.length && i[1] < b.length && i[2] < c.length && dis > 0)
			{
				final int min = minOne(input[0][i[0]], input[1][i[1]], input[2][i[2]]);
				final int max = max(input[0][i[0]], input[1][i[1]], input[2][i[2]]);
				if (max - input[min][i[min]] < dis)
				{
					dis = max - input[min][i[min]];
					result[0] = a[i[0]];
					result[1] = b[i[1]];
					result[2] = c[i[2]];
				}
				i[min]++;
			}
			
			return result;
		}
		else
		{
			return null;
		}
	}
}
