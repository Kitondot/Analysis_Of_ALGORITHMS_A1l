package edu.yourname.assignment1;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;


public class SelectTest {
    @Test
    public void testCorrectness() {
        int[] a={9,3,7,1,5};
        int[] sorted=a.clone();
        Arrays.sort(sorted);
        Metrics m=new Metrics();
        int k=2;
        int res=DeterministicSelect.select(a,k,m);
        assertEquals(sorted[k],res);
    }
}
