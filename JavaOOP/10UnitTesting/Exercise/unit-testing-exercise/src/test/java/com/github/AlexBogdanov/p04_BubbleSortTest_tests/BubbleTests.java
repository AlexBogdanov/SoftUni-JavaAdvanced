package com.github.AlexBogdanov.p04_BubbleSortTest_tests;

import com.github.AlexBogdanov.p04_BubbleSortTest.Bubble;

import org.junit.Assert;
import org.junit.Test;

public class BubbleTests {

    @Test
    public void should_sort_correctly() {
        // GIVEN
        int[] arr = { 7, -4, 12, 97, 0, -5 };

        // WHEN
        Bubble.sort(arr);

        // THEN
        int[] exp = { -5, -4, 0, 7, 12, 97 };
        Assert.assertArrayEquals(exp, arr);
    }

}
