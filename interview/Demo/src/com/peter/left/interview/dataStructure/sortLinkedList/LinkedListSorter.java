package com.peter.left.interview.dataStructure.sortLinkedList;

public interface LinkedListSorter<E extends Comparable<? super E>>
{
    LinkedListNode<E> sort(LinkedListNode<E> head);
}
