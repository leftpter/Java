package com.peter.left.interview.dataStructure.problems.CombinationSum;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;



public class SolutionTest {
private Solution solution;
    
    @Before
    public void setUp()
    {
        solution = new Solution();
    }
    
    @Test
    public void test1()
    {
        final int[] values = {1};
        assertThat(solution.combinationSum(values, 1), 
                equalTo(Collections.singletonList(Collections.singletonList(1))));
    }
}
