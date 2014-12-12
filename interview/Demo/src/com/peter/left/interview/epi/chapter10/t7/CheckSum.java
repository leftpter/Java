package com.peter.left.interview.epi.chapter10.t7;


public class CheckSum
{
    private boolean isExist(final TreeNode node, final int target, final int preSum)
    {
        if (node == null)
        {
            return false;
        }
        else
        {
            final int sum = preSum + node.value;
            
            if (sum == target)
            {
                return true;
            }
            else
            {
                return isExist(node.left, target, sum) || isExist(node.right, target, sum);
            }
        }
    }
    public boolean isExist(final TreeNode node, final int sum)
    {
        return isExist(node, sum, 0);
    }
}
