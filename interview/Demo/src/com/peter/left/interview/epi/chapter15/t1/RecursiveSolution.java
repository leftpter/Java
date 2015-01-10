package com.peter.left.interview.epi.chapter15.t1;

public class RecursiveSolution
{
	private boolean checkBST(final Node root, final long down, final long up)
	{
		boolean bRet;
		if (root == null)
		{
			bRet = true;
		}
		else
		{
			if (down < root.value && root.value < up)
			{
				bRet = checkBST(root.left, down, root.value) &&
						checkBST(root.right, root.value, up);
			}
			else
			{
				bRet = false;
			}
		}
		
		return bRet;
	}
	boolean isBST(final Node root)
	{
		return checkBST(root, (long)Integer.MIN_VALUE - 1, (long)Integer.MAX_VALUE + 1);
	}
}
