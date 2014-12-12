package com.peter.left.interview.dataStructure.problems.gasStation;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;


public class AdvancedStartFinderTest
{
    private StartFinder finder;
    
    @Before
    public void setUp()
    {
        finder = new AdvancedStartFinder();
    }
    
    @Test
    public void startAtTheHead_itShould_return0()
    {
        final int[] gas =  {6, 4, 3, 2, 1};
        final int[] cost = {5, 4, 3, 2, 2};
        assertThat(finder.find(gas, cost), equalTo(0));
    }
    
    @Test
    public void startAtTheTail_itShould_returnExpectedIndex()
    {
        final int[] gas =  {5, 4, 3, 2, 3};
        final int[] cost = {5, 4, 3, 3, 2};
        assertThat(finder.find(gas, cost), equalTo(4));
    }
    
    @Test
    public void startAtTheMiddle_itShould_returnExpectedIndex()
    {
        final int[] gas =  {5, 4, 4, 2, 4};
        final int[] cost = {6, 5, 3, 2, 3};
        assertThat(finder.find(gas, cost), equalTo(2));
    }
}
