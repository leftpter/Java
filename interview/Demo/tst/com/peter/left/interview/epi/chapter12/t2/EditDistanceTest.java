package com.peter.left.interview.epi.chapter12.t2;

import static org.hamcrest.Matchers.*;

import org.junit.Test;

import static org.junit.Assert.assertThat;


public class EditDistanceTest
{
    private EditDistance edit = new EditDistance();
    
    @Test
    public void test()
    {
        assertThat(edit.minDistance("sea", "eat"), equalTo(2));
    }
}
