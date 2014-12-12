package com.peter.left.interview.dataStructure.problems.SingleNumber;

import static org.hamcrest.Matchers.equalTo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class BitsetSingleNumberFinderTest
{
    private SingleNumberFinder finder;
    
    @Before
    public void setUp()
    {
        finder = new BitsetSingleNumberFinder();
    }
    
    @Test
    public void singleInteger_itShould_returnSingleInteger()
    {
        final int[] numbers = {Integer.MAX_VALUE};
        
        assertThat(finder.find(numbers), equalTo(numbers[0]));
    }
    
    @Test
    public void twoIntegers_itShould_returnSingleInteger()
    {
        final int[] numbers = {Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
        
        assertThat(finder.find(numbers), equalTo(numbers[0]));
    }
    
    @Test
    public void threeIntegers_itShould_returnSingleInteger()
    {
        final int[] numbers = {Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 1, 1};
        
        assertThat(finder.find(numbers), equalTo(numbers[0]));
    }
    
    @Test
    public void multipleIntegers_itShould_returnSingleInteger()
    {
        final int[] numbers = {Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 1, 1,
                0, 0, 2, 2, 11122, 11122, 9999, 9999, 8888, 8888};
        
        assertThat(finder.find(numbers), equalTo(numbers[0]));
    }
}
