package com.peter.left.interview.epi.rectIntersect;

public class Solution
{
    public Rect intersect(final Rect rect1, final Rect rect2)
    {
        Rect result;
        final Rect left = (rect1.x < rect2.x) ? rect1 : rect2;
        final Rect right = (rect1.x < rect2.x) ? rect2 : rect1;
        
        if (right.y >= (left.y + left.h))
        {
            result = null;
        }
        else if ((right.y + right.h) <= left.y)
        {
            result = null;
        }
        else if (right.x >= (left.x + left.w))
        {
            result = null;
        }
        else
        {
            if (right.y < left.y)
            {
                result = new Rect(right.x, left.y, left.x + left.w - right.x, right.y + right.h - left.y);
            }
            else
            {
                result = new Rect(right.x, right.y, left.x + left.w - right.x, left.y + left.h - right.y);
            }
        }
        
        return result;
    }
}
