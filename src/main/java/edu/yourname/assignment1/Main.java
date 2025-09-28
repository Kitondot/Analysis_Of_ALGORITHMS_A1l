package edu.yourname.assignment1;

import java.io.IOException;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length < 6) {
            System.out.println("Usage: <algorithm> <out.csv> <minN> <maxN> <factor> <trials>");
            return;
        }
        String algo = args[0];
        String out = args[1];
        int minN = Integer.parseInt(args[2]);
        int maxN = Integer.parseInt(args[3]);
        int factor = Integer.parseInt(args[4]);
        int trials = Integer.parseInt(args[5]);

        CSVWriter.writeHeader(out);

        for (int n=minN; n<=maxN; n*=factor) {
            for (int t=0;t<trials;t++) {
                int[] a = randomArray(n);
                Metrics m = new Metrics();
                long t0=System.nanoTime();
                if (algo.equals("mergesort")) MergeSort.sort(a,m);
                else if (algo.equals("quicksort")) QuickSort.sort(a,m);
                else if (algo.equals("select")) DeterministicSelect.select(a,n/2,m);
                else throw new IllegalArgumentException("Unknown algo "+algo);
                long t1=System.nanoTime();
                long time=t1-t0;
                String line=String.format("%s,%d,%d,%d,%d,%d",algo,n,time,m.getMaxDepth(),m.getComparisons(),m.getAllocations());
                CSVWriter.appendLine(out,line);
            }
        }
    }

    private static int[] randomArray(int n){
        Random r=new Random();
        int[] a=new int[n];
        for(int i=0;i<n;i++)a[i]=r.nextInt();
        return a;
    }
}
