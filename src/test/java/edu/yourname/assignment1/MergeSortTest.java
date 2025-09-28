package edu.yourname.assignment1;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class MergeSortTest {
    @Test
    public void testCorrectness() {
        int[] a = {5,3,8,1,2};
        int[] expected=a.clone();
        Arrays.sort(expected);
        Metrics m=new Metrics();
        MergeSort.sort(a,m);
        assertArrayEquals(expected,a);
    }
}
