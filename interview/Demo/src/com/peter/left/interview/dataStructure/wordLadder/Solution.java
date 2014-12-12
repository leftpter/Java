package com.peter.left.interview.dataStructure.wordLadder;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * https://oj.leetcode.com/problems/word-ladder/
 *
 */
public class Solution 
{
    private boolean isAvailable(final String from, final String to)
    {
        boolean bRet = false;
        if (from.length() == to.length())
        {
            int diff = 0;
            for (int i = 0; i < from.length() && diff <= 1; ++i)
            {
                diff = (from.charAt(i) == to.charAt(i)) ? diff : ++diff;
            }
            
            bRet = (diff == 1);
        }
        
        return bRet;
    }
    
    private int minLength(final String start, final String end, final Set<String> dict)
    {
        Set<String> preReached = new HashSet<>();
        preReached.add(start);
        Set<String> currentReached;
        Set<String> rest = new HashSet<>(dict);
        int length = 0;
        do
        {
            currentReached = new HashSet<>();
            ++length;
            for (final Iterator<String> iter = rest.iterator(); iter.hasNext();)
            {
                final String word = iter.next();
                for (final String reachWord : preReached)
                {
                    if (isAvailable(word, reachWord))
                    {
                        currentReached.add(word);
                        iter.remove();
                        break;
                    }
                }
            }
            
            if (currentReached.contains(end))
            {
                return length;
            }
            preReached = currentReached;
        } while (!currentReached.isEmpty());
        
        return 0;
    }
    
    public int ladderLength(String start, String end, Set<String> dict)
    {
        if (start.equals(end))
        {
            return 0;
        }
        else
        {
            return minLength(start, end, dict);
        }
    }
}
