package com.peter.left.interview.dataStructure.problems.surroundedRegionsCapturer;

import static org.hamcrest.Matchers.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SurroundedRegionsCapturerTest
{
    private static char REGION_MARK = 'O';    
    private static char SURROUND_MARK = 'X';   
    
    private SurroundedRegionsCapturer capturer;
    
    @Before
    public void setUp()
    {
        capturer = new SurroundedRegionsCapturer();
    }
    
    private char[][] createBoard(final int xSize, final int ySize)
    {
        final char[][] board = new char[xSize][];
        for (int i = 0; i < board.length; ++i)
        {
            board[i] = new char[ySize];
            for (int j = 0; j < board[i].length; ++j)
            {
                board[i][j] = SURROUND_MARK;
            }
        }
        
        return board;
    }
    
    private char[][] deepCopy(final char[][] array)
    {
        final char[][] board = new char[array.length][];
        for (int i = 0; i < board.length; ++i)
        {
            board[i] = new char[array[i].length];
            for (int j = 0; j < board[i].length; ++j)
            {
                board[i][j] = array[i][j];
            }
        }
        
        return board;
    }
    
    private void deepCheck(final char[][] actual, final char[][] expected)
    {
        assertThat(actual.length, equalTo(expected.length));
        
        for (int i = 0; i < actual.length; ++i)
        {
            assertThat(actual[i].length, equalTo(expected[i].length));
            for (int j = 0; j < actual[i].length; ++j)
            {
                assertThat(actual[i][j], equalTo(expected[i][j]));
            }
        }
    }
    
    @Test
    public void testFullSurrounedRegion_itShould_returnExpectedResult()
    {
        final char[][] board = createBoard(4, 4);
        
        for (int i = 1; i < board.length - 1; ++i)
        {
            for (int j = 1; j < board[i].length - 1; ++j)
            {
                board[i][j] = REGION_MARK;
            }
        }
        
        capturer.capture(board);
        
        for (int i = 0; i < board.length; ++i)
        {
            for (int j = 0; j < board[i].length; ++j)
            {
                assertThat(board[i][j], equalTo(SURROUND_MARK));
            }
        }
    }
    
    @Test
    public void testNoneSurrounedRegion_itShould_returnExpectedResult()
    {
        final char[][] board = createBoard(4, 4);
        
        for (int i = 1; i < board.length - 1; ++i)
        {
            for (int j = 1; j < board[i].length - 1; ++j)
            {
                board[i][j] = REGION_MARK;
            }
        }
        
        board[1][0] = REGION_MARK;
        
        final char[][] result = deepCopy(board);
        
        capturer.capture(board);
        
        deepCheck(board, result);
    }
    
    @Test
    public void testMixedSurrounedRegion_itShould_returnExpectedResult()
    {
        final char[][] board = createBoard(4, 4);
        
        for (int i = 1; i < board.length - 1; ++i)
        {
            for (int j = 1; j < board[i].length - 1; ++j)
            {
                board[i][j] = REGION_MARK;
            }
        }
        
        board[0][0] = REGION_MARK;
        
        final char[][] result = createBoard(4, 4);
        result[0][0] = REGION_MARK;
        
        capturer.capture(board);
        
        deepCheck(board, result);
    }
}
