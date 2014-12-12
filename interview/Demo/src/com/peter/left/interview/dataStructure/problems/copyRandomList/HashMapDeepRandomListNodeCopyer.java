package com.peter.left.interview.dataStructure.problems.copyRandomList;

import java.util.Map;

import com.google.common.collect.Maps;

public class HashMapDeepRandomListNodeCopyer<E> implements DeepRandomListNodeCopyer<E>
{
    private  RandomListNode<E> getCopyNode(final RandomListNode<E> node,
                                final Map<RandomListNode<E>, RandomListNode<E>> map)
    {
        final RandomListNode<E> copyNode;
        if (node != null)
        {
            if (map.containsKey(node))
            {
                copyNode = map.get(node);
            }
            else
            {
                copyNode = new RandomListNode<>(node.getValue(), null, null);
                map.put(node, copyNode);
            }
        }
        else
        {
            copyNode = null;
        }
        
        return copyNode;
    }
    private void copyNode(final RandomListNode<E> node,
     final Map<RandomListNode<E>, RandomListNode<E>> map)
    {
        assert null != node : "node must not be null";
        
        final RandomListNode<E> copyNode = getCopyNode(node, map);
        copyNode.setNext(getCopyNode(node.getNext(), map));
        copyNode.setRandom(getCopyNode(node.getRandom(), map));
    }
    
    @Override
    public RandomListNode<E> copy(final RandomListNode<E> head)
    {
        final RandomListNode<E> copyHead;
        final Map<RandomListNode<E>, RandomListNode<E>> map = Maps.newHashMap();
        copyHead = getCopyNode(head, map);

        for (RandomListNode<E> current = head; null != current; current = current.getNext())
        {
            copyNode(current, map);
        }
        
        return copyHead;
    }
}
