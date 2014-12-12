package com.peter.left.interview.dataStructure.problems.nQueuens;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution
{
    private List<List<Integer>> nQueuens(final List<Integer> rows, final Set<Integer> columns)
    {
        if (columns.isEmpty())
        {
            final List<Integer> result = new ArrayList<>(rows);
            return Collections.singletonList(result);
        }
        else
        {
            final Set<Integer> remained = new HashSet<>(columns);
            final List<List<Integer>> result = new ArrayList<>();
            for (final int column : columns)
            {
                boolean isLegal = true;
                for (int i = 0; i < rows.size(); ++i)
                {
                    if (Math.abs(column - rows.get(i)) == (rows.size() - i))
                    {
                        isLegal = false;
                        break;
                    }
                }
                
                if (isLegal)
                {
                    rows.add(column);
                    remained.remove(column);
                    result.addAll(nQueuens(rows, remained));
                    remained.add(column);
                    rows.remove(rows.size() - 1);
                }
            }
            
            return result;
        }
    }
    
    private String[] valueOf(final List<Integer> list)
    {
        final String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); ++i)
        {
            final StringBuilder sb = new StringBuilder();
            for (int j = 0; j < list.get(i); ++j)
            {
                sb.append(".");
            }
            
            sb.append("Q");
            
            for (int j = list.get(i) + 1; j < list.size(); ++j)
            {
                sb.append(".");
            }
            
            result[i] = sb.toString();
        }
        
        return result;
    }
    
    public List<String[]> solveNQueens(int n)
    {
        if (n == 1)
        {
            final String[] result = {"Q"};
            return Collections.singletonList(result);
        }
        else if (n > 3)
        {
            final List<Integer> rows = new ArrayList<>();
            final Set<Integer> columns = new HashSet<>();
            final List<String[]> result = new ArrayList<>();
            for (int i = 0; i < n; ++n)
            {
                columns.add(i);
            }
            
            final List<List<Integer>> queuens = nQueuens(rows, columns);
            for (final List<Integer> item : queuens)
            {
                result.add(valueOf(item));
            }
            
            return result;
        }
        else
        {
            return Collections.<String[]>emptyList();
        }
    }
}
