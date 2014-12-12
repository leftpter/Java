package com.peter.left.interview.dataStructure.problems.distinctSubsequences;

import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;

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
    public void testShortString_itShould_returnExpectedResult()
    {
        assertThat(solution.numDistinct("abbc", "abc"),
                equalTo(2));
    }
    
    @Test
    public void testMediateString_itShould_returnExpectedResult()
    {
        assertThat(solution.numDistinct("aabbc", "abc"),
                equalTo(4));
    }
    
    @Test
    public void testLongString_itShould_returnExpectedResult()
    {
        assertThat(solution.numDistinct("aabbcc", "abc"),
                equalTo(8));
    }
    
    @Test
    public void testVeryLongString_itShould_returnExpectedResult()
    {
        assertThat(solution.numDistinct("adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc", "bcddceeeebecbc"),
                equalTo(700531452));
    }
}
