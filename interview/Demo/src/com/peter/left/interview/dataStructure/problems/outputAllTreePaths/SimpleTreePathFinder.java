package com.peter.left.interview.dataStructure.problems.outputAllTreePaths;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class SimpleTreePathFinder<E> implements TreePathFinder<E>
{
    private static class StackTreeNode<E>
    {
        private final TreeNode<E> current;
        private final List<E> path;
        
        StackTreeNode(final TreeNode<E> current, final List<E> path)
        {
            assert null != current : "current must not be null";
            assert null != path : "path must not be null";
            
            this.current = current;
            this.path = path;
        }
        
        TreeNode<E> getCurrent()
        {
            return current;
        }
        
        List<E> getPath()
        {
            return path;
        }
    }
    
    private void getAllPaths(final TreeNode<E> root, final Collection<List<E>> paths)
    {
        assert null != root : "root must not be null";
        assert null != paths : "paths must not be null";

        final Stack<StackTreeNode<E>> stack = new Stack<>();
        List<E> path = new LinkedList<>();
        TreeNode<E> node = root;
        
        while (null != node || !stack.empty())
        {
            if (null != node)
            {
                path.add(node.getValue());
                if (null == node.getLeft() && null == node.getRight())
                {
                    paths.add(path);
                    node = null;
                }
                else if (null == node.getLeft())
                {
                    node = node.getRight();
                }
                else if (null == node.getRight())
                {
                    node = node.getLeft();
                }
                else
                {
                    stack.push(new StackTreeNode<>(node.getRight(), new LinkedList<>(path)));
                    node = node.getLeft();
                }
            }
            else
            {
                final StackTreeNode<E> stackNode = stack.pop();
                node = stackNode.getCurrent();
                path = stackNode.getPath();
            }
        }
    }
    
    @Override
    public Collection<List<E>> getAllPath(final TreeNode<E> root)
    {
        final Collection<List<E>> result;
        if (null != root)
        {
            result = new LinkedList<>();
            getAllPaths(root, result);
        }
        else
        {
            result = Collections.emptyList();
        }
        
        return result;
    }

}
