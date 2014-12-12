package com.peter.left.interview.epi.array3;

public class Solution
{
    private int fromChar(final char character)
    {
        return Integer.valueOf(String.valueOf(character));
    }
    private String multiply(final String num, final char digit)
    {
        if (digit == '0')
        {
            return "0";
        }
        else if (digit == '1')
        {
            return num;
        }
        
        final int mul = fromChar(digit);
        final StringBuilder sb = new StringBuilder();
        int ten = 0;
        for (int i = 1; i <= num.length(); ++i)
        {
            final int result = fromChar(num.charAt(num.length() - i)) * mul + ten;
            ten = result / 10;
            
            sb.insert(0, result % 10);
        }
        
        if (ten > 0)
        {
            sb.insert(0, ten);
        }
        
        return sb.toString();
    }
    private String add(final String num1, final String num2)
    {
        if (num1.equals("0"))
        {
            return num2;
        }
        else if (num2.equals("0"))
        {
            return num1;
        }
        final String longer = (num1.length() >= num2.length()) ? num1 : num2;
        final String shorter = (longer == num1) ? num2 : num1;
        
        final StringBuilder builder = new StringBuilder();
        
        int ten = 0;
        int i = 1;
        for (; i <= shorter.length(); ++i)
        {
            final int sum = fromChar(longer.charAt(longer.length() - i)) +
                    fromChar(shorter.charAt(shorter.length() - i)) + ten;
            
            ten = sum / 10;
            builder.insert(0, sum % 10);
        }
        
        for (; i <= longer.length(); ++i)
        {
            final int sum = fromChar(longer.charAt(longer.length() - i))
                    + ten;
            ten = sum / 10;
            
            builder.insert(0, sum % 10);
        }
        
        if (ten != 0)
        {
            builder.insert(0, ten);
        }
        
        return builder.toString();
    }
    public String multiply(final String num1, final String num2)
    {
        final String param1;
        final String param2;
        
        boolean positive = true;
        if (num1.charAt(0) == '-')
        {
            param1 = num1.substring(1);
            positive = false;
        }
        else
        {
            param1 = num1;
        }
        
        if (num2.charAt(0) == '-')
        {
            param2 = num2.substring(1);
            positive = !(positive ^ false);
        }
        else
        {
            param2 = num2;
        }
        
        final String longer = (param1.length() >= param2.length()) ? param1 : param2;
        final String shorter = (longer == param1) ? param2 : param1;
        String result = String.valueOf(0);
        
        for (int i = 1; i <= shorter.length(); ++i)
        {
            String temp = multiply(longer, shorter.charAt(shorter.length() - i));
            
            if (!temp.equals("0"))
            {
                for (int j = 1; j < i; ++j)
                {
                    temp = temp + "0";
                }
            }
            
            result = add(result, temp);
        }
        
        if (!positive && !result.equals("0"))
        {
            result = "-" + result;
        }
        
        return result;
    }
}
