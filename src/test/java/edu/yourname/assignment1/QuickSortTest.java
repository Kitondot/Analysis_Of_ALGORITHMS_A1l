package edu.yourname.assignment1;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class QuickSortTest {
    @Test
    public void testCorrectness() {
        int[] a={10,7,8,9,1,5};
        int[] expected=a.clone();
        Arrays.sort(expected);
        Metrics m=new Metrics();
        QuickSort.sort(a,m);
        assertArrayEquals(expected,a);
    }
}
