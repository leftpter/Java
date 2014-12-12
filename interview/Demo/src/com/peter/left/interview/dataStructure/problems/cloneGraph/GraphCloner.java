package com.peter.left.interview.dataStructure.problems.cloneGraph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GraphCloner<E>
{
    private GraphNode<E> cloneGraph(final GraphNode<E> node, final Map<GraphNode<E>, GraphNode<E>> map,
                                final Set<GraphNode<E>> accessed)
    {
        final GraphNode<E> clonedNode;
        if (map.containsKey(node))
        {
            clonedNode = map.get(node);
        }
        else
        {
            clonedNode = new GraphNode<E>(node.getValue());
        }
        
        if (!accessed.contains(node))
        {   
            accessed.add(node);
            
            for (final GraphNode<E> neighbor : node.getNeighbors())
            {
                clonedNode.addNeighbor(cloneGraph(neighbor, map, accessed));
            }
        }
        
        return clonedNode;
    }
    
    public GraphNode<E> clone(final GraphNode<E> startPos)
    {
        final GraphNode<E> clonedStart;
        if (null != startPos)
        {
            clonedStart = cloneGraph(startPos, new HashMap<>(), new HashSet<>());
        }
        else
        {
            clonedStart = null;
        }
        
        return clonedStart;
    }
}