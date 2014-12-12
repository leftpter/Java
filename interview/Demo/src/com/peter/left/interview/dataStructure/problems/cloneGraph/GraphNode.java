package com.peter.left.interview.dataStructure.problems.cloneGraph;

import java.util.HashSet;
import java.util.Set;

public class GraphNode<E>
{
    private final E value;
    private final Set<GraphNode<E>> neighbors = new HashSet<>();
    
    public void addNeighbor(final GraphNode<E> neighbor)
    {
        neighbors.add(neighbor);
    }
    
    public GraphNode(final E value)
    {
        this.value = value;
    }
    
    public Set<GraphNode<E>> getNeighbors()
    {
        return neighbors;
    }
    
    public E getValue()
    {
        return value;
    }
}
