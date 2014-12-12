package com.peter.left.interview.dataStructure.problems.copyRandomList;

public class RandomListNode<E>
{
    private final E value;
    private RandomListNode<E> next;
    private RandomListNode<E> random;
    
    public RandomListNode(final E value, final RandomListNode<E> next, final RandomListNode<E> random)
    {
        this.value = value;
        this.next = next;
        this.random = random;
    }
    
    public RandomListNode(final E value)
    {
        this(value, null, null);
    }
    
    public E getValue()
    {
        return value;
    }
    
    public void setNext(final RandomListNode<E> next)
    {
        this.next = next;
    }
    
    public RandomListNode<E> getNext()
    {
        return next;
    }
    
    public void setRandom(final RandomListNode<E> random)
    {
        this.random = random;
    }
    
    public RandomListNode<E> getRandom()
    {
        return random;
    }
}

