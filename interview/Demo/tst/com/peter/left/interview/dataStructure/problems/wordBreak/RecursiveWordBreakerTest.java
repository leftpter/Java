package com.peter.left.interview.dataStructure.problems.wordBreak;

import static org.hamcrest.Matchers.equalTo;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Sets;
import com.peter.left.interview.dataStructure.problems.wordBreak.RecursiveWordBreaker;
import com.peter.left.interview.dataStructure.problems.wordBreak.WordBreaker;

import static org.junit.Assert.assertThat;

public class RecursiveWordBreakerTest
{
    private WordBreaker breaker;
    
    @Before
    public void setUp()
    {
        breaker = new RecursiveWordBreaker();
    }
    
    @Test
    public void emptyDictionary_itShould_returnFalse()
    {
        assertThat(breaker.isBreakable("dds", Collections.emptySet()), equalTo(false));
    }
    
    @Test
    public void matchedString_itShould_returnTrue()
    {
        assertThat(breaker.isBreakable("dds", Collections.singleton("dds")), equalTo(true));
    }
    
    @Test
    public void breakableString_itShould_returnTrue()
    {
        assertThat(breaker.isBreakable("leetcode", Sets.newHashSet("code", "leet")), equalTo(true));
    }
    
    @Test
    public void unbreakableString_itShould_returnfalse()
    {
        assertThat(breaker.isBreakable("leetecode", Sets.newHashSet("code", "leet")), equalTo(false));
    }
    
    @Test
    public void multiplebreakableString_itShould_returnTrue()
    {
        assertThat(breaker.isBreakable("abababbbaaabbaaabaaa", Sets.newHashSet("a", "b")), equalTo(true));
    }
    
    @Test
    public void multipleunbreakableString_itShould_returnfalse()
    {
        assertThat(breaker.isBreakable("abababbbaaabbaaabaaac", Sets.newHashSet("a", "b")), equalTo(false));
    }
}
