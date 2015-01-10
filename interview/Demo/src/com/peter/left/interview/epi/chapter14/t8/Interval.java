package com.peter.left.interview.epi.chapter14.t8;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class Interval
{
	final int start;
	final int end;
	
	public Interval(final int start, final int end)
	{
		this.start = start;
		this.end = end;
	}
}
