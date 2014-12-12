package com.peter.left.interview.epi.chapter10.t5;

import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class LCAFinderTest
{
    private LCAFinder finder;
    
    @Before
    public void setUp()
    {
        finder = new LCAFinder();
    }
    
    @Test
    public void test1()
    {
        final TreeNode root = new TreeNode(0, null);
        final TreeNode left = new TreeNode(1, root);
        final TreeNode right = new TreeNode(2, root);
        
        root.left = left;
        root.right = right;
        
        assertThat(finder.LCA(left, root), sameInstance(root));
    }
    
    @Test
    public void test2()
    {
        final TreeNode root = new TreeNode(0, null);
        final TreeNode left = new TreeNode(1, root);
        final TreeNode right = new TreeNode(2, root);
        
        root.left = left;
        root.right = right;
        
        assertThat(finder.LCA(left, right), sameInstance(root));
    }
    
    @Test
    public void test3()
    {
        final TreeNode root = new TreeNode(0, null);
        final TreeNode left = new TreeNode(1, root);
        final TreeNode right = new TreeNode(2, root);
        final TreeNode leftleft = new TreeNode(3, left);
        final TreeNode leftright = new TreeNode(4, left);
        
        root.left = left;
        root.right = right;
        
        left.left = leftleft;
        left.right = leftright;
        
        assertThat(finder.LCA(leftleft, right), sameInstance(root));
    }
    
    @Test
    public void test4()
    {
        final TreeNode root = new TreeNode(0, null);
        final TreeNode left = new TreeNode(1, root);
        final TreeNode right = new TreeNode(2, root);
        final TreeNode leftleft = new TreeNode(3, left);
        final TreeNode leftright = new TreeNode(4, left);
        
        root.left = left;
        root.right = right;
        
        left.left = leftleft;
        left.right = leftright;
        
        assertThat(finder.LCA(leftleft, leftright), sameInstance(left));
    }
    
    @Test
    public void test5()
    {
        final TreeNode root = new TreeNode(0, null);
        final TreeNode left = new TreeNode(1, root);
        final TreeNode right = new TreeNode(2, root);
        final TreeNode leftleft = new TreeNode(3, left);
        final TreeNode leftright = new TreeNode(4, left);
        
        root.left = left;
        root.right = right;
        
        left.left = leftleft;
        left.right = leftright;
        
        assertThat(finder.LCA(leftleft, left), sameInstance(left));
    }
}
