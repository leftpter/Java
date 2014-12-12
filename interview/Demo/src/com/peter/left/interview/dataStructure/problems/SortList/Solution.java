package com.peter.left.interview.dataStructure.problems.SortList;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution
{
    public ListNode sortList(ListNode head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }
        final ListNode firstHead = new ListNode(0);
        final ListNode secondHead = new ListNode(0);
        ListNode first;
        ListNode second;
        ListNode node;
        for (first = firstHead, second = secondHead, node = head; node != null; node = node.next.next)
        {
            first.next = node;
            second.next = node.next;
            first = first.next;
            second = second.next;
            if (node.next == null)
            {
                break;
            }
        }
        
        first.next = null;
        if (second != null)
        {
            second.next = null;
        }
        
        for (int i = 1; secondHead.next != null; i <<= 1)
        {
            ListNode fNode = firstHead.next;
            firstHead.next = null;
            ListNode sNode = secondHead.next;
            secondHead.next = null;
            
            first = firstHead;
            second = secondHead;
            
            while (fNode != null || sNode != null)
            {
                int f;
                int s;
                for (f = 0, s = 0; (f < i || s < i) && (fNode != null || sNode != null); first = first.next)
                {
                    if (f == i || (s < i && fNode == null) || (sNode != null && sNode.val <= fNode.val))
                    {
                        if (sNode == null)
                        {
                            break;
                        }
                        first.next = sNode;
                        sNode = sNode.next;
                        ++s;
                    }
                    else
                    {
                        if (fNode == null)
                        {
                            break;
                        }
                        first.next = fNode;
                        fNode = fNode.next;
                        ++f;
                    }
                }
                
                for (f = 0, s = 0; (f < i || s < i) && (fNode != null || sNode != null); second = second.next)
                {
                    if (f == i || (f < i && fNode == null) || (sNode != null && sNode.val <= fNode.val))
                    {
                        if (sNode == null)
                        {
                            break;
                        }
                        second.next = sNode;
                        sNode = sNode.next;
                        ++s;
                    }
                    else
                    {
                        if (fNode == null)
                        {
                            break;
                        }
                        second.next = fNode;
                        fNode = fNode.next;
                        ++f;
                    }
                }
            }
            
            if (first != null)
            {
                first.next = null;
            }
            
            if (second != null)
            {
                second.next = null;
            }
        }
        
        return firstHead.next;
    }
}
