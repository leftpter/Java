package com.peter.left.interview.dataStructure.problems.reorderLinkedList;

import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.sameInstance;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class StackLinkedListReordererTest
{
    private LinkedListReorderer<Integer> reorderer;
    
    @Before
    public void setUp()
    {
        reorderer = new StackLinkedListReorderer<>();
    }
    
    @Test
    public void singletonLinkedList_itShould_doNothing()
    {
        final LinkedListNode<Integer> head = new LinkedListNode<>(1, null);
        
        reorderer.reorder(head);
        
        assertThat(head.getNext(), nullValue());
    }
    
    @Test
    public void twoElementsLinkedList_itShould_doNothing()
    {
        final LinkedListNode<Integer> node2 = new LinkedListNode<>(2, null);
        final LinkedListNode<Integer> node1 = new LinkedListNode<>(1, node2);
        
        reorderer.reorder(node1);
        
        assertThat(node1.getNext(), sameInstance(node2));
        assertThat(node2.getNext(), nullValue());
    }
    
    @Test
    public void threeElementsLinkedList_itShould_getExpectedResult()
    {
        final LinkedListNode<Integer> node3 = new LinkedListNode<>(3, null);
        final LinkedListNode<Integer> node2 = new LinkedListNode<>(2, node3);
        final LinkedListNode<Integer> node1 = new LinkedListNode<>(1, node2);
        
        reorderer.reorder(node1);
        
        assertThat(node1.getNext(), sameInstance(node3));
        assertThat(node3.getNext(), sameInstance(node2));
        assertThat(node2.getNext(), nullValue());
    }
    
    @Test
    public void fourElementsLinkedList_itShould_getExpectedResult()
    {
        final LinkedListNode<Integer> node4 = new LinkedListNode<>(4, null);
        final LinkedListNode<Integer> node3 = new LinkedListNode<>(3, node4);
        final LinkedListNode<Integer> node2 = new LinkedListNode<>(2, node3);
        final LinkedListNode<Integer> node1 = new LinkedListNode<>(1, node2);
        
        reorderer.reorder(node1);
        
        assertThat(node1.getNext(), sameInstance(node4));
        assertThat(node4.getNext(), sameInstance(node2));
        assertThat(node2.getNext(), sameInstance(node3));
        assertThat(node3.getNext(), nullValue());
    }
}
