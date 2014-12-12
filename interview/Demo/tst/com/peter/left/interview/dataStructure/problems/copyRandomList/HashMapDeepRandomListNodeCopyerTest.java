package com.peter.left.interview.dataStructure.problems.copyRandomList;

import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.sameInstance;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class HashMapDeepRandomListNodeCopyerTest
{
    private DeepRandomListNodeCopyer<Integer> copyer;
    
    @Before
    public void setUp()
    {
        copyer = new HashMapDeepRandomListNodeCopyer<>();
    }
    
    @Test
    public void copyNullList_itShould_returnNull()
    {
        assertThat(copyer.copy(null), nullValue());
    }
    
    private <T> void checkNode(final RandomListNode<T> orgin,
            final RandomListNode<T> copy)
    {
        assertThat(copy, not(sameInstance(orgin)));
        assertThat(copy.getValue(), sameInstance(orgin.getValue()));
        if (null != orgin.getNext())
        {
            assertThat(copy.getNext(), notNullValue());
            assertThat(copy.getNext().getValue(), sameInstance(orgin.getNext().getValue()));
        }
        else
        {
            assertThat(copy.getNext(), nullValue());
        }
        
        if (null != orgin.getRandom())
        {
            assertThat(copy.getRandom(), notNullValue());
            assertThat(copy.getRandom().getValue(), sameInstance(orgin.getRandom().getValue()));
        }
        else
        {
            assertThat(copy.getRandom(), nullValue());
        }
    }
    
    private <T> void checkCopyList(final RandomListNode<T> orgin,
            final RandomListNode<T> copy)
    {
        RandomListNode<T> copyNode = copy;
        RandomListNode<T> orginNode = orgin;
        for (; orginNode != null && copyNode != null;
                orginNode = orginNode.getNext(), copyNode = copyNode.getNext())
        {
            checkNode(orginNode, copyNode);
        }
        
        assertThat(copyNode, nullValue());
        assertThat(orginNode, nullValue());
    }
    
    @Test
    public void copySingletionList_itShould_returnExpectedList()
    {
        final RandomListNode<Integer> head = new RandomListNode<>(1);
        final RandomListNode<Integer> copyHead = copyer.copy(head);
        
        checkCopyList(head, copyHead);
    }
    
    @Test
    public void copyTwoElementsList_itShould_returnExpectedList()
    {
        final RandomListNode<Integer> node2 = new RandomListNode<>(2);
        final RandomListNode<Integer> head = new RandomListNode<>(1, node2, node2);
        node2.setRandom(head);
        final RandomListNode<Integer> copyHead = copyer.copy(head);
        
        checkCopyList(head, copyHead);
    }
    
    @Test
    public void copyMultipleElementsList_itShould_returnExpectedList()
    {
        final RandomListNode<Integer> node4 = new RandomListNode<>(2);
        final RandomListNode<Integer> node3 = new RandomListNode<>(3, node4, node4);
        final RandomListNode<Integer> node2 = new RandomListNode<>(2, node3, node3);
        final RandomListNode<Integer> head = new RandomListNode<>(1, node2, node4);
        node2.setRandom(head);
        final RandomListNode<Integer> copyHead = copyer.copy(head);
        
        checkCopyList(head, copyHead);
    }
}
