package com.peter.left.interview.dataStructure.problems.reorderLinkedList;

import java.util.Stack;

public class StackLinkedListReorderer<E> implements LinkedListReorderer<E>
{
    @Override
    public void reorder(final LinkedListNode<E> head)
    {
        if (null != head && null != head.getNext())
        {
            final Stack<LinkedListNode<E>> stack = new Stack<>();
            for (LinkedListNode<E> node = head; null != node; node = node.getNext())
            {
                stack.push(node);
            }
            
            LinkedListNode<E> stackNode = stack.pop();
            for (LinkedListNode<E> node = head;
             node != stackNode && node.getNext() != stackNode; stackNode = stack.pop())
            {
                stackNode.setNext(node.getNext());
                node.setNext(stackNode);
                node = stackNode.getNext();
            }
            
            stackNode.setNext(null);
        }
    }
}
