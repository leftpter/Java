package com.peter.left.interview.dataStructure.problems.commonRoot;

import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class SolutionTest
{
    private Solution solution;
    private TreeNode[] nodes = new TreeNode[8];
    
    @Before
    public void setUp()
    {
        solution = new Solution();
    }
    
    private TreeNode createTree()
    {
        for (int i = 0; i < nodes.length; ++i)
        {
            nodes[i] = new TreeNode();
            nodes[i].value = i;
            nodes[i].left = null;
            nodes[i].right = null;
        }
        
        nodes[0].left = nodes[1];
        nodes[0].right = nodes[2];
        nodes[1].left = nodes[3];
        nodes[1].right = nodes[4];
        nodes[2].left = nodes[5];
        nodes[2].right = nodes[6];
        nodes[3].right = nodes[7];
        
        return nodes[0];
    }
    
    @Test
    public void test1_itShould_returnExpectedResult()
    {
        final TreeNode root = createTree();
        
        assertThat(solution.LCA(root, 4, 5), sameInstance(root));
    }
    
    @Test
    public void test2_itShould_returnExpectedResult()
    {
        final TreeNode root = createTree();
        
        assertThat(solution.LCA(root, 1, 0), sameInstance(root));
    }
    
    @Test
    public void test3_itShould_returnExpectedResult()
    {
        final TreeNode root = createTree();
        
        assertThat(solution.LCA(root, 1, 6), sameInstance(root));
    }
    
    @Test
    public void test4_itShould_returnExpectedResult()
    {
        final TreeNode root = createTree();
        
        assertThat(solution.LCA(root, 1, 7), sameInstance(nodes[1]));
    }
    
    @Test
    public void test5_itShould_returnExpectedResult()
    {
        final TreeNode root = createTree();
        
        assertThat(solution.LCA(root, 3, 4), sameInstance(nodes[1]));
    }
}
