package com.peter.left.interview.dataStructure.problems.gasStation;

import org.apache.commons.lang3.Validate;

public class AdvancedStartFinder implements StartFinder {

    @Override
    public int find(final int[] gas, final int[] cost)
    {
        Validate.notNull(gas, "gas must not be null");
        Validate.notNull(cost, "cost must not be null");
        Validate.isTrue(gas.length == cost.length, "length of gas must be equal to length of cost; is %d : %d",
            gas.length, cost.length);
        
        int preGas = 0;
        int currentStart = 0;
        int restGas = 0;
        
        for (int i = 0; i < gas.length; ++i)
        {
            final int netCost = gas[i] - cost[i];
            if (currentStart >= 0)
            {
                restGas += netCost;
                // Can't go ahead.
                if (restGas < 0)
                {
                    currentStart = -1;
                    preGas += restGas;
                }
            }
            else
            {
                // Can't start from this point.
                if (netCost < 0)
                {
                    preGas += netCost;
                }
                else
                {
                    restGas = netCost;
                    currentStart = i;
                }
            }
        }
        
        final int iRet;
        if (restGas + preGas >= 0)
        {
            iRet = currentStart;
        }
        else
        {
            iRet = -1;
        }
        
        return iRet;
    }

}
