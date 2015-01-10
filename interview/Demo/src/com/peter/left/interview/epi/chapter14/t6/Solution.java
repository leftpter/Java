package com.peter.left.interview.epi.chapter14.t6;

import java.util.Arrays;
import java.util.Comparator;

import com.peter.left.interview.epi.chapter14.t5.Interval;

public class Solution
{
	private static class IntervalComparator implements Comparator<Interval>
	{
		@Override
		public int compare(final Interval o1, final Interval o2)
		{
			return Integer.compare(o1.getStart(), o2.getStart());
		}
		
	}
	
	private static IntervalComparator COMPARATOR = new IntervalComparator();
	
	Interval[] add(final Interval[] items, final Interval item)
	{
		Interval[] result;
		int startPos = Arrays.binarySearch(items, item, COMPARATOR);
		startPos = (startPos >= 0) ? startPos : -(startPos + 1);
		
		// The new element should be at tail.
		if (startPos == items.length)
		{
			result = Arrays.copyOf(items, items.length + 1);
			result[startPos] = item;
		}
		else
		{
			// Previous item intersects with the added one.
			if (startPos > 0 && items[startPos - 1].getEnd() >= item.getStart())
			{
				--startPos;
			}
			
			// Start value of the new element.
			final int start = Math.min(item.getStart(), items[startPos].getStart());
			
			// Search the position with end value of added element.
			int endPos = Arrays.binarySearch(items, startPos, items.length, new Interval(item.getEnd(), 0), COMPARATOR);
			// End value of the new element.
			final int end;
			// There's an element with same start value, so it intersects with the added one.
			if (endPos >= 0)
			{
				end = items[endPos].getEnd();
				++endPos;
			}
			else
			{
				endPos = -(endPos + 1);
				if (0 < endPos)
				{
					// The previous element may have larger end value.
					end = Math.max(item.getEnd(), items[endPos - 1].getEnd());
				}
				else
				{
					end = item.getEnd();
				}
			}
			// The result array will be [0, startPos), new element, [endPos, item.length).
			result = new Interval[items.length - endPos + startPos + 1];
			System.arraycopy(items, 0, result, 0, startPos);
			result[startPos] = new Interval(start, end);
			System.arraycopy(items, endPos, result, startPos + 1, items.length - endPos);
			
		}
		
		return result;
	}
}
