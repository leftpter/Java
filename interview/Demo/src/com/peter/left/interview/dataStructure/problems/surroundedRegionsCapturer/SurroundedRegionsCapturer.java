package com.peter.left.interview.dataStructure.problems.surroundedRegionsCapturer;

public class SurroundedRegionsCapturer
{
    private static char UNSURROUNED_MARK = 'Y';
    private static char REGION_MARK = 'O';    
    private static char SURROUND_MARK = 'X';    
    
    
    
    private void markUnsurroundRegions(final char[][] board, final int xPos, final int yPos)
    {
        if ((0 <= xPos && xPos < board.length)
            && (0 <= yPos && yPos < board[xPos].length) 
            && REGION_MARK == board[xPos][yPos])
        {
            board[xPos][yPos] = UNSURROUNED_MARK;
            markUnsurroundRegions(board, xPos - 1, yPos);            
            markUnsurroundRegions(board, xPos + 1, yPos);
            markUnsurroundRegions(board, xPos, yPos - 1);
            markUnsurroundRegions(board, xPos, yPos + 1);            
        }
    }
    
    public void capture(final char[][] board)
    {
        for (int i = 0; i < board[0].length; ++i)
        {
            markUnsurroundRegions(board, 0, i);
        }
        
        for (int i = 0; i < board[board.length - 1].length; ++i)
        {
           markUnsurroundRegions(board, board.length - 1, i);
        }
        
        for (int i = 0; i < board.length; ++i)
        {
            markUnsurroundRegions(board, i, 0);
            markUnsurroundRegions(board, i, board[i].length - 1);            
        }
        
        for (int i = 0; i < board.length; ++i)
        {
            for (int j = 0; j < board[i].length; ++j)
            {
                if (UNSURROUNED_MARK == board[i][j])
                {
                    board[i][j] = REGION_MARK;
                }
                else
                {
                    board[i][j] = SURROUND_MARK;
                }
            }
        }
    }
}