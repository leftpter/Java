package com.peter.left.interview.dataStructure.problems.triangle;

import static org.hamcrest.Matchers.*;

import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

import static org.junit.Assert.assertThat;

public class SolutionTest
{
    private Solution solution;
    
    @Before
    public void setUp()
    {
        solution = new Solution();
    }
    
    @Test
    public void test3Level_itShould_returnExpectedResult()
    {
        final List<List<Integer>> values = Lists.newArrayList(Collections.singletonList(-1),
                Lists.newArrayList(3, 2), Lists.newArrayList(-3, 1, -1));
        
        assertThat(solution.minimumTotal(values), equalTo(-1));
    }
}
