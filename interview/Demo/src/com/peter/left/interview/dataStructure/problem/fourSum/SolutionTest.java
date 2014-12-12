package com.peter.left.interview.dataStructure.problem.fourSum;

import org.junit.Before;
import org.junit.Test;


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
        final int[] values = {-6,-6,-2,8,1,-3,0,-4,-2,-4,0,-5,-6,6,9,3,9,0};
        solution.fourSum(values, -14);
    }
}
