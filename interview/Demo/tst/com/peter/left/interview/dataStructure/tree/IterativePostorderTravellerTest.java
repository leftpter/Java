package com.peter.left.interview.dataStructure.tree;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;


public class IterativePostorderTravellerTest
{
    private Traveller<Object> traveller;
    private List<Object> travelResult;
    private Consumer<Object> consumer;
    
    @Before
    public void setUp()
    {
        traveller = new IterativePostorderTraveller<>();
        travelResult = Lists.newArrayList();
        consumer = (o) -> travelResult.add(o);
    }
    
    @Test
    public void travelEmptyTree_itShould_returnEmptyList()
    {
        traveller.travel(null, consumer);
        
        assertThat(travelResult, empty());
    }
    
    @Test
    public void travelSingletonTree_itShould_returnSingletonList()
    {
        final Object obj = new Object();
        traveller.travel(new TreeNode<Object>(obj), consumer);
        
        assertThat(travelResult, equalTo(Collections.singletonList(obj)));
    }
    
    @Test
    public void travelRootOnlyHasLeftChild_itShould_returnSingletonList()
    {
        final Object obj = new Object();
        final Object left = new Object();
        
        traveller.travel(
                new TreeNode<Object>(obj, new TreeNode<Object>(left), null), consumer);
        
        assertThat(travelResult, equalTo(Lists.newArrayList(left, obj)));
    }
    
    @Test
    public void travelNodesOnlyHasLeftChild_itShould_returnSingletonList()
    {
        final Object obj = new Object();
        final Object left = new Object();
        final Object leftleft = new Object();
        
        traveller.travel(
                new TreeNode<Object>(obj, new TreeNode<Object>(left, new TreeNode<Object>(leftleft), null), null), consumer);
        
        assertThat(travelResult, equalTo(Lists.newArrayList(leftleft, left, obj)));
    }
    
    @Test
    public void travelNodesOnlyHasOneChild_itShould_returnSingletonList()
    {
        final Object obj = new Object();
        final Object left = new Object();
        final Object leftright = new Object();
        
        traveller.travel(
                new TreeNode<Object>(obj, new TreeNode<Object>(left, null, new TreeNode<Object>(leftright)), null), consumer);
        
        assertThat(travelResult, equalTo(Lists.newArrayList(leftright, left, obj)));
    }
    
    @Test
    public void travelRootOnlyHasRightChild_itShould_returnSingletonList()
    {
        final Object obj = new Object();
        final Object right = new Object();
        
        traveller.travel(
                new TreeNode<Object>(obj, null, new TreeNode<Object>(right)), consumer);
        
        assertThat(travelResult, equalTo(Lists.newArrayList(right, obj)));
    }
    
    @Test
    public void travelNodesOnlyHasRightChild_itShould_returnSingletonList()
    {
        final Object obj = new Object();
        final Object right = new Object();
        final Object rightright = new Object();
        
        traveller.travel(
                new TreeNode<Object>(obj, null,
                        new TreeNode<Object>(right, null, new TreeNode<Object>(rightright))),
                        consumer);
        
        assertThat(travelResult, equalTo(Lists.newArrayList(rightright, right, obj)));
    }
    
    @Test
    public void travelRootOnlyHasBothChild_itShould_returnSingletonList()
    {
        final Object obj = new Object();
        final Object left = new Object();
        final Object right = new Object();
        
        traveller.travel(
                new TreeNode<Object>(obj, new TreeNode<Object>(left), new TreeNode<Object>(right)), consumer);
        
        assertThat(travelResult, equalTo(Lists.newArrayList(left, right, obj)));
    }
    
    @Test
    public void travelMultipleLevelTree_itShould_returnSingletonList()
    {
        final Object obj = new Object();
        final Object left = new Object();
        final Object right = new Object();
        
        final Object leftleft = new Object();
        final Object leftright = new Object();
        
        final Object rightleft = new Object();
        final Object rightright = new Object();
        
        final TreeNode<Object> leftChild = new TreeNode<Object>(left,
                new TreeNode<Object>(leftleft), new TreeNode<Object>(leftright));
        
        final TreeNode<Object> rightChild = new TreeNode<Object>(right,
                new TreeNode<Object>(rightleft), new TreeNode<Object>(rightright));
        
        traveller.travel(
                new TreeNode<Object>(obj, leftChild, rightChild), consumer);
        
        assertThat(travelResult, equalTo(Lists.newArrayList(
                leftleft, leftright, left, rightleft, rightright, right, obj)));
    }
}
