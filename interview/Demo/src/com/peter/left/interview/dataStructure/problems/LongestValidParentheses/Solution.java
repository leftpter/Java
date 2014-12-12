package com.peter.left.interview.dataStructure.problems.LongestValidParentheses;

import java.util.Stack;

/**
 * https://oj.leetcode.com/problems/longest-valid-parentheses/
 *
 */
public class Solution
{
    private int findLongest(final Stack<Integer> stack, final int start)
    {
        int max = 0;
        while (stack.size() > 1)
        {
            max = Math.max(stack.pop() - stack.peek() - 1, max);
        }
        
        max = Math.max(stack.pop() - start, max);
        
        return max;
    }
    public int longestValidParentheses(String s)
    {
        final Stack<Integer> stack = new Stack<>();
        int max = 0;
        int start = 0;
        for (int i = 0; i < s.length(); )
        {
            if (s.charAt(i) == '(')
            {
                stack.push(i++);
            }
            else
            {
                if (stack.empty())
                {
                    stack.push(i);
                    max = Math.max(findLongest(stack, start), max);
                    
                    while (i < s.length() && s.charAt(i) == ')')
                    {
                        ++i;
                    }
                    start = i;
                }
                else
                {
                    stack.pop();
                    ++i;
                }
            }
        }
        
        stack.push(s.length());
        max = Math.max(findLongest(stack, start), max);
        
        return max;
    }
}
