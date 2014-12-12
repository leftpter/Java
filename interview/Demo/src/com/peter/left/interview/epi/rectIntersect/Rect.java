package com.peter.left.interview.epi.rectIntersect;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Rect
{
    final int x;
    final int y;
    final int w;
    final int h;
    
    public Rect(final int x, final int y, final int w, final int h)
    {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
}
