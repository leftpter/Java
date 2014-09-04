package com.peter.left.interview.dataStructure.sortLinkedList;

import lombok.ToString;

@ToString
public class LinkedListNode<E extends Comparable<? super E>>
{
    private final E value;
    private LinkedListNode<E> next;
    
    public LinkedListNode(final E value, final LinkedListNode<E> next)
    {
        this.value = value;
        this.next = next;
    }
    
    public LinkedListNode(final E value)
    {
        this(value, null);
    }
    
    public E getValue()
    {
        return value;
    }
    
    public LinkedListNode<E> getNext()
    {
        return next;
    }
    
    public void setNext(final LinkedListNode<E> next)
    {
        this.next = next;
    }
}
