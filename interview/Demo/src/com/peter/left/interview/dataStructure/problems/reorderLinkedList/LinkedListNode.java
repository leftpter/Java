package com.peter.left.interview.dataStructure.problems.reorderLinkedList;

public class LinkedListNode<E>
{
    private final E value;
    private LinkedListNode<E> next;
    
    public LinkedListNode(final E value, final LinkedListNode<E> next)
    {
        this.value = value;
        this.next = next;
    }
    
    public E getValue()
    {
        return value;
    }
    
    public LinkedListNode<E> getNext()
    {
        return next;
    }
    
    public void setNext(LinkedListNode<E> next)
    {
        this.next = next;
    }
}