package com.peter.left.interview.dataStructure.problems.candy;

import static org.hamcrest.Matchers.equalTo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class SimpleMinCandyCalculatorTest
{
    private MinCandyCalculator calculator;
    
    @Before
    public void setUp()
    {
        calculator = new SimpleMinCandyCalculator();
    }
    
    private int sum(final int[] values)
    {
        int sum = 0;
        
        for (final int value : values)
        {
            sum += value;
        }
        
        return sum;
    }
    
    @Test
    public void allEqual_itShould_returnExpected()
    {
        final int[] values = {1, 1, 1, 1, 1, 1, 1, 1, 1};
        assertThat(calculator.calculate(values), equalTo(sum(values)));
    }
    
    @Test
    public void onlyUp_itShould_returnExpected()
    {
        final int[] values = {1, 1, 1, 2, 3, 4, 4, 4, 4};
        assertThat(calculator.calculate(values), equalTo(sum(values)));
    }
    
    @Test
    public void onlyDown_itShould_returnExpected()
    {
        final int[] values = {4, 4, 4, 3, 3, 2, 2, 1, 1};
        assertThat(calculator.calculate(values), equalTo(sum(values)));
    }
    
    @Test
    public void lastElementDown_itShould_returnExpected()
    {
        final int[] values = {2, 2, 2, 2, 2, 2, 2, 1};
        assertThat(calculator.calculate(values), equalTo(sum(values)));
    }
    
    @Test
    public void downThenUp_itShould_returnExpected()
    {
        final int[] values = {2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 2, 3, 4, 5, 5, 5};
        assertThat(calculator.calculate(values), equalTo(sum(values)));
    }
    
    @Test
    public void upThenDown_itShould_returnExpected()
    {
        final int[] values = {1, 1, 1, 2, 2, 3, 4, 4, 4, 4};
        assertThat(calculator.calculate(values), equalTo(sum(values)));
    }
    
    @Test
    public void mutipleUpAndDown_itShould_returnExpected()
    {
        final int[] values = {2, 2, 1, 1, 2, 3, 4, 5, 6, 6, 5, 4, 3, 2, 1, 1, 2, 3, 4, 5};
        assertThat(calculator.calculate(values), equalTo(sum(values)));
    }
}
