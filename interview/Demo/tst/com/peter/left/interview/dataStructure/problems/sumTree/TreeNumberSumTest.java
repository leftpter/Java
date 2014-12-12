package com.peter.left.interview.dataStructure.problems.sumTree;

import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TreeNumberSumTest
{
    private TreeNumberSum sumer;
    
    @Before
    public void setUp()
    {
        sumer = new TreeNumberSum();
    }
    
    @Test
    public void testTree_itShould_returnExpectedResult()
    {
        final TreeNode left = new TreeNode(2, null, null);
        final TreeNode right = new TreeNode(3, null, null);
        final TreeNode root = new TreeNode(1, left, right);
        
        assertThat(sumer.sum(root), equalTo(25));
    }
    
    @Test
    public void test3LevelTree_itShould_returnExpectedResult()
    {
        final TreeNode leftleft = new TreeNode(4, null, null);
        final TreeNode leftright = new TreeNode(5, null, null);
        final TreeNode left = new TreeNode(2, leftleft, leftright);
        final TreeNode rightright = new TreeNode(6, null, null);
        final TreeNode right = new TreeNode(3, null, rightright);
        final TreeNode root = new TreeNode(1, left, right);
        
        assertThat(sumer.sum(root), equalTo(385));
    }
}
