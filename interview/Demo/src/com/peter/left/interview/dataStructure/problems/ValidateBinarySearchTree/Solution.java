package com.peter.left.interview.dataStructure.problems.ValidateBinarySearchTree;

public class Solution
{
    public boolean isValidBST(final TreeNode root, final boolean bMin, final int min, final boolean bMax, final int max)
    {
        if (root == null)
        {
            return true;
        }
        else
        {
            if ((!bMin || (bMin && min < root.val))
                && (!bMax || (bMax && root.val < max)))
            {
                return isValidBST(root.left, bMin, min, true, root.val) 
                    && isValidBST(root.right, true, root.val, bMax, max);
            }
            else
            {
                return false;
            }
        }
    }
    
    
    public boolean isValidBST(TreeNode root)
    {
        return isValidBST(root, false, Integer.MIN_VALUE, false, Integer.MAX_VALUE);
    }
}
