package com.peter.left.interview.dataStructure.evaluateReversePolishNotation;

import static org.hamcrest.Matchers.equalTo;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertThat;

public class StackReversePolishNotationEvaluatorTest
{
    private ReversePolishNotationEvaluator evaluator;
    
    @Rule
    public final ExpectedException exception = ExpectedException.none(); 
    
    @Before
    public void setUp()
    {
        evaluator = new StackReversePolishNotationEvaluator();
    }
    
    @Test
    public void emptyNotation_itShould_failToEvaluate()
    {
        exception.expect(IllegalArgumentException.class);
        
        evaluator.evaluate(new String[0]);
    }
    
    @Test
    public void onlyOperatorNotation_itShould_failToEvaluate()
    {
        final String[] notation = {"+"};
        
        exception.expect(IllegalArgumentException.class);
        
        evaluator.evaluate(notation);
    }
    
    @Test
    public void oneOperatorOneOperandNotation_itShould_failToEvaluate()
    {
        final String[] notation = {"2", "+"};
        
        exception.expect(IllegalArgumentException.class);
        
        evaluator.evaluate(notation);
    }
    
    @Test
    public void onlyMultipleOperandsNotation_itShould_failToEvaluate()
    {
        final String[] notation = {"2", "1", "3"};
        
        exception.expect(IllegalArgumentException.class);
        
        evaluator.evaluate(notation);
    }
    
    @Test
    public void NotNumberOperandNotation_itShould_failToEvaluate()
    {
        final String[] notation = {"**ee"};
        
        exception.expect(IllegalArgumentException.class);
        
        evaluator.evaluate(notation);
    }
    
    @Test
    public void oneOperandNotation_itShould_returnTheOperand()
    {
        final String[] notation = {"2"};
        
        assertThat(evaluator.evaluate(notation), equalTo(2));
    }
    
    @Test
    public void additionOperatorNotation_itShould_returnExpectedResult()
    {
        final String[] notation = {"4", "2", "+"};
        
        assertThat(evaluator.evaluate(notation), equalTo(6));
    }
    
    @Test
    public void subtractionOperatorNotation_itShould_returnExpectedResult()
    {
        final String[] notation = {"8", "2", "-"};
        
        assertThat(evaluator.evaluate(notation), equalTo(6));
    }
    
    @Test
    public void multiplicationOperatorNotation_itShould_returnExpectedResult()
    {
        final String[] notation = {"8", "2", "*"};
        
        assertThat(evaluator.evaluate(notation), equalTo(16));
    }
    
    @Test
    public void divisionOperatorNotation_itShould_returnExpectedResult()
    {
        final String[] notation = {"8", "2", "/"};
        
        assertThat(evaluator.evaluate(notation), equalTo(4));
    }
    
    @Test
    public void divisorIs0Notation_itShould_failToEvaluate()
    {
        final String[] notation = {"8", "0", "/"};
        
        exception.expect(IllegalArgumentException.class);
        
        evaluator.evaluate(notation);
    }
    
    @Test
    public void multipleOperatorsNotation_itShould_returnExpectedResult()
    {
        final String[] notation = {"8", "4", "+", "5", "*", "7", "+", "9", "/"};
        
        assertThat(evaluator.evaluate(notation), equalTo(7));
    }
}
