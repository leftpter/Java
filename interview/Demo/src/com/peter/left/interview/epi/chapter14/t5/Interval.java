package com.peter.left.interview.epi.chapter14.t5;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class Interval
{
	private final int start;
	private final int end;
	
	public Interval(final int start, final int end)
	{
		this.start = start;
		this.end = end;
	}
	
	public int getStart()
	{
		return start;
	}
	
	public int getEnd()
	{
		return end;
	}
}
