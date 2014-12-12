package com.peter.left.interview.dataStructure.problems.outputAllTreePaths;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.contains;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

import static org.junit.Assert.assertThat;

public class SimpleTreePathFinderTest
{
    private TreePathFinder<Integer> finder;
    
    @Before
    public void setUp()
    {
        finder = new SimpleTreePathFinder<>();
    }
    
    @Test
    public void nullRoot_itShould_returnEmpty()
    {
        assertThat(finder.getAllPath(null), empty());
    }
    
    @Test
    public void singletonRoot_itShould_returnsingletonPath()
    {
        final Collection<List<Integer>> result = 
                finder.getAllPath(new TreeNode<>(1));
        
        assertThat(result, hasSize(1));
        assertThat(result, contains(Collections.singletonList(1)));
    }
    
    @Test
    public void singletonPathTree_itShould_returnsingletonPath()
    {
        final Collection<List<Integer>> result = 
                finder.getAllPath(new TreeNode<>(1, 
                        new TreeNode<>(2, null, 
                                new TreeNode<Integer>(3, new TreeNode<>(4), null)), null));
        
        assertThat(result, hasSize(1));
        assertThat(result, contains(Lists.newArrayList(1, 2, 3, 4)));
    }
    
    @Test
    public void twoPathsTree_itShould_returntwoPaths()
    {
        final Collection<List<Integer>> result = 
                finder.getAllPath(new TreeNode<>(1, 
                        new TreeNode<>(2), new TreeNode<>(3)));
        
        assertThat(result, hasSize(2));
        assertThat(result, contains(Lists.newArrayList(1, 2), Lists.newArrayList(1, 3)));
    }
    
    @Test
    public void multiplePathsTree_itShould_returnMultiplePaths()
    {
        final Collection<List<Integer>> result = 
                finder.getAllPath(new TreeNode<>(1, 
                        new TreeNode<>(2, new TreeNode<Integer>(4), null),
                        new TreeNode<>(3, new TreeNode<Integer>(5), new TreeNode<Integer>(6))));
        
        assertThat(result, hasSize(3));
        assertThat(result, contains(Lists.newArrayList(1, 2, 4),
                Lists.newArrayList(1, 3, 5), Lists.newArrayList(1, 3, 6)));
    }
}
