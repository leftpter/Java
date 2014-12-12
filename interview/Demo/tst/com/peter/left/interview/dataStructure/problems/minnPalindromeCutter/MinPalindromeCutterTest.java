package com.peter.left.interview.dataStructure.problems.minnPalindromeCutter;

import static org.hamcrest.Matchers.equalTo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class MinPalindromeCutterTest
{
    private MinPalindromeCutter cutter;
    
    @Before
    public void setUp()
    {
        cutter = new MinPalindromeCutter();
    }
    
    @Test
    public void testaab_itShouldReturn1()
    {
        assertThat(cutter.cut("aab"), equalTo(1));
    }
    
    @Test
    public void testaabaa_itShouldReturn0()
    {
        assertThat(cutter.cut("aabaa"), equalTo(0));
    }
    
    @Test
    public void testbaabaa_itShouldReturn1()
    {
        assertThat(cutter.cut("baabaa"), equalTo(1));
    }
}
