package com.peter.left.interview.epi.chapter14.t5;

import java.util.Arrays;
import java.util.Comparator;

public class Solution
{
	private static class IntervalComparator implements Comparator<Interval>
	{
		@Override
		public int compare(Interval o1, Interval o2) {
			return Integer.compare(o1.getStart(), o2.getStart());
			
		}
	}
	private static final IntervalComparator COMPARATOR = new IntervalComparator();
	
	public int findMaxIntersection(final Interval[] intervals)
	{
		if (null == intervals || 0 == intervals.length)
		{
			return 0;
		}
		
		Arrays.sort(intervals, COMPARATOR);
		
		int max = 1;
		int current = intervals[0].getStart();
		int start = 0;
		int maxEnd = intervals[0].getEnd();
		int i;
		for (i = 1; i < intervals.length; ++i)
		{	
			if (current != intervals[i].getStart())
			{
				int index = Arrays.binarySearch(intervals, i, intervals.length, new Interval(maxEnd, 0), COMPARATOR);
				
				if (index < 0)
				{
					index = -(index + 1);
				}
				
				max = Math.max(max, index  - start);
				
				current = intervals[i].getStart();
				start = i;
				maxEnd = intervals[i].getEnd();
				// Reach last element or we can't get larger one, no need to continue.
				if (intervals.length == index || intervals.length - start <= max)
				{
					break;
				}
			}
			else
			{
				maxEnd = Math.max(maxEnd, intervals[i].getEnd());
			}
		}
		
		// If it reach the end, means we didn't process the last starting position.
		return (i == intervals.length) ? Math.max(max, intervals.length - start) : max;
	}
}
