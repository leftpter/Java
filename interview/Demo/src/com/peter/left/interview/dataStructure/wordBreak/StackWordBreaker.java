package com.peter.left.interview.dataStructure.wordBreak;

import java.util.Set;
import java.util.Stack;

import org.apache.commons.lang3.Validate;

import com.google.common.collect.Sets;

public class StackWordBreaker implements WordBreaker
{
    private static class SubStringRange
    {
        final int startPos;
        final int endPos;
        
        SubStringRange(final int startPos, final int endPos)
        {
            assert startPos >= 0 : String.format("startPos must not be negative; is %d", startPos);
            assert endPos > startPos : String.format("endPos must be larger than startPos; is [%d, %d]", 
                    startPos, endPos);
            
            this.startPos = startPos;
            this.endPos = endPos;
        }
        
        int getStartPos()
        {
            return startPos;
        }
        
        int getEndPos()
        {
            return endPos;
        }
    }
    
    private SubStringRange getLongestWord(final String s, final SubStringRange range, final Set<String> dictionary)
    {
        SubStringRange wordRange = null;
        
        for (int i = range.getEndPos(); i > range.getStartPos(); --i)
        {
            if (dictionary.contains(s.substring(range.getStartPos(), i)))
            {
                wordRange = new SubStringRange(range.getStartPos(), i);
                break;
            }
        }
        
        return wordRange;
    }
    
    @Override
    public boolean isBreakable(final String s, final Set<String> dictionary)
    {
        Validate.notNull(s, "s must not be null");
        Validate.notNull(dictionary, "dictionary must not be null");
        
        Stack<SubStringRange> stack = new Stack<>();
        final Set<String> hashDict = Sets.newHashSet(dictionary);
        SubStringRange range = getLongestWord(s, new SubStringRange(0, s.length()), hashDict);
        
        boolean bRet = false;
        
        while (null != range || !stack.isEmpty())
        {
            if (null != range)
            {
                if (range.getEndPos() == s.length())
                {
                    bRet = true;
                    break;
                }
                
                stack.push(range);
                range = getLongestWord(s, new SubStringRange(range.getEndPos(), s.length()), hashDict);
            }
            else
            {
                final SubStringRange lastRange = stack.pop();
                
                range = getLongestWord(s, new SubStringRange(lastRange.getStartPos(), lastRange.getEndPos() - 1), hashDict);
            }
        }
        
        stack.clear();
        
        return bRet;
    }
}
