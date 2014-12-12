package com.peter.left.interview.epi.chapter10.t5;

public class LCAFinder
{
    public TreeNode LCA(final TreeNode node1, final TreeNode node2)
    {
        int path1 = 0;
        TreeNode temp1 = node1;
        for (; temp1.parent != null; temp1 = temp1.parent, path1++)
        {
            
        }
        
        int path2 = 0;
        TreeNode temp2 = node2;
        for (; temp2.parent != null; temp2 = temp2.parent, path2++)
        {
            
        }
        
        if (temp1 != temp2)
        {
            return null;
        }
        else if (path1 == 0 || path2 == 0)
        {
            return temp1;
        }
        
        int init = 0;
        if (path1 >= path2)
        {
            temp1 = node1;
            temp2 = node2;
            init = path1 - path2;
        }
        else
        {
            temp1 = node2;
            temp2 = node1;
            init = path2 - path1;
        }
        
        for (int i = 0; i < init; ++i)
        {
            temp1 = temp1.parent;
        }
        
        for (; temp1.parent != null; temp1 = temp1.parent, temp2 = temp2.parent)
        {
            if (temp1 == temp2)
            {
                break;
            }
        }
        
        return temp1;
    }
}
