package com.peter.left.interview.dataStructure.problems.outputAllTreePaths;

import java.util.Collection;
import java.util.List;

public interface TreePathFinder<E>
{
    Collection<List<E>> getAllPath(TreeNode<E> root);
}
