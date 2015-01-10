package com.peter.left.interview.epi.chapter14.t8;

import java.util.Arrays;
import java.util.Comparator;

public class Solution
{
	private static class Wrapper
	{
		final Interval data;
		int num;
		
		Wrapper(final Interval item)
		{
			this.data = item;
			num = 0;
		}
	}
	
	private abstract static class Point
	{
		final Wrapper item;
		Point(final Wrapper item)
		{
			this.item = item;
		}
		
		abstract int getValue();
	}
	
	private static class StartPoint extends Point
	{
		StartPoint(final Wrapper item)
		{
			super(item);
		}

		@Override
		int getValue() {
			return item.data.start;
		}
		
		@Override
		public String toString()
		{
			return "S-" + item.toString() + "(" + item.num + ")";
		}
	}
	
	private static class EndPoint extends Point
	{
		EndPoint(final Wrapper item)
		{
			super(item);
		}

		@Override
		int getValue() {
			return item.data.end;
		}
		
		@Override
		public String toString()
		{
			return "E-" + item.toString() + "(" + item.num + ")";
		}
	}
	
	int[] findMinSet(final Interval[] intervals)
	{
		final int[] result = new int[intervals.length];
		int num = 0;
		final Point[] items = new Point[intervals.length * 2];
		
		for (final Interval item : intervals)
		{
			final Wrapper wrapper = new Wrapper(item);
			items[num++] = new StartPoint(wrapper);
			items[num++] = new EndPoint(wrapper);
		}
		
		Arrays.sort(items, new Comparator<Point>()
		{
			@Override
			public int compare(final Point o1, final Point o2)
			{	
				final int diff = Integer.compare(o1.getValue(), o2.getValue());
				if (0 == diff)
				{
					if ((o1 instanceof StartPoint && o2 instanceof StartPoint)
							|| (o1 instanceof EndPoint && o2 instanceof EndPoint))
					{
						return 0;
					}
					else
					{
						return (o1 instanceof StartPoint) ? -1 : 1;
					}
				}
				else
				{
					return diff;
				}
			}
		});
		
		num = 0;
		for (final Point item : items)
		{
			// Start point, set the current iteration number.
			if (item instanceof StartPoint)
			{
				item.item.num = num;
			}
			// First end point in this iteration.
			else if (item.item.num == num)
			{
				result[num++] = item.getValue();
			}
		}
		return Arrays.copyOf(result, num);
	}
}
