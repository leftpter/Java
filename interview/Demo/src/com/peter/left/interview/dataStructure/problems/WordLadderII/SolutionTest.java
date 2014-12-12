package com.peter.left.interview.dataStructure.problems.WordLadderII;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Sets;


public class SolutionTest
{
    private Solution solution;
    
    @Before
    public void setUp()
    {
        solution = new Solution();
    }
    
    @Test
    public void easy()
    {
        solution.findLadders("hot", "dog", Sets.newHashSet("hot", "dog"));
    }
}
