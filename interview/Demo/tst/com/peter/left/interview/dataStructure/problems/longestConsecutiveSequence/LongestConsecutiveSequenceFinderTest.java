package com.peter.left.interview.dataStructure.problems.longestConsecutiveSequence;

import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LongestConsecutiveSequenceFinderTest
{
    private LongestConsecutiveSequenceFinder finder;
    
    @Before
    public void setUp()
    {
        finder = new LongestConsecutiveSequenceFinder();
    }
    
    @Test
    public void testNormalArray_itShould_returnExpectedResult()
    {
        final int[] elements = {9,1,4,7,3,-1,0,5,8,-1,6};
        assertThat(finder.find(elements), equalTo(7));
    }
    
    @Test
    public void testLongNormalArray_itShould_returnExpectedResult()
    {
        final int[] elements = {100, 4, 200, 1, 3, 2, 9, 6, -1, -3, 10, 7, 8, 5, 0, -2};
        assertThat(finder.find(elements), equalTo(14));
    }
}
