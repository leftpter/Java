package com.peter.left.interview.dataStructure.evaluateReversePolishNotation;

/**
 * Interface to evaluate reverse polish notation.
 * 
 * <p>
 * {@link https://oj.leetcode.com/problems/evaluate-reverse-polish-notation/}
 * </p>
 *
 */
public interface ReversePolishNotationEvaluator
{
    /**
     * Evaluate reverse polish notation.
     * 
     * @param notation Integer array contains the reverse polish notation.
     * 
     * @return evaluation result.
     * @throws IllegalArgumentException - reverse polish notation is illegal.
     * @throws NullPointerException - {@code notation} is null.
     */
    int evaluate(String[] notation);
}
