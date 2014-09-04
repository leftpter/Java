package com.peter.left.interview.dataStructure.evaluateReversePolishNotation;

import java.util.Stack;

import org.apache.commons.lang3.Validate;

public class StackReversePolishNotationEvaluator implements ReversePolishNotationEvaluator
{
    private final Stack<Integer> stack = new Stack<>();

    private boolean isOperator(final String element)
    {
        final boolean bRet;
        switch (element)
        {
            case "+":
            case "-":
            case "*":
            case "/":
                bRet = true;
                break;
                
            default:
                bRet = false;
                break;
        }
        
        return bRet;
    }
    
    private int calculate(final String operator, final int value1, final int value2)
    {
        final int result;
        switch (operator)
        {
            case "+":
                result = value1 + value2;
                break;
                
            case "-":
                result = value1 - value2;
                break;
                
            case "*":
                result = value1 * value2;
                break;
                
            case "/":
                Validate.isTrue(value2 != 0, "divisor must not be 0");
                
                result = value1 / value2;
                break;
                
            default:
                throw new IllegalArgumentException("unknown operator; is " + operator);
        }
        
        return result;
    }
    
    @Override
    public int evaluate(final String[] notation)
    {
        Validate.notEmpty(notation, "notation must not be empty");
        
        stack.clear();
        
        for (final String element : notation)
        {
            if (isOperator(element))
            {
                Validate.isTrue(stack.size() >= 2, "notation is not a legal reverse polish notation; is " +
                        notation);
                
                final int value2 = stack.pop();
                final int value1 = stack.pop();
                
                stack.push(calculate(element, value1, value2));
            }
            else
            {
                try
                {
                    stack.push(Integer.parseInt(element));
                }
                catch (final Exception e)
                {
                    throw new IllegalArgumentException(
                            String.format("operand is not an integer, is %s", element), e);
                }
            }
        }
        
        Validate.isTrue(stack.size() == 1, "notation is not a legal reverse polish notation, is" + notation);
        
        return stack.pop();
    }
}
