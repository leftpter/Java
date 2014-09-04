package com.peter.left.interview.dataStructure.wordBreak;

import java.util.Set;

import org.apache.commons.lang3.Validate;

import com.google.common.collect.Sets;

public class RecursiveWordBreaker implements WordBreaker
{    
    private boolean isBreakableString(final String s, final Set<String> dictionary)
    {
        assert s != null : "s must not be null";
        assert dictionary != null : "dictionary must not be null";
        
        boolean bRet = false;
        
        if (dictionary.contains(s))
        {
            bRet = true;
        }
        else
        {
            for (int i = 0; i < s.length() - 1; ++i)
            {
                if (isBreakableString(s.substring(0, i + 1), dictionary) &&
                        isBreakableString(s.substring(i + 1), dictionary))
                {
                    bRet = true;
                    break;
                }
            }
        }
        
        return bRet;
    }
    
    @Override
    public boolean isBreakable(final String s, final Set<String> dictionary)
    {
        Validate.notNull(s, "s must not be null");
        Validate.notNull(dictionary, "dictionary must not be null");
        
        final Set<String> hashDictionary = Sets.newHashSet(dictionary);
        
        return isBreakableString(s, hashDictionary);
    }
}
