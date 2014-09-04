package com.peter.left.interview.dataStructure.wordBreak;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Sets;


public class StackWordBreakerTest
{
    private WordBreaker breaker;
    
    @Before
    public void setUp()
    {
        breaker = new StackWordBreaker();
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
