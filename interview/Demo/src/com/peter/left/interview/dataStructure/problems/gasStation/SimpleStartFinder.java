package com.peter.left.interview.dataStructure.problems.gasStation;

import org.apache.commons.lang3.Validate;

public class SimpleStartFinder implements StartFinder
{
    @Override
    public int find(final int[] gas, final int[] cost)
    {
        Validate.notNull(gas, "gas must not be null");
        Validate.notNull(cost, "cost must not be null");
        Validate.isTrue(gas.length == cost.length, "length of gas must be equal to length of cost; is %d : %d",
            gas.length, cost.length);
        
        int iRet = -1;
        for (int i = 0; i < gas.length; ++i)
        {
            int restGas = 0;
            int j = i;
            do
            {
                restGas += gas[j] - cost[j];
                j = (j + 1) < gas.length ? (j + 1) : 0;
                
            } while (restGas >= 0 && j != i);
            
            if (restGas >= 0)
            {
                iRet = i;
                break;
            }
        }
        
        return iRet;
    }
}
