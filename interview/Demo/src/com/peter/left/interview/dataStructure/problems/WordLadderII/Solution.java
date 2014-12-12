package com.peter.left.interview.dataStructure.problems.WordLadderII;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution
{
    private void putMap(final String from, final String to, final Map<String, Set<String>> map)
    {
        final Set<String> set;
        if (map.containsKey(to))
        {
            set = map.get(to);
        }
        else
        {
            set = new HashSet<>();
            map.put(to, set);
        }
        
        set.add(from);
    }
    
    public List<List<String>> findLadders(String start, String end, Set<String> dict)
    {
        Set<String> preStr = Collections.singleton(start);
        
        final Set<String> fastDict = new HashSet<>(dict);
        
        fastDict.remove(start);
        fastDict.remove(end);
        
        final Set<String> visited = new HashSet<>();
        final Map<String, Set<String>> map = new HashMap<>();
        
        int time = 0;
        boolean bStop = false;
        do
        {
            ++time;
            final Set<String> current = new HashSet<>();
NEXT_ITEM:            
            for (final String previous : preStr)
            {
                for (int i = 0; i < previous.length(); ++i)
                {
                    for (char j = 'a'; j <= 'z'; ++j)
                    {
                        final StringBuilder builder = new StringBuilder(previous);
                        builder.setCharAt(i, j);
                        final String item = builder.toString();
                        
                        if (time > 1 && end.equals(item))
                        {
                            putMap(previous, end, map);
                            bStop = true;
                            continue NEXT_ITEM;
                        }
                        else if (!bStop && !visited.contains(item) && fastDict.contains(item))
                        {
                            current.add(item);
                            visited.add(item);
                            putMap(previous, item, map);
                        }
                    }
                }
            }
            
            preStr = current;
            
        } while(!preStr.isEmpty() && !bStop);

        final List<List<String>> last = new ArrayList<>();
        if (bStop)
        {
            List<List<String>> result = Collections.singletonList(Collections.singletonList(end));
            
            for (int i = 0; i < time - 1; ++i)
            {
                final List<List<String>> current = new ArrayList<>();
                for (final List<String> item : result)
                {
                    final Set<String> previous = map.get(item.get(0));
                    for (final String str : previous)
                    {
                        final List<String> newItem = new ArrayList<>();
                        newItem.add(str);
                        newItem.addAll(item);
                        current.add(newItem);
                    }
                }
                
                result = current;
            }
        
            
            for (final List<String> list : result)
            {
                if (map.get(list.get(0)).contains(start))
                {
                    final List<String> item = new ArrayList<>();
                    item.add(start);
                    item.addAll(list);
                    last.add(item);
                }
            }
        }
        
        return last;
    }
}
