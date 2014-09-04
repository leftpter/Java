package com.peter.left.interview.dataStructure.sortLinkedList;

import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.sameInstance;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

import static org.junit.Assert.assertThat;

public class LinkedListMergeSorterTest
{
    private LinkedListSorter<Integer> sorter;
    
    @Before
    public void setUp()
    {
        sorter = new LinkedListMergeSorter<>();
    }
    
    @Test
    public void nullLinkedList_itShould_returnNull()
    {
        assertThat(sorter.sort(null), nullValue());
    }
    
    @Test
    public void singletonLinkedList_itShould_returnSingletonElement()
    {
        final LinkedListNode<Integer> element = new LinkedListNode<>(0);
        
        assertThat(sorter.sort(element), sameInstance(element));
    }
    
    @Test
    public void twoElementsLinkedList_itShould_returnExpectedSortedList()
    {
        testElements(2);
    }
    
    @Test
    public void fourElementsLinkedList_itShould_returnExpectedSortedList()
    {
        testElements(4);
    }
    
    private void testElements(final int elementNum)
    {
        final List<LinkedListNode<Integer>> list = Lists.newArrayList();
        LinkedListNode<Integer> previous = null;
        
        for (int i = 0; i < elementNum; ++i)
        {
            final LinkedListNode<Integer> node = new LinkedListNode<>(elementNum - i - 1, previous);
            previous = node;
            list.add(node);
        }
        
        LinkedListNode<Integer> result = sorter.sort(list.get(list.size() - 1));
        
        for (int i = 0; i < list.size(); ++i)
        {
            assertThat(result, sameInstance(list.get(elementNum - i - 1)));
            
            result = result.getNext();
        }
        
        assertThat(result, nullValue());
    }
    
    @Test
    public void sixteenElementsLinkedList_itShould_returnExpectedSortedList()
    {
        testElements(16);
    }
    
    @Test
    public void fifteenElementsLinkedList_itShould_returnExpectedSortedList()
    {
        testElements(15);
    }
    
    @Test
    public void forteenElementsLinkedList_itShould_returnExpectedSortedList()
    {
        testElements(14);
    }
    
    @Test
    public void thirteenElementsLinkedList_itShould_returnExpectedSortedList()
    {
        testElements(13);
    }
    
    @Test
    public void tweleveElementsLinkedList_itShould_returnExpectedSortedList()
    {
        testElements(12);
    }
    
    @Test
    public void elevenElementsLinkedList_itShould_returnExpectedSortedList()
    {
        testElements(11);
    }
    
    @Test
    public void tenElementsLinkedList_itShould_returnExpectedSortedList()
    {
        testElements(10);
    }
    
    @Test
    public void nineElementsLinkedList_itShould_returnExpectedSortedList()
    {
        testElements(9);
    }
    
    @Test
    public void eightElementsLinkedList_itShould_returnExpectedSortedList()
    {
        testElements(8);
    }
}
