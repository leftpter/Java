package com.peter.left.interview.epi.chapter14.t7;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class Interval
{
	final int start;
	final int end;
	final boolean iStart;
	final boolean iEnd;
	
	public Interval(final int start, final boolean iStart,
			final int end, final boolean iEnd)
	{
		this.start = start;
		this.end = end;
		this.iStart = iStart;
		this.iEnd = iEnd;
	}
}
