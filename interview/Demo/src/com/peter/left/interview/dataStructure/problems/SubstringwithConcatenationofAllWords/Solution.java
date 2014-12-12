package com.peter.left.interview.dataStructure.problems.SubstringwithConcatenationofAllWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution
{
    private Map<String, Integer> getItems(final Map<String, Integer> words)
    {       
        final Map<String, Integer> map = new HashMap<>();
        
        for (final String word : words.keySet())
        {
            map.put(word, 0);
        }
        
        return map;
    }
    
    
    public List<Integer> findSubstring(String S, String[] L)
    {
        final int length = L[0].length();
        final int num = L.length;
        final List<Integer> result = new ArrayList<>();
        final Map<String, Integer> words = new HashMap<>();
        
        for (final String word : L)
        {
            if (words.containsKey(word))
            {
                words.put(word, words.get(word) + 1);
            }
            else
            {
                words.put(word, 1);
            }
        }
        for (int i = 0; i <= Math.min(length - 1, S.length() - length * num); ++i)
        {
            final Queue<String> list = new LinkedList<>();
            final Map<String, Integer> init = getItems(words);
            
            Map<String, Integer> map = new HashMap<>(init);
            
            for (int j = i; j <= S.length() - length; j += length)
            {
                final String word = S.substring(j, j + length);
                
                if (!map.containsKey(word))
                {
                    if (!list.isEmpty())
                    {
                        list.clear();
                        map = new HashMap<>(init);
                    }
                }
                else
                {
                    list.add(word);
                    if (map.get(word) == words.get(word))
                    {
                        for (String item = list.element(); !item.equals(word); item = list.element())
                        {
                            list.remove();
                            map.put(item, map.get(item) - 1);
                        }
                        
                        list.remove();
                    }
                    else
                    {
                        map.put(word, map.get(word) + 1);
                        if (list.size() == num)
                        {
                            result.add(j - length * (num - 1));
                        }
                    }
                }
                
            }
        }
        
        return result;
    }
}