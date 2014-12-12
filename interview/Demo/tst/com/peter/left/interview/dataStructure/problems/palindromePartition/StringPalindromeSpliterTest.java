package com.peter.left.interview.dataStructure.problems.palindromePartition;

import static org.hamcrest.Matchers.equalTo;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import static org.junit.Assert.assertThat;

public class StringPalindromeSpliterTest
{
    private StringPalindromeSpliter spliter;
    
    @Before
    public void setUp()
    {
        spliter = new StringPalindromeSpliter();
    }
    
    @Test
    public void whena_itShould_returnExpectedResult()
    {
        assertThat(spliter.split("a"),
                equalTo(Collections.singletonList(Lists.newArrayList("a"))));
    }
    
    @Test
    public void whenaab_itShould_returnExpectedResult()
    {
        assertThat(spliter.split("aab"),
                equalTo(Lists.newArrayList(Lists.newArrayList("a", "a", "b"),
                        Lists.newArrayList("aa", "b"))));
    }
    
    @Test
    public void whenaba_itShould_returnExpectedResult()
    {
        assertThat(spliter.split("aba"),
                equalTo(Lists.newArrayList(Lists.newArrayList("a", "b", "a"),
                        Collections.singletonList("aba"))));
    }
    
    @Test
    public void whenabaa_itShould_returnExpectedResult()
    {
        assertThat(spliter.split("abaa"),
                equalTo(Lists.newArrayList(Lists.newArrayList("a", "b", "a", "a"),
                        Lists.newArrayList("aba", "a"),
                        Lists.newArrayList("a", "b", "aa"))));
    }
}
