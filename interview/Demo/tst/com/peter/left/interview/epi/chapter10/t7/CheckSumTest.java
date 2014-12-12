package com.peter.left.interview.epi.chapter10.t7;

import static org.hamcrest.Matchers.*;

import org.junit.*;

import static org.junit.Assert.assertThat;

public class CheckSumTest
{
    private CheckSum checker;
    
    @Before
    public void setUp()
    {
        checker = new CheckSum();
    }
    
    @Test
    public void test1()
    {
        final TreeNode root = new TreeNode(1);
        
        assertThat(checker.isExist(root, 1), equalTo(true));
    }
    
    @Test
    public void test2()
    {
        final TreeNode root = new TreeNode(1);
        
        assertThat(checker.isExist(root, 2), equalTo(false));
    }
    
    @Test
    public void test3()
    {
        final TreeNode root = new TreeNode(1, new TreeNode(2), null);
        
        assertThat(checker.isExist(root, 3), equalTo(true));
    }
    
    @Test
    public void test4()
    {
        final TreeNode root = new TreeNode(1, new TreeNode(2), null);
        
        assertThat(checker.isExist(root, 0), equalTo(false));
    }
    
    @Test
    public void test5()
    {
        final TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(100)), null);
        
        assertThat(checker.isExist(root, 103), equalTo(true));
    }
}
