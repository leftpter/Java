package com.peter.left.interview.dataStructure.problems.climbStairs;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;


public class SimpleClimbStairDistinctWaysCalculatorTest
{
    private ClimbStairDistinctWaysCalculator calculator;
    
    @Before
    public void setUp()
    {
        calculator = new SimpleClimbStairDistinctWaysCalculator();
    }
    
    @Test
    public void zeroStep_itShould_return0()
    {
        assertThat(calculator.calculate(0), equalTo(0l));
    }
    
    @Test
    public void oneStep_itShould_return1()
    {
        assertThat(calculator.calculate(1), equalTo(1l));
    }
    
    @Test
    public void twoStep_itShould_return2()
    {
        assertThat(calculator.calculate(2), equalTo(2l));
    }
    
    @Test
    public void threeStep_itShould_return3()
    {
        assertThat(calculator.calculate(3), equalTo(3l));
    }
    
    @Test
    public void fourStep_itShould_return5()
    {
        assertThat(calculator.calculate(4), equalTo(5l));
    }
    
    @Test
    public void fiveStep_itShould_return8()
    {
        assertThat(calculator.calculate(5), equalTo(8l));
    }
}
