package com.peter.left.interview.dataStructure.sortLinkedList;

public class LinkedListMergeSorter<E extends Comparable<? super E>> implements LinkedListSorter<E>
{
    // List of all nodes in the first part in merge sort.
    private final LinkedListNode<E> firstHead  = new LinkedListNode<>(null);
    // List of all nodes in the second part in merge sort.
    private final LinkedListNode<E> secondHead = new LinkedListNode<>(null);
    
    private static class NodePair<E extends Comparable<? super E>>
    {
        private final LinkedListNode<E> src;
        private final LinkedListNode<E> dest;
        
        NodePair(final LinkedListNode<E> src, LinkedListNode<E> dest)
        {
            this.src = src;
            this.dest = dest;
        }
        
        LinkedListNode<E> getSrc()
        {
            return src;
        }
        
        LinkedListNode<E> getDest()
        {
            return dest;
        }
    }
    
    private void init(final LinkedListNode<E> head)
    {
        assert head != null : "head must not be null";
        assert head.getNext() != null : "head.getNext() must not be null";
        
        LinkedListNode<E> first = firstHead;
        LinkedListNode<E> second = secondHead;
        LinkedListNode<E> node = head;
        
        while (node != null)
        {
            first.setNext(node);
            first = first.getNext();
            
            node = node.getNext();
            if (node == null)
            {
                break;
            }
            
            second.setNext(node);
            second = second.getNext();
            
            node = node.getNext();
        }
        
        first.setNext(null);
        second.setNext(null);
    }
    
    private NodePair<E> oneMergeStep(final NodePair<E> input, final int step)
    {
        assert input.getDest() != null : "destation must not be null";
        
        final NodePair<E> result;
        
        if (input.getSrc() != null && input.getSrc().getNext() != null)
        {
            LinkedListNode<E> dest = input.getDest();
            LinkedListNode<E> src = input.getSrc();
            
            int destStep = 0;
            int srcStep = 0;
            
            while (destStep < step && srcStep < step)
            {
                if (dest.getNext().getValue().compareTo(src.getNext().getValue()) <= 0)
                {
                    dest = dest.getNext();
                    ++destStep;
                }
                else
                {
                    final LinkedListNode<E> temp = src.getNext();
                    src.setNext(temp.getNext());
                    ++srcStep;
                    
                    temp.setNext(dest.getNext());
                    dest.setNext(temp);
                    
                    dest = temp;
                }
            }
            
            if (srcStep < step)
            {
                LinkedListNode<E> node = src;
                
                for (; srcStep < step && node.getNext() != null; ++srcStep)
                {
                    node = node.getNext();
                }

                final LinkedListNode<E> temp = src.getNext();
                src.setNext(node.getNext());
                
                node.setNext(dest.getNext());
                dest.setNext(temp);
                
                dest = node;
            }
            else
            {
                for (; destStep < step && dest.getNext() != null; ++destStep)
                {
                    dest = dest.getNext();
                }
            }
            
            result = new NodePair<>(src, dest);
        }
        else
        {
            result = input;
        }
        
        return result;
    }
    
    private void stepSort(final int step)
    {
        assert step >=1 : String.format("step must be more than 0; is %d", step);
        
        NodePair<E> nodes = new NodePair<>(secondHead, firstHead);
        
        while (nodes.getSrc().getNext() != null && nodes.getDest().getNext() != null)
        {
            nodes = oneMergeStep(nodes, step);
            
            if (nodes.getSrc().getNext() == null || nodes.getDest().getNext() == null)
            {
                break;
            }
            
            nodes = oneMergeStep(new NodePair<>(nodes.getDest(), nodes.getSrc()), step);
        }
    }
    
    @Override
    public LinkedListNode<E> sort(final LinkedListNode<E> head)
    {       
        final LinkedListNode<E> resultHead;
        
        if (head != null && head.getNext() != null)
        {
            init(head);
            
            for (int step = 1; secondHead.getNext() != null; step <<= 1)
            {
                stepSort(step);
            }
            
            resultHead = firstHead.getNext();
        }
        else
        {
            resultHead = head;
        }
        
        return resultHead;
    }
}
